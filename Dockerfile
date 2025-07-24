FROM maven:3.9.6-eclipse-temurin-17-alpine

WORKDIR /app

COPY . .

RUN mvn clean install

# Optional: run tests during image build (can be skipped to defer test execution to runtime)
# RUN mvn clean test

# Default command to run tests with base URL
CMD ["mvn", "test", "-DBASE_URL=https://fakerestapi.azurewebsites.net"]
