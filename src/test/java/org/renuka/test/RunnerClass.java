package org.renuka.test;

import org.openqa.selenium.WebDriver;
import org.renuka.helpers.BrowserFactory;
import org.renuka.helpers.SeleniumHelper;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunnerClass {

	private static WebDriver _driver;
	private final String applicationUrl = "http://localhost/opencart";

	@BeforeTest
	public void TestInitialization() {
		// Open Browser
		_driver = BrowserFactory.getBrowser("chrome");
		SeleniumHelper helper = new SeleniumHelper(_driver);
		helper.navigateTo(applicationUrl);
		// Validate If Home Page is loaded successfully
		System.out.println("Page Title:" + SeleniumHelper.getPageTitle());
		Assert.assertEquals(SeleniumHelper.getPageTitle(), "Your Store");
	}

	@Test
	public void verifyUserCanAddToCartOneOrMoreProductUsingSearch() {

		OpenCart openCart = new OpenCart(_driver);
		openCart.homePage.searchForItem("Mac");
		// Validate if search page is available
		Assert.assertEquals(SeleniumHelper.getPageTitle(), "Search - Mac");
		// Check if Given item is available "iMac"
		boolean isProductAvailable = openCart.searchPage.isProductAvailableInSearchResult("iMac");
		System.out.println("is Product available :" + isProductAvailable);
		Assert.assertEquals(isProductAvailable, true, "Product should be available for adding into the cart");
		// Add To cart
		openCart.searchPage.addToCart();
		// Validate if product is added or not
		String successTextMessage = openCart.searchPage.getAlertMessageAfterAddingToCart();
		Assert.assertEquals(successTextMessage.split(":")[0].trim(), "Success");
	}

	@AfterTest
	public void TestCleanUp() {

	 _driver.quit();

	}

}
