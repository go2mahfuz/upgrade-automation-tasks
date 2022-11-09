package com.upgrade.ui.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.junit.Assert;


public class CheckRate {
	public static String loanAmount, monthlyPayment, term1, apr;
	WebDriver driver;
	
	JavascriptExecutor executor;
	public CheckRate(WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor) this.driver;
		PageFactory.initElements(driver, this);
		
}
	@FindBy(how = How.NAME, using = "desiredAmount") 
	private WebElement textdesiredAmount;
	
	@FindBy(how = How.CSS, using = "button[data-auto='CheckYourRate']")
	private WebElement checkRateButton;

	@FindBy(how = How.CSS, using = "button[data-auto='CheckYourRate']")
	private WebElement checkRateButton1;


	@FindBy(how = How.CSS, using = "select[data-auto='dropLoanPurpose']")
	private WebElement selectList;
	
	@FindBy(how = How.NAME, using = "borrowerFirstName")
	private WebElement firstName;
	
	@FindBy(how = How.NAME, using = "borrowerLastName")
	private WebElement lastName;
	
	@FindBy(how = How.CSS, using = "input[data-auto='borrowerStreet']")
	private WebElement street;
	
	@FindBy(how = How.CSS, using = "input[data-auto='borrowerCity']")
	private WebElement city;
	
	@FindBy(how = How.CSS, using = "input[data-auto='borrowerState']")
	private WebElement state;
	
	@FindBy(how = How.CSS, using = "input[data-auto='borrowerZipCode']")
	private WebElement zipCode;
	
	@FindBy(how = How.CSS, using = "input[data-auto='borrowerDateOfBirth']")
	private WebElement dob;
	
	@FindBy(how = How.CSS, using = "button[data-auto='continuePersonalInfo']")
	private WebElement buttonContinue;
	
	@FindBy(how = How.CSS, using = "input[data-auto='borrowerIncome']")
	private WebElement borrowerIncome;
	
	@FindBy(how = How.CSS, using = "input[data-auto='borrowerAdditionalIncome']")
	private WebElement borrowerAdditionalIncome;
	
	@FindBy(how = How.CSS, using = "button[data-auto='continuePersonalInfo']") 
	private WebElement element;
	
	@FindBy(how = How.NAME, using = "username")
	private WebElement userName;
	
	@FindBy(how = How.NAME, using = "password")
	private WebElement passwd;
	
	@FindBy(how = How.XPATH, using = "//span[text()=', and for Upgrade to verify my income.']")
	private WebElement agreement;

	@FindBy(how = How.CSS, using = "button[data-auto='submitPersonalInfo']")
	private WebElement buttonCheckRate;
	
	@FindBy(how = How.CSS, using = "span[data-auto='amount']") WebElement loanAmnt;
	@FindBy(how = How.CSS, using = "div[data-auto='monthlyPayment']") WebElement monPayment;
    @FindBy(how = How.CSS, using = "div[data-auto='term']") WebElement term;
    @FindBy(how = How.CSS, using = "div[data-auto='apr']") WebElement aprElement;
    
    @FindBy(how = How.XPATH, using ="//a[contains(text(),'Sign Out')]") WebElement signOut;
    @FindBy(how = How.CSS, using = "button[data-auto='login']")
	private WebElement login;
    
    //@FindBy(linkText="Sign Out") WebElement signOut;
    
	public void enterAmount(String amount) {
		textdesiredAmount.sendKeys(amount);
	}
	
	public void itemFromList() {
		selectList.sendKeys("Business");
	}
	
	public void clickOnRateButton() {
		checkRateButton.click();
	}
		
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void enterAddress(String str) {
		street.sendKeys(str);
	}
	
	public void enterCity(String town) {
		city.sendKeys(town);
	}
	
	public void enterState(String state1) {
		state.sendKeys(state1);
	}
	
	public void enterZipCode(String zip) {
		zipCode.sendKeys(zip);
	}
	
	public void enterDOB(String dateob) {
		dob.sendKeys(dateob);
	}
	
	public void clickOnContinueButton() {
		buttonContinue.click();
	}
	
	public void enterBorrowerIncome(String income) {
		borrowerIncome.sendKeys(income);
	}
	
	public void enterBorrowerAddIncome(String additionalIncome) {
		borrowerAdditionalIncome.sendKeys(additionalIncome);
	}

	public void clickOnContinueButton1() {
		buttonContinue.click();
	}
	
	public void clickElement() {
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void enterUserName(String uName) {
		userName.sendKeys(uName);
	}
	
	public void enterPassword(String pass) {
		passwd.sendKeys(pass);
	}
	
	public void selectAgreements() {
		agreement.click();
	} 
	
	public void btnCheckRate() {
		buttonCheckRate.click();
	}
	
	public void signOut() {
		executor.executeScript("arguments[0].click();", signOut);
	}
	
	public void login() {
		login.click();
	}
	
	public void storeData() {
	    loanAmount = loanAmnt.getText();
	    monthlyPayment = monPayment.getText();
		term1 = term.getText();
		apr = aprElement.getText();
	}
	
	public void validateAfterLogin() {
		Assert.assertEquals(loanAmount, "1,000");
		Assert.assertEquals(apr, "15.47% APR");
		Assert.assertEquals(term1, "24 months");
		Assert.assertEquals(monthlyPayment, "$49.11/mo");
	}
}