package com.freecrm.testutil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventListeners implements WebDriverEventListener {
	
	
	public void beforeFindBy(WebElement arg0, WebDriver arg1){
		System.out.println("before findBy" + arg0.toString());
	}

	
	public void beforeClickOn(WebElement arg0, WebDriver arg1){
		System.out.println("beforeClickOn" + arg0.toString());
	}
	
	public void beforeNavigateTo(String url, WebDriver arg1){
		System.out.println("before Navigate To" + url.toString());
	}
	
	public void beforeNavigateFrom(WebElement arg0, WebDriver arg1){
		System.out.println("before Navigate From" + arg0.toString());
	}
	
	public void onException(WebElement arg0, WebDriver arg1){
		System.out.println("on exception" + arg0.toString());
	}
	
	public void afterClickon(WebElement element, WebDriver arg1){
		System.out.println("after clickon" + element.toString());
	}


	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void beforeScript(String script, WebDriver driver) {
		System.out.println("beforeScript" + script.toString());
		
	}


	@Override
	public void afterScript(String script, WebDriver driver) {
		System.out.println("after Script" + script.toString());
		
	}


	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println(windowName.toString());
		
	}


	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println(windowName.toString());
		
	}


	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println(throwable.toString());
		
	}
}