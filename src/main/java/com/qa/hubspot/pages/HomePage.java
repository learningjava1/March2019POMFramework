package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.CommonUtil;

public class HomePage extends BasePage{
	
	WebDriver driver;
	
	//In this HomePage Class, we'll define two things:
	//We'll define 'Page Objects' and 'Actions/Methods':
	
	//We'll verify 2 things in HomePage after login:
	//HomePage Title and the Page Header
	
	@FindBy(xpath="//div[@class='private-header__inner']/div/h1")
	WebElement homePageHeader;
	
	@FindBy(xpath="//div[@id='account-menu-container']/a/span")
	WebElement accountName;
	
	@FindBy(id="nav-primary-contacts-branch")
	WebElement contactMainLink;
	
	@FindBy(id="nav-secondary-contacts")
	WebElement contactSubLink;
	
	
	
	//Now we have to create a Constructor of the HomePage:
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//Now we'll create our Actions/Methods:
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getHomePageHeaderValue() {
		return homePageHeader.getText();
	}
	
	public String getLoggedInAcctName() {
		return accountName.getText();
	}
	
	public ContactsPage goToContactsPage() {
		contactMainLink.click();
		CommonUtil.shortWait();
		contactSubLink.click();
		return new ContactsPage(driver);
		
	}
		
}
