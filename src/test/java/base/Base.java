package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base {
	WebDriver driver;
	String urllink;
	public Properties pro;
	public Base() throws Throwable {
		File filename=new File(".//src//main//java//conflictproperties//config.properties");
		FileInputStream file=new FileInputStream(filename);
		 pro=new Properties();
		pro.load(file);
		 urllink=pro.getProperty("url");
		
	}
	public WebDriver InitializeBrowser() {
		System.setProperty("WebDriver.chrome.driver","chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		 driver.get(urllink);
		 return driver;
	}

}
