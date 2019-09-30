package Tescases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BaseTest.Base;
import com.qa.pages.Hamburger_Menu_Locators;
import com.qa.pages.Login_Page_Locator;
import com.qa.utility.Selenium_Utility;

public class Hamburger_Test extends Base
{
	Login_Page_Locator lpl;
	Hamburger_Menu_Locators hml;
	Selenium_Utility su=new Selenium_Utility();
 
	@BeforeMethod(groups="Regression")
	public void initConfig() 
	{
		loadProperties();
		invokeBrowser(prop.getProperty("Browser"));
		lpl=new Login_Page_Locator();
		hml=new Hamburger_Menu_Locators();
	}
	
	@Test(description="Menu icon is opening & closing ",groups="Regression")
	public void clickOnHamburger() 
	{
		 su.enterContentInto(lpl.getEmailID(),prop.getProperty("UserName"));
		 su.enterContentInto(lpl.getPassword(),prop.getProperty("Password"));
		 su.selectAnElement(lpl.getselectlist(),"3");
		 su.clickAnElement(lpl.getRemembercheck());
		 su.clickAnElement(lpl.getLoginBTN());
		 try 
		 {
			Thread.sleep(7000);
		    su.clickAnElement(hml.getmenuIcon());
		    Thread.sleep(3000);
		    su.clickAnElement(hml.getmenuIcon());
		} catch (InterruptedException e) 
		 {
			e.printStackTrace();
		 }
	}
	@Test(dependsOnMethods="clickOnHamburger",description="Track_That Logo is clickable",groups="Regression")
	public void logoIsClickable()
	{
	 su.enterContentInto(lpl.getEmailID(),prop.getProperty("UserName"));
	 su.enterContentInto(lpl.getPassword(),prop.getProperty("Password"));
	 su.selectAnElement(lpl.getselectlist(),"3");
	 su.clickAnElement(lpl.getRemembercheck());
	 su.clickAnElement(lpl.getLoginBTN());
		try 
		{   Thread.sleep(4000);
			su.clickAnElement(hml.getmenuIcon());
			if(hml.getmenuIcon().isDisplayed()) 
			{
			su.clickAnElement(hml.getTrackLogo());
			}
	   }catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void menuIconRedirection()
	{
		
	}
	@AfterMethod(groups="Regression")
	public void closeBrowser()
	{
		quiteBroswer();
	}
}
