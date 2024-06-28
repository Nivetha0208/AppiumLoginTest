# AppiumLoginTest
This project demonstrates automated login tests for a web application using Appium with TestNG.

Project Structure
The project structure includes the following components:

utilis.DriverSetup: Java class to set up Appium drivers for iOS and Android.
pages.LoginPage: Java class defining page interactions for the login functionality.
tests.LoginTest: TestNG test class containing test cases for login functionality on iOS and Android.
pom.xml: Maven project configuration file with dependencies and plugins.
README.md: This file, providing an overview of the project.


Dependencies
The project uses the following dependencies managed by Maven:
TestNG: Version 7.4.0 for test management and assertions.
Selenium WebDriver: Version 4.1.0 for browser automation.
Appium Java Client: Version 7.5.0 for mobile automation with Appium.


Setup and Execution
Prerequisites
Ensure you have the following installed on your system:
Java JDK (version 8 or higher)
Maven (version 3.5 or higher)
Appium Server (running on http://localhost:4723)


Test Cases
ValidLoginIOS: Verifies successful login on iOS using valid credentials.
InvalidLoginIOS: Checks error message display on iOS for invalid login attempt.
ValidLoginAndroid: Tests successful login on Android with correct username and password.
InvalidLoginAndroid: Validates error message appearance on Android for incorrect login details.


Notes
Adjust the url in LoginPage class to match your application's login page URL.
Ensure Appium server is running and configured correctly before running tests.
Customize tests and assertions as per your application's specific requirements.
