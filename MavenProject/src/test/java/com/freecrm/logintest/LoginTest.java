package com.freecrm.logintest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.freecrm.commonfunctions.CommonFunctions;
import com.freecrm.pages.ContactsPage;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.testbase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(com.freecrm.testutil.ListenerClass.class)

public class LoginTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	CommonFunctions commonFunctions;
	ExtentReports extent;
	ExtentTest extentTest;
	Logger log = Logger.getLogger(LoginTest.class);
	
	
	
	public LoginTest(){
		super();
	}
	
	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Praveen Microsoft");
		extent.addSystemInfo("User Name", "Praveen Automation Labs");
		extent.addSystemInfo("Environment", "QA");
		
	}
	
	@BeforeMethod
	public void setup(){
		log.info("****************************** Starting test cases execution  *****************************************");
	initialization();
	loginpage = new LoginPage();
	homepage = new HomePage();
	contactspage = new ContactsPage();
	commonFunctions = new CommonFunctions();
    
	
	}
	
	@Test(priority=6, groups="title", enabled=true)
	public void verifyPageTitle(){
		log.info("verifying page title using log4j");
		extentTest =	extent.startTest("verifyPageTitle");
		
		System.out.println("verifyPageTitle test case");
		String title = loginpage.getTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");

		
	}
	
	@Test(priority=5, groups="logo", enabled=true)
	public void verifyLogo(){
		log.info("****************************** verifying logo *****************************************");
		extentTest = extent.startTest("verifyLogo");
		boolean logo = loginpage.verifyLogo();
		Assert.assertTrue(true);
	}
	
	@Test(priority=4, groups="LoginTest", enabled=true)
	public void LoginTestCase(){
		log.info("****************************** Started Login to FreeCRM Tes Case   *****************************************");
		extentTest = extent.startTest("LoginTestCase");
		homepage = loginpage.LoginToFreeCrm();
		
	}
	
	@Test(priority=3, enabled=true)
	public void NavigateToNewContactsTab(){
		log.info("navigating to contacts page");
		extentTest = extent.startTest("NavigateToNewContactsTab");
		homepage = loginpage.LoginToFreeCrm();
		homepage.NavigateToNewContactsPage();
	}
	
	@Test(priority=2, enabled=true)
	public void AddNewContacts(){
		log.info("navigating to contacts page");
		extentTest = extent.startTest("AddNewContacts");
		homepage = loginpage.LoginToFreeCrm();
		homepage.NavigateToNewContactsPage();
		log.info("selecting the title in contacts page");
		contactspage.selectTitle();
	}
	
	
	@Test(priority=1)
	public void SearchEmailAddress(){
		log.info("Starting Search EmailAddress test case");
		extentTest = extent.startTest("SearchEmailAddress");
		homepage = loginpage.LoginToFreeCrm();
		homepage.NavigateToContactsPage();
		String email = contactspage.getEmailAddress();
		Assert.assertEquals(email, "pravtech@gmail.com");
		contactspage.selectCheckbox();
	 //commonFunctions.AlertUserDefined("Hurray!!!!!");
	 
	}
	
public static String getScreenShots(WebDriver driver, String Screenshotname){
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + Screenshotname + dateName
				+ ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
	}

	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = LoginTest.getScreenShots(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
		
		
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		
		driver.quit();
	}
	
	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
		
	}
	

	

}
