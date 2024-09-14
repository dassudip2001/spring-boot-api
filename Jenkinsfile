
pipeline
{
    
    tools
    {
        maven 'Maven3'
        jdk 'java17'
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
                sh 'mvn clean package'
            }
        }
    }
}
