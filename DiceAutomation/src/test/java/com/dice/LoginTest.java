package com.dice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dice.base.BaseTest;
import com.dice.pages.LoginPage;
import com.dice.pages.ProfilePage;

public class LoginTest extends BaseTest {

	@Test
	public void positiveLoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		String expectedPageTitle = "Seeker Dashboard - Profile";
		String correctProfileName = "MOENGA VANICE";
		loginPage.openLoginPage();
		//Enter email and password
		loginPage.fillUpEmailAndPassWord("onchari.abuga.wycliffe@gmail.com", "28328719@Dic?!");
		
		// click login button and wait foe the profile to load
		ProfilePage profilePage = loginPage.clickLoginButton();
		
		profilePage.waitForProfilePageToLoad();
		
		// verify correct profile page opens
			// title page
		
		String actualTitle = profilePage.getPageTitle();
		Assert.assertTrue(expectedPageTitle.equals(actualTitle), "Page title is not expected\n Expected : " + expectedPageTitle + "\n Atual page title : " + actualTitle);
		    // correct profile name
		Assert.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileName), "Profile name is not expected");
	}
	
	@Test
	public void negativeLoginTest() {
		String expectedErrorMessage = "Email and/or password incorrect";
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openLoginPage();
		//Enter email and password
		loginPage.fillUpEmailAndPassWord("wrongEmail@gmail.com", "28328719@Dic?!");
		
		// click login button and wait foe the profile to load
	     loginPage.clickLoginButton();
	     String actualErrorMessage  =  loginPage.getLoginErrorMessage();
	     Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), 
	    		 "Errror message \" " + actualErrorMessage + "\" is not the expected one" );
		
		
	}
	
	
}
