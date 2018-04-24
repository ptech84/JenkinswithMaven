package com.freecrm.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.testbase.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//img[@alt='free crm logo']")
	WebElement logo;
	
	@FindBy(xpath=".//*[@name='username']")
	WebElement username;
	
	@FindBy(xpath=".//*[@name='password']")
	WebElement password;
	
	@FindBy(xpath=".//*[@type='submit']")
	WebElement loginBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this); 
		//log.info("Initializing the Login Page objects");
	}
	
	public String getTitle(){
		return driver.getTitle();
		
	}
	
	public boolean verifyLogo(){
	return logo.isDisplayed();
	}
	
	public HomePage LoginToFreeCrm(){
		username.clear();
		username.sendKeys(prop.getProperty("username"));
		password.clear();
		password.sendKeys(prop.getProperty("password"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
		loginBtn.click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage();
	}
}
