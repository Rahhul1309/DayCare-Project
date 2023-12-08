# Use an official Maven runtime as a parent image
FROM maven:3.8.4-openjdk-17

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the project POM file to the container
COPY pom.xml .

# Build all dependencies for caching
RUN mvn dependency:go-offline -B

# Copy the project source code to the container
COPY src ./src

# Package the application
RUN mvn package
