package com.upgrade.ui.automation.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/Loans", glue = "com.upgrade.ui.automation.steps", plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/com.upgrade.ui.automation.cucumber-reports/report.html" }, monochrome = true)

public class E2ETest {

}
