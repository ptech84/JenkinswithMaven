package com.freecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.commonfunctions.CommonFunctions;
import com.freecrm.testbase.TestBase;

public class ContactsPage extends TestBase{
	
	CommonFunctions commonFunctions = new CommonFunctions();
	
	@FindBy(xpath="//select[@name='title']")
	WebElement titleDDL;
	
	@FindBy(xpath="//input[@type='file']")
	WebElement browserBtn;
	
	@FindBy(xpath="//form[@id='vContactsForm']/table/tbody/tr[6]/td[2]/a[contains(text(),'Praveen Naidu')]//parent::td/following-sibling::td[5]/a")
	WebElement emailaddress;
	
	@FindBy(xpath="//form[@id='vContactsForm']/table/tbody/tr[6]/td[2]/a[contains(text(),'Praveen Naidu')]/parent::td/preceding-sibling::td/input[@name='contact_id']")
	WebElement checkbox;
	
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectTitle(){
		commonFunctions.SelectDDLValues(titleDDL, "Prof.");
		
	}
	
	public String getEmailAddress(){
		String email = emailaddress.getText();
		return email;
	}
	
	public void selectCheckbox(){
		checkbox.click();
		
	}

}
