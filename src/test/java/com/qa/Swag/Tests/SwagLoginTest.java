package com.qa.Swag.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Swag.Base.SwagTestBase;
import com.qa.Swag.Pages.HomePage;
import com.qa.Swag.Pages.LoginPage;

public class SwagLoginTest extends SwagTestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public SwagLoginTest() {
		super();
		
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		loginpage=new LoginPage();
	}
	
	
	@Test
	public void SwagTitleTest() {
		String title=loginpage.verifySwagTitlePage();
		Assert.assertEquals(title, "Swag Labs", "Incorrect Title");
		
	}
	@Test
	public void LoginTest() {
		homepage=loginpage.verifyLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void SwagLogoTest() {
		boolean b=loginpage.validateSwagLogo();
		Assert.assertTrue(b);
		
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
