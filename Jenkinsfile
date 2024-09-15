
pipeline
{
    agent any
    tools
    {
        maven 'Maven3'
        jdk 'java17'
    }
    environment
    {
        APP_NAME = "spring-boot-api"
        RELEASE = "1.0.0"
        DOCKER_USER = 'sudipdas2001'
        DOCKER_PASS = 'dockerhub'
        IMAGE_NAME = "${DOCKER_USER}" + "/" + "${APP_NAME}"
        IMAGE_TAG = "${RELEASE}-${BUILD_NUMBER}"
    }

    stages
    {
        // Checkout the code from the repository
        stage('Checkout')
        {
            // Checkout the code from the repository
            // credentialsId is the id of the credentials added in Jenkins
            // url is the URL of the repository
            steps
            {
                git branch: 'main', credentialsId: 'github', url: 'https://github.com/dassudip2001/spring-boot-api.git'
            }
        }

        // Build the project
        stage('Build')
        {
            // Build the project
            steps
            {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker')
        {
            steps {
                script {
                    docker.withRegistry('',DOCKER_PASS) {
                        docker_image = docker.build "${IMAGE_NAME}"
                    }

                    docker.withRegistry('',DOCKER_PASS) {
                        docker_image.push("${IMAGE_TAG}")
                        docker_image.push('latest')
                    }
                }
            }
        }
    }
}
