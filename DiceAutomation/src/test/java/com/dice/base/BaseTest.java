package com.dice.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.dice.FirstTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	protected Logger logger = LogManager.getLogger(FirstTest.class);

	@BeforeMethod
	public void methodSetup() {
		logger.info("Method SETUP ");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	
	
	@AfterMethod
	public void tearDown() {
		logger.info("Method TEARDOWN ");
		driver.quit();
	}
}
