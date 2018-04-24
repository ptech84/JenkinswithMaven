package com.freecrm.testutil;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener{
	
	public void onStart(ITestContext arg0){
		System.out.println(arg0.toString());
	}

	public void onFinish(ITestContext arg0){
		System.out.println(arg0.toString());
	}
	
	public void onTestSuccess(ITestResult arg0){
		System.out.println(arg0.toString());
	}
	
	public void onTestFailure(ITestResult arg0){
		System.out.println(arg0.toString());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0){
		System.out.println(arg0.toString());
	}
	
	

	public void onTestSkipped(ITestResult arg0) {
		System.out.println(arg0.toString());
	}


	public void onTestStart(ITestResult arg0) {
		System.out.println(arg0.toString());
		
	}

	
}
