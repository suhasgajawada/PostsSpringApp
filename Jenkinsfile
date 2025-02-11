pipeline {
    agent any

    tools {
        maven "maven"
        jdk "jdk23"
    }

    environment {
        PROJECT_DIR = "C:\\Users\\suhas\\Documents\\IDEA Projects\\DevSecOps Sample Project"
        JAR_FILE = "${PROJECT_DIR}\\target\\springboot-jsonplaceholder-1.0.0.jar"
        POM_FILE = "${PROJECT_DIR}\\pom.xml"
    }

    stages {
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