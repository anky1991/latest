package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseTest.Base;
public class Login_Page_Locator extends Base
{
//Page factory -OR:--Class Object Initialization throw page factory method.
public Login_Page_Locator()
{   log.info("Page Factory Initilize Successfully");
	PageFactory.initElements(driver, this);
	log.info("Page Objects Load Successfully");
	
}

@FindBy(css="input[placeholder='Enter User ID here ']")
private WebElement emailidTF; 

public WebElement getEmailID() 
{
	return emailidTF;
}

@FindBy(id="swordCng") private WebElement passwordTF;
public WebElement getPassword() 
{
	return passwordTF;
}

@FindBy (css="select[ng-model='lc.roleDropDownLogin']") private WebElement slctBtn;
public WebElement getselectlist()
{
	return slctBtn;
}

@FindBy (css="img.changeReme")
private WebElement remCB; public WebElement getRemembercheck() 
{
	return remCB;
}

@FindBy(xpath="//button[text()='LOGIN']") private WebElement loginBtn;
public WebElement getLoginBTN()
{
	return loginBtn;
}

@FindBy(id="nav_list") private WebElement hmbrgrIcon;
public WebElement getHambrgrICon(){
{
	return hmbrgrIcon;
}
}

@FindBy(id="logoutButtonXmpp") private WebElement logoutBTN;
public WebElement getLogoutBtn()
{
	return logoutBTN;
}

@FindBy(className="ng-binding") private WebElement uidtext;
public WebElement getUiDText()
{
	return uidtext;
}

@FindBy(css="button.customButtonClass") private WebElement OkBTN;
public WebElement getOkBtn()
{
	return OkBTN;
}
@FindBy(css="p.ng-binding") private WebElement invalidCredentials;

public WebElement getIC()
{
	return invalidCredentials;
}
}



