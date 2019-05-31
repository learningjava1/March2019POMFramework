package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.util.ElementActions;

public class LoginPageBy {
	
	
	//Class variables
	WebDriver driver;
	ElementActions elementActions;
	
	//1. Define Page objects with the help of By locator only
	//2. page Actions/Methods of the feature
	
	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	//Create Constructor of of page class:
	public LoginPageBy(WebDriver driver) {
		this.driver = driver;
		//We'll create an Object of ElementActions and pass 'driver' inside the constructor
		elementActions = new ElementActions(driver);
	}
	
	//2. Defining 'Actions/Methods' below:
		public String getLoginPageTitle() {
			return elementActions.getPageTitle();
		}
		
		public boolean verifySignUpLink() {
			return elementActions.getElement(signUpLink).isDisplayed();
		}
		
		public HomePage doLogin(String un, String pwd) {
			elementActions.sendKeysElement(emailId, un);
			elementActions.sendKeysElement(password, pwd);
			elementActions.clickOnElement(loginButton);
			
			return new HomePage(driver);
		}
}
