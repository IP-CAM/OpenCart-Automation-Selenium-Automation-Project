package org.renuka.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME, using = "search")
	WebElement searchBox;

	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/span/button")
	WebElement searchBtn;

	@FindBy(how = How.LINK_TEXT, using = "Cameras")
	WebElement menuBarCameraBtn;

	public void searchForItem(String itemName) {
		searchBox.sendKeys(itemName);
		searchBtn.click();

	}

	public void accessToMenuBar() {

		menuBarCameraBtn.click();
	}
}
