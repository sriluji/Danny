package com.qa.Swag.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Swag.Base.SwagTestBase;

public class HomePage extends SwagTestBase{
	
	//create PageFactory
	
	@FindBy(id="react-burger-menu-btn")
	WebElement menubtn;
	
	@FindBy(id="about_sidebar_link")
	WebElement aboutlink;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cartimg;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public void clickOnmenubutton() throws InterruptedException {
		menubtn.click();
		Thread.sleep(500);
	}
	
	public AboutsUsPage clickOnAboutLink() {
		menubtn.click();
	Actions actions=new Actions(driver);
		actions.moveToElement(aboutlink).click();
		return new AboutsUsPage();
	}
	public boolean verifyCart() {
		return cartimg.isDisplayed();
	}

}
