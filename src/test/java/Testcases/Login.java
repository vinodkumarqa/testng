package Testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import utilities.Utilities;

public class Login extends Base {
	WebDriver driver;
	public Login() throws Throwable {
		super();
	}
	@BeforeMethod
	public void setup() {
		    driver=InitializeBrowser();
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Login")).click();
	}
	@Test(dataProvider="supplytestdata" )
	public  void loginwithvalidcredentials(String email,String password) {
		
		 //System.setProperty("WebDriver.chrome.driver","chromedriver.exe");
			
			driver.findElement(By.id("input-email")).sendKeys(email);
			driver.findElement(By.id("input-password")).sendKeys(password);
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
			

		
	}
	@Test
	public void loginwithemptyfields() {
		 //System.setProperty("WebDriver.chrome.driver","chromedriver.exe");
			
			
			driver.findElement(By.id("input-email")).sendKeys("");
			driver.findElement(By.id("input-password")).sendKeys("");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
		    String errormessage=	driver.findElement(By.xpath("//div[contains(@class , 'alert-dismissible')]")).getText();
		    Assert.assertEquals(errormessage,"Warning: No match for E-Mail Address and/or Password." );
		    
	}
	@DataProvider
	public Object[][] supplytestdata() throws IOException{
		Object[][] data= Utilities.getexceldata("Sheet1");
		return data;
	}
	@Test
	public void loginwithinvalidemailid() {
		//System.setProperty("WebDriver.chrome.driver","chromedriver.exe");
		
		
		driver.findElement(By.id("input-email")).sendKeys(Utilities.timestamp());
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	    String errormessage=	driver.findElement(By.xpath("//div[contains(@class , 'alert-dismissible')]")).getText();
	    Assert.assertEquals(errormessage,"Warning: No match for E-Mail Address and/or Password." );
	    
	}
	
	@AfterMethod
	public void shutdown() {
		driver.quit();
	}

	}
	


