pipeline {
	agent any
    tools {
        maven 'jenkins-maven'
    }
	environment {
		mavenHome = tool 'jenkins-maven'
	}


	stages {

		stage('Build'){
			steps {
				 sh "mvn clean install -DskipTests"
			}
		}

		stage('Test'){
			steps{
				sh "mvn test"
			}
		}

		stage('Deploy') {
			
		}
	}
}