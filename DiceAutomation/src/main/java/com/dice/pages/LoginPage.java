package com.dice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dice.base.BasePage;



public class LoginPage extends BasePage<LoginPage> {
private static final String URL = " https://www.dice.com/dashboard/login";
private By emailField = By.xpath("//input[@id = \"email\"]");
private By passWordField  = By.xpath("//input[@id = \"password\"]");
private By signInButton = By.xpath("//button[@type = \"submit\"]");
private By errorMessage = By.xpath("//span[@data-automation-id=\"login-failure-help-message\"]");

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public void openLoginPage() {
		System.out.println("Open dice login page  https://www.dice.com/dashboard/login");
		getPage(URL);
	}
	
	public void fillUpEmailAndPassWord(String email, String password) {
		System.out.println("Filling in email address");
		type(email, emailField);
		
		System.out.println("Filling in password");
		type(password, passWordField);
	}
	
	public ProfilePage clickLoginButton() {
		
		System.out.println("Clicking sign in button.");
		click(signInButton);
		return new ProfilePage(driver);
			
	}

	public String getLoginErrorMessage() {
		waitForVisibilityOf(errorMessage , 10);
		return getText(errorMessage);
		
	}

}
