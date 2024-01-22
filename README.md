
Framework Components:

1.	TestNG: Framework for organizing and running test cases.
2.	Selenium API: Automation tool for web application testing.
3.	Apache Commons: Library providing reusable Java components.
4.	Jackson: JSON processing library for Java.
5.	Extent Reports: Reporting tool for generating interactive and detailed test reports.
6.	Maven: Build automation tool for managing project dependencies and builds.
7.	Maven Profiling Integration: Integration for Maven to support different environment configurations.
8.	Java: Programming language for developing automation scripts.


Framework Structure:
1.	Page Object Model (POM) Design Pattern: Each page of the application has its dedicated class in the 'pages' package.
2.	AbstractComponents Package: Contains 'CustomWaits' for handling customized waiting mechanisms.
3.	Resources Package:
I.	ExtentReportNG for creating Extent Report objects.
II.	Properties File for managing global data across the project.
4.	TestComponents Package:
I.	BaseTest class:
a.	SetupDriver: Configures different drivers (e.g., Chrome, Firefox).
b.	Setup functions executed before and after test methods.
c.	Loads JSON data files for test scenarios.
II.	ListenerHelper class: Implements 'ITestListener' for creating detailed test reports.
III.	Retry class: Implements 'IRetryAnalyzer' for setting up test retry mechanism.
5.	Data Package: Manages JSON files containing test data.
6.	TestNG: Utilizes features like 'priority', 'description', 'dataProvider', and 'groups' for  organized test execution.


        
                

