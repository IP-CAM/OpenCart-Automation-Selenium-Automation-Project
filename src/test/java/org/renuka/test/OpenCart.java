package org.renuka.test;

import org.openqa.selenium.WebDriver;
import org.renuka.pageobjects.HomePage;
import org.renuka.pageobjects.SearchPage;

public class OpenCart {

	protected HomePage homePage;
	protected SearchPage searchPage;

	public OpenCart(WebDriver driver) {
		homePage = new HomePage(driver);
		searchPage = new SearchPage(driver);
	}

}
