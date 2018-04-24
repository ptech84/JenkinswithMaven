package com.freecrm.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.freecrm.commonfunctions.CommonFunctions;
import com.freecrm.testutil.TestUtil;

public class TestBase{
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;
	
	public TestBase(){
		
		prop = new Properties();
		FileInputStream fis;
		log = Logger.getLogger(TestBase.class);
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/freecrm/config/config.properties");
			prop.load(fis);
			log.info("initiating the property file objects to prop variable");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		log.info("initializing the browser");
		switch (browserName){
		
		case "IE":
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability("requireWindowFocus", true);
			System.setProperty("webdriver.ie.driver", "C:/Selenium/BrowserDrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
			log.info("Opening IE Browser");
			break;
			
		case "FF":
			System.setProperty("webdriver.gecko.driver","C:/Selenium/BrowserDrivers/geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Opening FF Browser");
			break;
			
		case "chrome":
			System.setProperty("webdriver.chrome.driver","C:/Selenium/BrowserDrivers/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Opening Chrome Browser");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}
	

}
