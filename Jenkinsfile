pipeline {
    agent any

    tools {
        maven "maven"
        jdk "jdk23"
        sonarQube "Sonar Scanner" // Add SonarQube scanner tool
    }

    environment {
        PROJECT_DIR = "C:\\Users\\suhas\\Documents\\IDEA Projects\\DevSecOps Sample Project"
        JAR_FILE = "${PROJECT_DIR}\\target\\springboot-jsonplaceholder-1.0.0.jar"
        POM_FILE = "${PROJECT_DIR}\\pom.xml"
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    try {
                        checkout scm
                    } catch (Exception e) {
                        error "Checkout stage failed: ${e.message}"
                    }
                }
            }
        }
        stage('Testing') {
            steps {
                script {
                    try {
                        bat "javac -version"
                        bat "mvn -version"
                    } catch (Exception e) {
                        error "Testing stage failed: ${e.message}"
                    }
                }
            }
        }
        stage('Compile') {
            steps {
                script {
                    try {
                        bat "mvn clean package -f \"${POM_FILE}\""
                    } catch (Exception e) {
                        error "Compile stage failed: ${e.message}"
                    }
                }
            }
        }
        stage('SonarQube Analysis') { // New stage for SonarQube analysis
            steps {
                script {
                    try {
                        bat "mvn sonar:sonar -Dsonar.projectKey=Spring-Demo-App -Dsonar.projectName='Spring Demo App' -Dsonar.host.url=http://localhost:9000 -Dsonar.token=sqp_676008355af18a461a3120b7b2471952b6c772f3"
                    } catch (Exception e) {
                        error "SonarQube Analysis stage failed: ${e.message}"
                    }
                }
            }
        }
        stage('Run') {
            steps {
                script {
                    try {
                        bat "java -jar \"${JAR_FILE}\""
                    } catch (Exception e) {
                        error "Run stage failed: ${e.message}"
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
        success {
            echo 'Pipeline succeeded.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}