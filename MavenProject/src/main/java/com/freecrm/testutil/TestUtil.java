package com.freecrm.testutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.freecrm.testbase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestUtil extends TestBase{
	
	ExtentReports extent;
	ExtentTest extentTest;
	
	public static long Implicitly_Wait = 20;
	public static long PageLoadTimeout = 40;
	
	public void ExtentReport(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL,"Test Case is failed" + result.getName());
			extentTest.log(LogStatus.FAIL,"Test Case is failed" + result.getThrowable());
			String screenshotpath = TestUtil.ScreenShots(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotpath));
		} else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS,"Test Case is Passed" + result.getName());
		} else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case is Skipped" + result.getName());
		}
		
	}
	
	public static String ScreenShots(WebDriver driver, String Screenshotname){
		
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

}
