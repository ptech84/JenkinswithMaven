package com.freecrm.commonfunctions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.ExpectedExceptions;

import com.freecrm.testbase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CommonFunctions extends TestBase {

	Actions act = new Actions(driver);
	
	ExtentReports extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
	ExtentTest extentTest;

	
	public void clickWebElement(String xpath, WebElement element){
		boolean webElement = driver.findElement(By.xpath(xpath)).isDisplayed();
		if(webElement==true){
		driver.findElement(By.xpath(xpath)).click();
		fnReport("PASS", "Clicked on webelement successfully");
		} else {
		fnReport("FAIL", "Unable to Click on webelement");
		}
		
	}
	
	public void fnReport(String status, String message){
		
		switch(status.toUpperCase()){
		
		case "PASS":
			extentTest.log(LogStatus.PASS, message);
			break;
		
		
		case "FAIL":
			extentTest.log(LogStatus.FAIL, message);
			break;
		
		case "SKIP":
			extentTest.log(LogStatus.SKIP, message);
			break;
		
	}
	}
	
	public void moveToElementAndClick(WebElement xpath, WebElement locator){
		
			act.moveToElement(xpath).build().perform();
			locator.click();
				
	}
	
	public void switchToWindow(){
		Set<String> windows  = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String ParentWindow = it.next();
		String ChildWindow = it.next();
		driver.switchTo().window(ChildWindow);
				
	}

	public void switchToFrame(String FrameName){
		driver.switchTo().frame(FrameName);
		//fnReport("PASS", "Switched to frame");
	}
	
	public void clickOnWebElementExplicit(WebDriver driver, int timeouts, WebElement locator){
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
	
	public void SelectDDLByString(WebElement xpath, String value){
		Select sel = new Select(xpath);
		sel.selectByVisibleText(value);
			
	}
	
	public void SelectDDLByIndex(WebElement xpath, int value){
		Select sel = new Select(xpath);
		sel.selectByIndex(value);

	}
	
	public void SelectDDLValues(WebElement xpath, String value){
		Select sel = new Select(xpath);
		List<WebElement> ddlValues = sel.getOptions();
		for(WebElement list: ddlValues){
			if(list.getText().equals(value)){
				list.click();
			}
		}
		
	}
	
	public void AlertUserDefined(String message){
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("alert('"+message+"')");
	
	}
		

}
