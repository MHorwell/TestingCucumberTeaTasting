package com.horwell.matthew.tea.tasting.website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div[13]/div/ul/li[3]/a")
	private WebElement menuButton;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div[13]/div/ul/li[5]/a")
	private WebElement checkoutButton;
	
	public void goToMenu() {
		menuButton.click();
	}
	
	public void goToCheckoutPage() {
		checkoutButton.click();
	}

}
