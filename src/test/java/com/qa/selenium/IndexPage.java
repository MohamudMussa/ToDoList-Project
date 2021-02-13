package com.qa.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;




public class IndexPage {
	
	private static RemoteWebDriver driver;
	
	//setting up a few things to interact with selenium	
	@BeforeAll
	public static void beforeAll() {
		
		
		//system.property
		System.setProperty("webdriver.chrome.driver", 
				"src/main/resources/drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));

		//driver
		
	}
	
	@AfterAll
	public static void afterAll() {
		
		//clear the driver
		driver.quit();
		
	}
	
	public void loadingIndex() {
		
	}

}
