package org.renuka.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SeleniumHelper {

	private static WebDriver _driver;


	public SeleniumHelper(WebDriver driver) {
		SeleniumHelper._driver = driver;
	}

	public void navigateTo(String applicationUrl) {
		_driver.navigate().to(applicationUrl);
	}

	public static String getPageTitle() {
		return _driver.getTitle();
	}

	public static void pageScrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) _driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}


}
