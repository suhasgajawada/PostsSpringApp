# Use an official OpenJDK runtime as a parent image
FROM openjdk:23

# Copy the packaged jar file into the container
COPY target/springboot-jsonplaceholder-1.0.0.jar app.jar

# Make port 8079 available to the world outside this container
EXPOSE 8079

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]