package com.qa.selenium;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class AutomatedTesting {

    private static WebDriver driver;
    
    //TODO WEBSITE
    private static String URL = "http://localhost:8080/";

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void ToDoListLoads() throws InterruptedException {
    	
    	//GIVEN THAT I CAN ACCES MY TO DO WEBSITE
        driver.get(URL);
        
 
        //ASSERTION 
        
        assertEquals("ToDolist by Mohamud Mussa", driver.getTitle());
        Thread.sleep(9000); // do not use
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
    }
    
	public static ChromeOptions chromeCfg() {
		 Map<String, Object> prefs = new HashMap<String, Object>();
		 ChromeOptions cOptions = new ChromeOptions();
		  
		 prefs.put("profile.default_content_setting_values.cookies", 2);
		 prefs.put("network.cookie.cookieBehavior", 2);
		 prefs.put("profile.block_third_party_cookies", true);

		 cOptions.setExperimentalOption("prefs", prefs);

		 return cOptions;
		 }
    
    
}