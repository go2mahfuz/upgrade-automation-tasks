package com.upgrade.ui.automation.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import com.upgrade.ui.automation.dataproviders.ConfigurationReader;
import com.upgrade.ui.automation.managers.PageObjectManager;
import com.upgrade.ui.automation.pages.CheckRate;

	public class PersonalLoans {
		WebDriver driver;
		PageObjectManager pageObjectManager;
		CheckRate checkRate;
		ConfigurationReader configurationReader;

	@Given("^User is on personal loans page$")
	public void userIsOnPersonalLoanspage() {
		configurationReader = new ConfigurationReader();
		System.setProperty("webdriver.chrome.driver", configurationReader.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(configurationReader.getApplicationUrl());
		pageObjectManager = new PageObjectManager(driver);
		checkRate = pageObjectManager.getCheckRate();
	}
	
	@When("^I enter any amount$")
	public void iEnterAmount() {
		checkRate = pageObjectManager.getCheckRate();
		checkRate.enterAmount("20000");
	}
	
	@When("^I select loan purpose$")
	public void iSelectLoanPurpose() {
	    checkRate.itemFromList();
	}
	
	@And("I click on Check Rate button$")
	public void i_click_on_check_button() {
	    checkRate.clickOnRateButton();
	}
	
	@When("^I enter personal details information$")
	public void i_enter_first_name_and_last_name() {
	    checkRate.enterFirstName("John");
	    checkRate.enterLastName("Smith");
	    checkRate.enterAddress("120 Scott Dr");
	    checkRate.enterCity("Menlo Park");
	    checkRate.enterState("CA");
	    checkRate.enterZipCode("94025");
	    checkRate.enterDOB("01/03/1984");	    
	   }
	
	@And("^I click on Continue button$")
	public void iClickOnContinueButton() {
		checkRate.clickOnContinueButton();
	}
	
	@When("^I add borrower income and additional income$")
	public void iAddBorrowerIncomeAndAdditionalIncome() {
		checkRate.enterBorrowerIncome("130000");
		checkRate.enterBorrowerAddIncome("6000");
	}
	
	@And("^I click Continue button$")
	public void iClickContinueButton() {
		checkRate.clickElement();
	}
		
	@When("^I enter user credentials and submit$")
	public void iEnterUserCredentials() {
	
		checkRate.enterUserName("mahfuz456@upgrade-challenge.com");
		checkRate.enterPassword("P12345678r");
		checkRate.selectAgreements();
		checkRate.btnCheckRate();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		checkRate.storeData();
	}
	
	@When("^I Sign out the application$")
	public void iSignOutTheApplication(){
		checkRate.signOut();
		driver.close();
	}
	
	@When("^I Login to the application$")
	public void iLoginToTheApplication() {
		configurationReader = new ConfigurationReader();
		System.setProperty("webdriver.chrome.driver", configurationReader.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(configurationReader.getLoginUrl());
		pageObjectManager = new PageObjectManager(driver);
		checkRate = pageObjectManager.getCheckRate();
		checkRate.enterUserName("mahfuz456@upgrade-challenge.com");
		checkRate.enterPassword("P12345678r");
		checkRate.login();
	}
	
	@When("^I validate loans information$")
	public void iValidateLoansInformation() {
		checkRate.validateAfterLogin();
		driver.close();
	}
}