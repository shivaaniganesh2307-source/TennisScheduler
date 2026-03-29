# Use official OpenJDK 17 slim image
FROM openjdk:17-slim

# Set working directory
WORKDIR /app

# Copy the built jar
COPY target/*.jar app.jar

# Use Render's dynamic PORT
ENV PORT ${PORT}
EXPOSE ${PORT}

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]