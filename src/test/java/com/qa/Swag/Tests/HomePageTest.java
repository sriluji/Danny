package com.qa.Swag.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Swag.Base.SwagTestBase;
import com.qa.Swag.Pages.HomePage;
import com.qa.Swag.Pages.LoginPage;

public class HomePageTest extends SwagTestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void SetUP() throws InterruptedException {
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.verifyLogin(prop.getProperty("username"),prop.getProperty("password") );
		Thread.sleep(500);
		
		
	}
	
	@Test
	public void homePageTitleTest() {
		String hometitle=homepage.verifyHomePageTitle();
		System.out.println(hometitle);
		String expected =  "Single Page Apps for GitHub Pages";
		Assert.assertEquals(hometitle,expected,"incorrect Title");
	}
	
	@Test
	public void clickmenuButtonTest() throws InterruptedException {
	homepage.clickOnmenubutton();
	}
	@Test
	public void clickAboutUsTest() {
		homepage.clickOnAboutLink();
	}
	@Test
	public void verifyCartTest() {
		boolean b=homepage.verifyCart();
		Assert.assertTrue(b);
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	

}
