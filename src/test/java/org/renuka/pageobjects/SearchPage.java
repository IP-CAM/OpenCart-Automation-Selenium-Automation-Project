package org.renuka.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.renuka.selenium_helpers.SeleniumHelper;

public class SearchPage {

	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "a")
	List<WebElement> productList;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]")
	WebElement addBtn;

	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successText;

	public boolean isProductAvailableInSearchResult(String itemName) {
		boolean result = false;
		// Validate if given item is present in search result
		for (WebElement element : productList) {
			if (element.getAttribute("innerText").equals(itemName)) {
				result = true;
				break;
			}
		}
		return result;
	}

	// add to cart
	public void addToCart() {
		SeleniumHelper.pageScrollDown();
		addBtn.click();
	}

	// validate Success message

	public String getAlertMessageAfterAddingToCart() {
		return successText.getText();
	}

}
