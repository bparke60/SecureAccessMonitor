# Use a lightweight Java image
FROM openjdk:17-jdk-slim

# Create app directory
WORKDIR /app

# Copy project files into the container
COPY . .

# Compile the Java files
RUN javac Main.java

# Run the app
CMD ["java", "Main"]
