#  Bookstore API Automation Framework

[![GitHub status](https://github.com/MarkoDev-Apps/Avenga_Task/actions/workflows/ci.yml/badge.svg)](https://github.com/MarkoDev-Apps/Avenga_Task/actions/workflows/ci.yml)

[![Docker Image](https://img.shields.io/badge/docker--ready-blue)](https://hub.docker.com/r/markosdet/api-tests)


##  Tech Stack

- Java + RestAssured + TestNG
- Maven
- Docker
- Allure Reporting
- GitHub Actions (CI/CD)

---

##  Run Locally

###  Prerequisites

- Java 17+
- Maven
- Docker
- Allure CLI (for report generation)

---

###  Run Tests with Maven

```bash

mvn clean test -DBASE_URL=https://fakerestapi.azurewebsites.net

````
_**RUN TESTS IN DOCKER**_
```bash

docker build -t api-tests .
docker run --rm -v ${PWD}/allure-results:/app/target/allure-results api-tests
This command mounts the allure results folder so you can generate the report afterward.
```
_**GENERATE ALLURE REPORTS**_
```bash

allure generate target/allure-results --clean -o allure-report
allure open allure report
Open the report HTML page

If you experience PowerShel execution problem open PowerShel as Administrator mode and run
command Set-ExecutionPolicy RemoteSigned -Scope CurrentUser and press Y.
```
_**CI/CD PIPELINE**_

- Triggered on every push or pull request
- Builds Docker image
- Executes tests
- Allure results can be optionally uploaded as build artifacts

_**PROJECT STRUCTURE**_
- src/test/java/com/bookstore/api/tests       --> Test classes (Books, Authors)
- src/test/java/com/bookstore/api/utils       --> Test payloads
- Dockerfile                                  --> Docker build setup
- pom.xml                                     --> Project dependencies
- allure-results/                             --> Allure raw test results
- allure-report/                              --> Allure generated report

**_AUTHOR_**

- Created by Marko Ivanovic for the Avenga Automation API Test Assessment.


