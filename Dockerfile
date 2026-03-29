# Use a valid Java 17 base image
FROM eclipse-temurin:17-jdk-focal

# Set working directory in the container
WORKDIR /app

# Copy the Maven wrapper and project files
COPY . .

# Build the project using the Maven wrapper
RUN ./mvnw clean package -DskipTests

# Expose the port your app runs on
EXPOSE 8080

# Run the Spring Boot jar
CMD ["java", "-jar", "target/TennisScheduler-0.0.1-SNAPSHOT.jar"]