package com.qa.Swag.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.Swag.Util.UtilPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwagTestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public SwagTestBase() {
		prop=new Properties();
		try {
			FileInputStream ip= new FileInputStream("C:\\Users\\hr\\Desktop\\Sreelatha\\Java\\SwagLabs\\src\\main\\java\\com\\qa\\Swag\\configuration\\Swagconfig.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browsername=prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			driver=WebDriverManager.chromedriver().create();
		}else if (browsername.equals("FF")) {
			driver=WebDriverManager.firefoxdriver().create();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(UtilPage.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilPage.IMPLICIT_WAIT));
	}
	

}
