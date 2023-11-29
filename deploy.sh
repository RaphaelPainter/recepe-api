#https://medium.com/@KTree_Blog/auto-deployment-of-spring-boot-applications-to-aws-ecs-with-jenkins-3ef5245f5e7e

# prerequis :
# aws configure
# docker login -u AWS -p $(aws ecr get-login-password --region eu-west-3) 435683540071.dkr.ecr.eu-west-3.amazonaws.com
# aws ecr create-repository --repository-name <REPOSITORY_NAME>
# aws ecs create-cluster --cluster-name ${CLUSTER_NAME} --visible-to-all-users
# aws ecs create-service --cluster recipe-api-cluster --service-name recipe-api-service --visible-to-all-users --task-definition recipe-api-task-family --desired-count 1

#see cluster on gui : https://eu-west-3.console.aws.amazon.com/ecs/v2/clusters?region=eu-west-3

REPOSITORY_NAME=recipe-api-rep
echo "AWS REPOSITORY_NAME : "${REPOSITORY_NAME}
TASK_FAMILY=recipe-api-task-family
echo "AWS TASK FAMILY : "${TASK_FAMILY}
CLUSTER_NAME=recipe-api-cluster
echo "AWS CLUSTER: "${CLUSTER_NAME}
SERVICE_NAME=recipe-api-service
echo "AWS SERVICE: "${SERVICE_NAME}
REGION=eu-west-3
echo "AWS REGION: "${REGION}
recipe-api-rep:1.0
DOCKER_REPO=`aws ecr describe-repositories --region $REGION --repository-names $REPOSITORY_NAME | grep repositoryUri | cut -d '"' -f 4`
echo "docker-repo : "$DOCKER_REPO

echo "building : "$DOCKER_REPO " ..."
docker build --no-cache -t ${DOCKER_REPO}:1.0 .

echo "pushing : "$DOCKER_REPO " ..."
docker push ${DOCKER_REPO}:1.0

DOCKER_TAG=`aws ecr list-images --region $REGION --repository-name $REPOSITORY_NAME | grep imageTag | head -n 1 | cut -d '"' -f 4`
echo "DOCKER_TAG : "${DOCKER_TAG}

echo "updating aws template ..."
sed -e "s;FAMILY;${TASK_FAMILY};g" ./aws-template.json > taskDefinition.json
sed -e "s;DOCKER_IMAGE_NAME;${DOCKER_REPO}:${DOCKER_TAG};g" ./aws-template.json > taskDefinition.json

echo "registering task ..."
TASK=`aws ecs register-task-definition --region $REGION --family ${TASK_FAMILY} --cli-input-json file://taskDefinition.json`

echo "getting task revision..."
REVISION=`aws ecs describe-task-definition --region $REGION --task-definition ${TASK_FAMILY} | grep "revision" | tr -s " " | cut -d " " -f 3 | sed 's/,//g'`
echo "revision: "$REVISION

echo "updating service..."
UPDATE_SERVICE=`aws ecs update-service --region $REGION --cluster ${CLUSTER_NAME} --service ${SERVICE_NAME} --task-definition ${TASK_FAMILY}:${REVISION} --desired-count 1`

aws ecs create-cluster --cluster-name recipe-api-cluster-2 --visible-to-all-users

