package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import utilities.Utilities;

public class Register extends Base {
	WebDriver driver;
	public Register() throws Throwable {
		super();
	}
	@BeforeMethod
	public void setup() {
		    driver= InitializeBrowser();
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Register")).click();
	}
	@Test
	public void Registerwithmandatoryfields() {
		driver.findElement(By.id("input-firstname")).sendKeys("vinod");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.timestamp());
		driver.findElement(By.id("input-telephone")).sendKeys("9010551838");
		driver.findElement(By.id("input-password")).sendKeys("developer@55");
		driver.findElement(By.id("input-confirm")).sendKeys("developer@55");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	    String successmessage=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(successmessage, "Your Account Has Been Created!");



		
	}
	@Test
	public void registerwithallmethods() {
		driver.findElement(By.id("input-firstname")).sendKeys("vinod");
		driver.findElement(By.id("input-lastname")).sendKeys("kumar");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.timestamp());
		driver.findElement(By.id("input-telephone")).sendKeys("9010551838");
		driver.findElement(By.id("input-password")).sendKeys("developer@55");
		driver.findElement(By.id("input-confirm")).sendKeys("developer@55");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	    String successmessage=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(successmessage, "Your Account Has Been Created!");

	}
	@AfterMethod
	public void shutdown() {
		driver.quit();
	}

}
