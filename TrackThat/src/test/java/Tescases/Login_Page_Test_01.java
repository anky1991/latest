package Tescases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BaseTest.Base;
import com.qa.DataProvider.ExcelReader;
import com.qa.pages.Login_Page_Locator;
import com.qa.utility.Selenium_Utility;

public class Login_Page_Test_01 extends Base
    {
	
	Login_Page_Locator lpl;
	Selenium_Utility su= new Selenium_Utility();
	ExcelReader er=new ExcelReader("FileInputStream Fis");
	
	@BeforeMethod(groups="Regression")
	public void initConfig() 
	{
		log.info("BeforeMethod Initilize");
		loadProperties();
        invokeBrowser(prop.getProperty("Browser"));
        lpl =new Login_Page_Locator(); 
        log.info("Login Page Locators Load Successfully");
        log.info("Before Method Executed succesfully");
	}
	@Test()
	public void validateUserIdRequiredText() throws InterruptedException 
	{
		su.clickAnElement(lpl.getLoginBTN());
		su.iWait(lpl.getUiDText(), "User ID is required!");
		AssertJUnit.assertEquals(lpl.getUiDText().getText(), "User ID is required!");
		su.clickAnElement(lpl.getOkBtn());
	}

	//@Test(dependsOnMethods = {"validateUserIdRequiredText"})
	@Test()
	public void validatePasswordRequiredText() throws InterruptedException
	{
		su.enterContentInto(lpl.getEmailID(), "testme@m.com");
		Thread.sleep(1000);
		su.clickAnElement(lpl.getLoginBTN());
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElement(lpl.getUiDText(), "Password is required!"));
		AssertJUnit.assertEquals(lpl.getUiDText().getText(), "Password is required!");
		su.clickAnElement(lpl.getOkBtn());
	}

	//@Test(dependsOnMethods = { "validatePasswordRequiredText" }, dataProvider = "getData")
	@Test()
	public void validateEnteringUserCredentials() throws InterruptedException 
	{
		su.clearTextField(lpl.getEmailID());
		su.enterContentInto(lpl.getEmailID(), prop.getProperty("UserName"));
		Thread.sleep(1000 * 3);
		su.enterContentInto(lpl.getPassword(), prop.getProperty("Password"));
		Thread.sleep(1000 * 3);
		su.selectAnElement(lpl.getselectlist(), "2");
		su.clickAnElement(lpl.getRemembercheck());
		Thread.sleep(1000 * 3);
		su.clickAnElement(lpl.getLoginBTN());
		Thread.sleep(1000 * 3);
		Assert.assertEquals(lpl.getIC().getText(), "Invalid Credentials!");
		su.clickAnElement(lpl.getOkBtn());
	}
	@Test(groups="Regression")
	public void loginSuperadmin() 
	{
		su.clickAnElement(lpl.getEmailID());
		su.clearTextField(lpl.getEmailID());
		su.clickAnElement(lpl.getPassword());
		su.clearTextField(lpl.getPassword());
		su.enterContentInto(lpl.getEmailID(), prop.getProperty("UserName"));
		su.enterContentInto(lpl.getPassword(), prop.getProperty("Password"));
		su.selectAnElement(lpl.getselectlist(), "3");
		su.clickAnElement((lpl.getLoginBTN()));
	}
	@AfterMethod(groups="Regression")
	public void cloaseBrowser()
	{
		quiteBroswer();
	}
}
