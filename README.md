To Run Jenkins:
1. Run the following command in the terminal:
```java -jar jenkins.war --enable-future-java```
2. Open a browser and go to the following URL:
```http://localhost:8080/```
3. Follow the instructions to complete the setup.
4. Install the necessary plugins.
5. Create an admin user.
6. Start using Jenkins.


To Create Docker Image:
1. Run the following command in the terminal:
```docker build -t jenkins-docker-sonar .``` # This will create a docker image with the name jenkins-docker-sonar.
2. Run the following command in the terminal:
```docker run -i -d -t --name jenkins-docker-sonar -p 7777:8079 jenkins-docker-sonar:latest``` # This will run the docker image with the name jenkins-docker-sonar.

To run SonarQube:
Setup SonarQube:
1. Create volumme for SonarQube:
```docker volume create --name sonarqube_data``` # This will create a volume with the name sonarqube_data.
```docker volume create --name sonarqube_extensions``` # This will create a volume with the name sonarqube_extensions.
```docker volume create --name sonarqube_logs``` # This will create a volume with the name sonarqube_logs.
2. Run the following command in the terminal:
```docker run -d --name sonarqube -p 9000:9000 -v sonarqube_data:/opt/sonarqube/data -v sonarqube_extensions:/opt/sonarqube/extensions -v sonarqube_logs:/opt/sonarqube/logs sonarqube:latest``` # This will run the SonarQube docker image.
3. Open a browser and go to the following URL:
```http://localhost:9000/``` # This will open the SonarQube dashboard.
4. Login with the following credentials:
```Username: admin```
```Password: admin```
5. Create a new project and generate a token.
6. Copy the token and use it in the Jenkins pipeline.

To Run Jenkins Pipeline:
1. Open Manage Jenkins -> Manage Plugins -> Available -> Search for "SonarQube Scanner" -> Install the plugin.
2. Open Manage Jenkins -> Configure System -> SonarQube servers -> Add SonarQube -> Enter the following details:
```Name: SonarQube```
```Server URL: http://localhost:9000/```
```Server authentication token: <SonarQube token>``` # Enter the token generated in SonarQube.
3. Open The Pipeline which we already created -> Manage -> Configure -> Pipeline -> Enter the following script:
```stage('Sonar Scan') {
    steps {
        withSonarQubeEnv('SonarQube') {
            sh 'mvn sonar:sonar'
        }
    }
}```
            