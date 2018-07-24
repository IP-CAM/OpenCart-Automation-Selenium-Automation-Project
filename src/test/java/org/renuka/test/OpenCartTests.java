package org.renuka.test;

import java.io.IOException;

import org.renuka.selenium_helpers.SeleniumHelper;
import org.renuka.utils.ReadExcelFileUsingPOI;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpenCartTests extends TestBase {

	private final String applicationUrl = "http://localhost/opencart";

	@Test(enabled = false)
	public void verifyUserCanAddToCartOneOrMoreProductUsingSearch() {
		// Navigate TO Application URL
		navigateToApplication(applicationUrl);
		OpenCartApp openCart = new OpenCartApp(_driver);
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

	@Test(dataProvider = "openCartRegression")
	public void verifyUserCanAddproductToCartUsingMenuBar(String scenario, String runFlag, String product) {
	
		if (runFlag.equalsIgnoreCase("y")) {
			// Navigate TO Application URL
			navigateToApplication(applicationUrl);
			OpenCartApp openCart = new OpenCartApp(_driver);
			// Click on Camera on menu bar
			openCart.homePage.accessToMenuBar();
			// Verify if Camera page has been loaded
			String actualHeaderText = openCart.camerasPage.getHeaderText();
			System.out.println("Actual Camera Page Text:" + actualHeaderText);
			Assert.assertEquals("Cameras", actualHeaderText, "Cameras Page should be loaded on click");
		}

	}

	@DataProvider(name = "openCartRegression")
	public Object[][] regressionData() throws IOException {
		Object[][] arrayObject = ReadExcelFileUsingPOI.getTestData("Regression");
		return arrayObject;
	}

}
