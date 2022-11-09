package com.upgrade.ui.automation.managers;

import org.openqa.selenium.WebDriver;

import com.upgrade.ui.automation.pages.CheckRate;

public class PageObjectManager {
	
	public WebDriver driver;
	private CheckRate checkRate;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
		checkRate = new CheckRate(driver);
	}

	public CheckRate getCheckRate() {
		return checkRate;
	}
}