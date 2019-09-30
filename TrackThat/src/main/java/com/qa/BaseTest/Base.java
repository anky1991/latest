package com.qa.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.listners.FWListners;
//@Listeners(MPLLC.TrackThat.FWListners.class)
public class Base extends FWListners
{
   public Logger log=Logger.getLogger(Base.class);
   public static WebDriver driver;
   public Properties prop;
   public FileInputStream fis; 
   
   public void invokeBrowser(String BrowserName)
       { 
	   if(BrowserName.equalsIgnoreCase("Chrome"))
	   {
		   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/Linux/chromedriver");
		   driver = new ChromeDriver();   
		   log.info("Chrome Browser Load Successfully");
	   }
	   else if(BrowserName.equalsIgnoreCase("FF")) 
	   {
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/Linux/geckodriver");
			System.setProperty("webdriver.gecko.driver", "/home/local/MPROG/ankit.sharma/Downloads/geckodriver");
			driver = new FirefoxDriver();
			log.info("Firefox Browser Load succesfully");
	   }
	   else if(BrowserName.equalsIgnoreCase("Safari"))
	   {
			driver = new SafariDriver();
	   }
	   else if(BrowserName.equalsIgnoreCase("IE")) 
	   {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer");
	   }
	 	driver.manage().window().maximize();
   		driver.manage().deleteAllCookies();
   		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   		driver.get(prop.getProperty("URL"));
		log.info("WebApp URL "+":"+prop.getProperty("URL")+" "+ "Load Successfully");
	   }
   
       public void loadProperties()
       {
    	   prop =new Properties() ;
   	       File f = new File(System.getProperty("user.dir"));
    	   File fSrc = new File(f, "data.properties");
    		try 
    		{
    		  fis = new FileInputStream(fSrc.getAbsolutePath());
    		} catch (FileNotFoundException e1) 
    		{
    		  e1.printStackTrace();
    		}
    		try
    		{
    		  prop.load(fis);
   		      log.info("Properties file load Successfully");
    	 	} catch (IOException e)
    		{
    		  e.printStackTrace();
    		}
       }
       
  /*  @DataProvider
   	public Object[][] getData() 
   	{
   		Object[][] arr = new Object[3][2];
   		arr[0][0] = "test@m.com";
   		arr[0][1] = "aaaaaa";
   		arr[1][0] = "pes@g.com";
   		arr[1][1] = "bbbb";
   		arr[2][0] = "f@a.com";
   		arr[2][1] = "ttttt";
   		return arr;
   	}*/
    
	public void quiteBroswer()
	 {
	   driver.quit();
	   log.info("Broswer Quit Succesfully");
     }	
  }
