package com.qa.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FWListners implements ITestListener
{

	public void onTestStart(ITestResult result) 
	{
		System.out.println("Test case is Start"+ " "+result.getName() +" "+result.getStatus());
		System.out.println(result.getStatus());
	}

	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test case is Success"+" "+result.getName());

	}

	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test case is failed"+" "+result.getName());

		
	}

	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Test case is skipped"+" "+result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) 
	{
		
	}

	public void onFinish(ITestContext context)
	{
		
	}

}
