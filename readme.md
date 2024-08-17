# Test Automation Project

This project is a comprehensive test automation suite designed to validate various functionalities of a web application, including UI testing, API testing, and cross-browser testing using Selenium Grid and Docker. The suite includes features like data-driven tests, parallel execution, and detailed reporting.

## Prerequisites

- Java 17
- Maven 3.6+
- Docker
- Chrome, Firefox, and Edge browsers

## Setup

1. Clone the repository:
```bash
git clone https://github.com/berattemizel/examples.git
```
2. Navigate to the project directory:
```bash
cd test-automation
```
3. Install dependencies:
```bash
mvn clean install
```
## Running Tests

### UI Tests

To run UI tests in parallel across different browsers:
```bash
mvn test -Dsurefire.suiteXmlFiles=testng.xml
```

### API Tests

To run API tests:
```bash
mvn test -Dtest=ApiTest
```

### Generating Reports

To generate an Allure report after running tests:
```bash
mvn allure:serve
```

## Docker & Selenium Grid

The project includes a `docker-compose.yml` file to set up Selenium Grid for running tests in parallel on different browsers in a containerized environment.

1. Start the Selenium Grid:
   
```bash
docker-compose up -d
```
2. Run the tests as mentioned above.

## Project Structure

- **src/main/java/com/example/factory**
  - `DriverFactory.java`: Manages the creation and configuration of WebDriver instances.

- **src/main/java/com/example/pages**
  - `BasePage.java`: The parent class for all page objects, containing common methods.
  - `BoutiquePage.java`: Page object class for handling operations on the Boutique page.
  - `LoginPage.java`: Page object class for handling login page operations.

- **src/main/java/com/example/util**
  - `ApiHelper.java`: Contains methods for interacting with APIs.
  - `Constants.java`: Defines constants used throughout the project.
  - `CSVWriterUtil.java`: Contains methods for writing data to CSV files.
  - `LoadTimeCalculator.java`: Utility class for calculating load times.
  
- **src/test/java/com/example/tests**
  - `ApiTest.java`: Contains API test cases.
  - `BaseTest.java`: Base class for test cases, handling setup and teardown.
  - `CollectBoutiqueLinksTest.java`: Test class for collecting and validating boutique links.
  - `LoginTest.java`: Contains test cases for login functionality.
  - `ReportingTest.java`: Test class for generating reports.

- **docker-compose.yml**
  - Configuration file for Docker Compose, used to set up Selenium Grid for parallel cross-browser testing.

- `testng.xml`: Configuration file for TestNG.
  
- `allure-results`: Directory where Allure test results are stored.
  
- `screenshots`: Directory where screenshots of failed tests are saved.
  

