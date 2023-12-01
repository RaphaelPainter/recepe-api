# ---------------------------------------------------------------------------------------------------------------------
# APPRUNNER Service
# ---------------------------------------------------------------------------------------------------------------------

resource "aws_apprunner_service" "service" {
  auto_scaling_configuration_arn = aws_apprunner_auto_scaling_configuration_version.auto-scaling-config.arn
  service_name                   = "apprunner-recipe-api"
  source_configuration {
    authentication_configuration {
      access_role_arn = aws_iam_role.apprunner-service-role.arn
    }
    image_repository {
      image_configuration {
        port = var.container_port
        runtime_environment_variables = {
          "AWS_REGION" : "${var.aws_region}",
        }
      }
      image_identifier      = "${var.image_identifier}:latest"
      image_repository_type = "ECR"
    }
  }
  instance_configuration {
    instance_role_arn = aws_iam_role.apprunner-instance-role.arn
  }
  depends_on = [aws_iam_role.apprunner-service-role,  aws_route_table.private-route-table, null_resource.recipe-api_springboot]
}

output "apprunner_service_url" {
  value = "https://${aws_apprunner_service.service.service_url}"
}