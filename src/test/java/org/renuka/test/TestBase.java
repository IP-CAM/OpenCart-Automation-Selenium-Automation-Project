package org.renuka.test;

import org.openqa.selenium.WebDriver;
import org.renuka.selenium_helpers.BrowserFactory;
import org.renuka.selenium_helpers.SeleniumHelper;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	protected static WebDriver _driver;

	@BeforeTest
	public void TestInitialization() {
		// Open Browser
		_driver = BrowserFactory.getBrowser("chrome");
	}

	protected void navigateToApplication(String applicationURL) {
		SeleniumHelper helper = new SeleniumHelper(_driver);
		helper.navigateTo(applicationURL);
		// Validate If Home Page is loaded successfully
		System.out.println("Page Title:" + SeleniumHelper.getPageTitle());
		Assert.assertEquals(SeleniumHelper.getPageTitle(), "Your Store");
	}

	@AfterTest
	public void TestCleanUp() {
		_driver.quit();
	}

}
