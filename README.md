To Run Jenkins:
1. Run the following command in the terminal:
```java -jar jenkins.war --enable-future-java```
2. Open a browser and go to the following URL:
```http://localhost:8080/```
3. Follow the instructions to complete the setup.
4. Install the necessary plugins.
5. Create an admin user.
6. Start using Jenkins.
```

To Create Docker Image:
1. Run the following command in the terminal:
```docker build -t jenkins-docker-sonar .``` # This will create a docker image with the name jenkins-docker-sonar.
2. Run the following command in the terminal:
```docker run -i -d -t --name jenkins-docker-sonar -p 7777:8079 jenkins-docker-sonar:latest``` # This will run the docker image with the name jenkins-docker-sonar.
