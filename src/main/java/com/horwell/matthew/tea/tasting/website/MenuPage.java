package com.horwell.matthew.tea.tasting.website;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage {
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div[14]/div/p/span/span/strong")
	private WebElement greenTeaTitle;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div[13]/div/p/span/span/strong")
	private WebElement redTeaTitle;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div[26]/div/p/span/span/strong")
	private WebElement oolongTeaTitle;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div[13]/div/ul/li[5]/a")
	private WebElement checkoutButton;
	
	public String getTeaList() {
		String space = ", ";
		return (greenTeaTitle.getText() + space + redTeaTitle.getText() + space + oolongTeaTitle.getText());		
	}
	
	public void goToCheckoutPage() {
		checkoutButton.click();
	}

}
