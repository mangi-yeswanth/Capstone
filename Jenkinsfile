pipeline {
    agent any

    tools {
        maven 'Maven3'   // Set this name in Jenkins Global Tool Configuration
        jdk 'Java11'     // Same here
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/your-org/your-repo.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean install'
            }
            post {
                always {
                    // Publish test results
                    junit '**/target/surefire-reports/*.xml'
                }
                success {
                    // Archive built artifacts
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
    }

    post {
        success {
            echo 'Build & Test completed successfully'
        }
        failure {
            echo 'Build failed'
        }
    }
}

