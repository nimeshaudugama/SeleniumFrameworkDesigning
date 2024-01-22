
Framework Components:

o	TestNG: Framework for organizing and running test cases.
o	Selenium API: Automation tool for web application testing.
o	Apache Commons: Library providing reusable Java components.
o	Jackson: JSON processing library for Java.
o	Extent Reports: Reporting tool for generating interactive and detailed test reports.
o	Maven: Build automation tool for managing project dependencies and builds.
o	Maven Profiling Integration: Integration for Maven to support different environment configurations.
o	Java: Programming language for developing automation scripts.


Framework Structure:
1.	Page Object Model (POM) Design Pattern: Each page of the application has its dedicated class in the 'pages' package.
2.	AbstractComponents Package: Contains 'CustomWaits' for handling customized waiting mechanisms.
3.	Resources Package:
        ExtentReportNG for creating Extent Report objects.
        Properties File for managing global data across the project.
4.	TestComponents Package:
BaseTest class:
        SetupDriver: Configures different drivers (e.g., Chrome, Firefox).
        Setup functions executed before and after test methods.
        Loads JSON data files for test scenarios.
ListenerHelper class: Implements 'ITestListener' for creating detailed test reports.
Retry class: Implements 'IRetryAnalyzer' for setting up test retry mechanism.
5.	Data Package: Manages JSON files containing test data.
6.	TestNG: Utilizes features like 'priority', 'description', 'dataProvider', and 'groups' for organized test execution.

