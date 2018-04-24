package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.commonfunctions.CommonFunctions;
import com.freecrm.testbase.TestBase;

public class HomePage extends TestBase{
	CommonFunctions commonFunctions = new CommonFunctions();
	@FindBy(xpath="//a[contains(@title,'Contacts')]")
	WebElement ContactsTab;
	
	@FindBy(xpath="//a[contains(@title,'New Contact')]")
	WebElement NewContactTab;
	
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void NavigateToNewContactsPage(){
		
		commonFunctions.switchToFrame("mainpanel");
		commonFunctions.moveToElementAndClick(ContactsTab, NewContactTab);
	}
	
	public ContactsPage NavigateToContactsPage(){
		
		commonFunctions.switchToFrame("mainpanel");
		ContactsTab.click();
		return new ContactsPage();
	}

}
