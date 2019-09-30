package com.qa.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.BaseTest.Base;

public class Selenium_Utility extends Base
{

	public void enterContentInto(WebElement ele, String content)
	{
		ele.sendKeys(content);
	}
	
	public void selectAnElement(WebElement ele1,String a)
	{
		Select slct=new Select(ele1);
		slct.selectByValue(a);
	}
	
	public void clickAnElement(WebElement ele2)
	{
		ele2.click();
	}
	
	public void getTextMethod(WebElement ele3)
	{
		ele3.getText();
	}
    public void clearTextField(WebElement ele4)
    {
    	ele4.clear();
    }
	
    public void iWait(WebElement elem,String text)
    {
    	WebDriverWait wait =new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.textToBePresentInElement(elem, text));
    }
    
    public void sleep(int Seconds)
    {
    	try
    	{
			Thread.sleep(Seconds);
		} catch (InterruptedException e) 
    	{
			e.printStackTrace();
		}
    }
}
