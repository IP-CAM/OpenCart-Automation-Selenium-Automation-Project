package org.renuka.test;

import org.openqa.selenium.WebDriver;
import org.renuka.pageobjects.CamerasPage;
import org.renuka.pageobjects.HomePage;
import org.renuka.pageobjects.SearchPage;

public class OpenCartApp {

	protected HomePage homePage;
	protected SearchPage searchPage;
	protected CamerasPage camerasPage;

	public OpenCartApp(WebDriver driver) {
		homePage = new HomePage(driver);
		searchPage = new SearchPage(driver);
		camerasPage = new CamerasPage(driver);
	}

}
