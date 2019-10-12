package com.dice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dice.base.BasePage;

public class ProfilePage extends BasePage<ProfilePage> {

	static By editProfile = By.xpath("//button[@id=\"editProfile\"]");
	By profileContactNameText = By.xpath("//h1[@class = \"profile-contact-name\"]");
	public ProfilePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public void waitForProfilePageToLoad() {
		waitForVisibilityOf(editProfile);
	}
	
	public boolean isCorrectProfileLoaded(String correctProfileName) {
		System.out.println("Verifying the correct profile name.");
		if(getText(profileContactNameText).equals(correctProfileName)) {
			return true;
		}
		
		return false;
	}
	
	

}
