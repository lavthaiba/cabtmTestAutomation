**Test Automation Framework with Page Object Model (POM) and TestNG**
This is a robust and maintainable test automation framework designed using the Page Object Model (POM) and powered by TestNG. The framework aims to provide efficient and organized automation for web application testing.

**Key Features:**
**Modular Architecture:** The framework follows a modular architecture, dividing the test code into separate modules or classes. Each module represents different parts of the application or specific test scenarios, making the code more organized and easier to maintain.

**Page Object Model (POM):** The framework adheres to the principles of the Page Object Model design pattern. Each web page in the application is represented as a Page Object, encapsulating the page's elements and functionalities. Test scripts interact with these Page Objects to perform actions and validations, promoting code reusability and reducing maintenance efforts.

**TestNG Testing Framework:** TestNG is the testing framework of choice for this automation framework. It allows for easy test configuration, parallel test execution, and better reporting. ExtentReports is integrated into TestNG to provide detailed and visually appealing test reports.

**Configurable Test Data:** The framework allows test data to be easily managed and configured through the config.properties file. The use of properties files ensures that sensitive data, such as URLs, usernames, and passwords, are securely managed.

**Test Scripts:**
**LoginTest:** This test script verifies the login functionality of the application. It uses the Dashboard class to perform the login action and validate the welcome message displayed upon successful login.

**DashboardPageTest:** This test script focuses on the dashboard page's functionality. It verifies the presence of various sections on the "System Dashboard" page using the Dashboard class.

**How to Use**:

Clone the repository to your local environment.

Set up the config.properties file with the appropriate test data, including the base URL, username, password, and browser choice.

Run the test scripts using TestNG for parallel execution and detailed reporting.

The test results, along with a visually appealing Extent Report, will be generated for each test execution.

Advantages:
**Scalable and Maintainable:** The modular architecture allows easy addition or modification of test scenarios without impacting other parts of the framework.

**Reusability:** The Page Object Model ensures the reusability of test components across multiple test cases.

**Easy Configuration:** The config.properties file allows quick changes to test data without altering the test code.

**Reliable Reporting:** TestNG along with ExtentReports provides comprehensive and visual test reports for easy analysis.

This test automation framework enables efficient and reliable testing of web applications while promoting code maintainability and reusability through the Page Object Model and TestNG. Feel free to contribute to the repository or customize the framework to suit your specific testing needs.

**Note:** To ensure data security, sensitive information such as passwords should be managed separately in an encrypted file or via environment variables when deploying the framework in production environments.

**Cabtm Test Automation**
This repository contains the test automation framework and test scripts for the Cabtm application. The automation framework is built using Java, TestNG, Selenium WebDriver, and ExtentReports for reporting. It provides a set of reusable functions and test scripts to automate the testing of various features of the Cabtm application.

## Table of Contents

- [Installation](#installation)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)
- [Contributing](#contributing)
- [License](#license)

...

## Installation
To get started with the test automation, follow the steps below:

Clone the repository to your local machine:

Copy code

git clone https://github.com/lavthaiba/cabtmTestAutomation.git

Install the required dependencies. Make sure you have Java JDK and Maven installed on your machine.

Download the appropriate WebDriver executable (chromedriver or geckodriver) for your browser and place it in the project's resources folder.

...

## Configuration

Before running the test scripts, you need to set up the configuration files with the required test data.

**config.properties:** This file contains the base URL of the Cabtm application and other configuration settings. Update the baseURL={desiredURL}, and browser={desiredBrowser} all in lowercase. This file resides on ../test/resources/config.properties 

**secrets.properties:** This file is used to store sensitive information like passwords or API keys. Add the sensitive information, such as the username and password, to this file. And this is handled by .gitignore for not providing permission to clone this file. Create new file named "secrets.properties" or update the username={yourUsername} and password={yourPassword} all in lowercase. This file also resides on ../test/resources/secrets.properties 

...

## Running Tests

To run the test scripts, use the following command:

**Command Line**
mvn test

The test scripts will execute in the selected browser (Chrome or Firefox) as specified in the config.properties file.

...

## Test Reports

The test reports are generated using ExtentReports, and they provide detailed information about the test execution, including test status, test steps, and screenshots (if configured). After running the tests, the HTML report will be available in the test-output folder with the name ExtentReport.html.

...

## Contributing

We welcome contributions to improve the test automation framework and test scripts. To contribute, please follow these steps:

1. Fork the repository on GitHub.
2. Create a new branch from the master branch for your changes.
3. Make your changes and commit them to your branch.
4. Push your branch to your fork on GitHub.
5. Create a pull request to merge your changes into the master branch of this repository.

We will review your pull request and provide feedback before merging.

...

## License

This project is licensed under the MIT License.




