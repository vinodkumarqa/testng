package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class Search extends Base{
	WebDriver driver;
	public Search() throws Throwable {
		super();
	}
	@BeforeMethod
	
	public void setup() {
		driver=InitializeBrowser();
		
	}
	@Test
	public void Searchwithvalidproduct() {
		driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.xpath("//button[@type='button' and contains(@class,'btn btn-default btn-lg')]")).click();
		boolean status=driver.findElement(By.linkText("HP LP3065")).isDisplayed();
		Assert.assertTrue(status);
		
	}
	@Test
	public void Searchwithemptyfields() {
		driver.findElement(By.name("search")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='button' and contains(@class,'btn btn-default btn-lg')]")).click();
		boolean status=driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).isDisplayed();
		Assert.assertTrue(status);
		
	}
	@AfterMethod
	public void shutdown() {
		driver.quit();
	}
	

}
