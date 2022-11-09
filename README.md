#  QA Coding Challenge  #

**UI tests:** Run this JUnit file: E2ETest.java for UI Tests. I have given brief description for the design of test automation. Report file can be found: C:\upgrade-automation-tasks\target\com.upgrade.ui.automation.cucumber-reports

**API tests:** LoanApiTests.java file. Run this file.

# **Overview** #

The cucumber BDD testing framework designed for demoing Upgrade test suite as written from the view of the Product Owner. Using keywords such as Given, When, Then and And, acceptance criteria tests known as feature files can then be broken down into testable steps.

**Cucumber Selenium** - Overall test framework leveraging the Cucumber framework with Selenium WebDriver written in JAVA.

**Feature File** - The feature file specifies the steps in BDD language style.

**Step Definition Feature File** - Java class whereby the steps from the feature file are broken down to be coded into automation tests.

**Page Object Design** Pattern with Selenium Page Factory in Cucumber - Page Object Model Framework which is also known as Page Object Design Pattern or Page Objects. The main advantage of Page Object Model is that if the UI or any HTML object changes for any page, the test does not need any fix. Only the code within the page objects will be impacted but it does not have any impact to the test.

**Page Object Manager** - In the case of multiple-step definition files, we will be creating an object of Pages again and again which is against the coding principle. To avoid this situation, we can create a Page Object Manager. The duty of the Page Object Manager is to create the page’s object and also to make sure that the same object should not be created again and again. But to use a single object for all the step definition files.

**Feature PageObject Class** - Java class whereby the necessary HTML objects are captured as WebElements to be manipulated by the associated model class.

**ChromeDriver.exe** - This demo framework only supports Chrome browser. It's in the Driver folder.

**Cucumber Extent Report** - This report provides nice features to make report impressive. This is an awesome plugin that is built on Extent Report specially for Cucumber. Location for the report file: C:\upgrade-automation-tasks\target\com.upgrade.ui.automation.cucumber-reports

