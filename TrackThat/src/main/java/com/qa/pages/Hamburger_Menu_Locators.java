package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseTest.Base;

public class Hamburger_Menu_Locators extends Base
{

public Hamburger_Menu_Locators()
{
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//div[text()='Menu']") private WebElement menuIcon;

public WebElement getmenuIcon()
{
	return menuIcon;
}
@FindBy(css="img[src='img/pacira_logo11.png']") private WebElement TrackLogo;

public WebElement getTrackLogo()
{
	return TrackLogo;
}
}
