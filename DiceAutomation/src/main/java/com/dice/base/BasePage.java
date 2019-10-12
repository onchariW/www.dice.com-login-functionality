package com.dice.base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage<T> {

	protected WebDriver driver;
	protected WebDriverWait wait;

	protected BasePage(WebDriver webDriver) {
		this.driver = webDriver;
		wait = new WebDriverWait(driver, 40);
	}
	
	@SuppressWarnings("unchecked")
	protected T  getPage(String url) {
		driver.get(url);
		return (T) this;
	}
	
	protected void type(String text, By element) {
		find(element).sendKeys(text);
	}
	
	protected void click(By element) {
		find(element).click();
	}

	private WebElement find(By element) {
		return driver.findElement(element);
	}
	
	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} 
			catch (StaleElementReferenceException e) {	
			}
			attempts++;
			
		}
	}
	
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeoutinSeconds) {
		timeoutinSeconds = timeoutinSeconds != null ? timeoutinSeconds:30;
		WebDriverWait wait = wait = new WebDriverWait(driver, timeoutinSeconds);
		wait.until(condition);
	}
	
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	protected String getText(By element) {
		return find(element).getText();
	}
}
