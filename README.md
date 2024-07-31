# Playwright Playground

## Goal
To have a unified framework that can cover both UI and API testing at the
same time without the need to use multiple separate libraries and
increased complexity.

## Required tools:
- [Java 22](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Allure reporting](https://allurereport.org/)

## To Run:
```bash
mvn clean test -Dheadless=true -Dbrowser=CHROME
```

## To Generate the test report:
```bash
allure serve target/allure-results
```
