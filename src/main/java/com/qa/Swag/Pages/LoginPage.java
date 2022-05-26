package com.qa.Swag.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Swag.Base.SwagTestBase;

public class LoginPage extends SwagTestBase{
	
	
	
	//create PageFactory
	@FindBy(name="user-name")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="login-button")
	WebElement loginbtn;
	
	@FindBy(xpath="//div[@class='bot_column']")
	WebElement image;
	
	//initialization
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifySwagTitlePage() {
		return driver.getTitle();
		
	}
	public HomePage verifyLogin(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}
	public boolean validateSwagLogo() {
		return image.isDisplayed();
	}
	

}
