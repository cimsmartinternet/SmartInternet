/**
 * 
 */
package com.smart_internet.Test_cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.smart_internet.Pages.LoginPage;

import Libraries.Utilities;
import Libraries.ConfigReader;





/**
 * @author 266963
 * 
 *  This Test will verify the user login with sign in button on the page and sign in link on Polaris. 
 *  This will also validate the login with invalid user name and password
 *
 */


public class VerifyUserLogin 

{
	

	RemoteWebDriver driver;
	ConfigReader config=new ConfigReader();
	LoginPage ele;
	
	
	// Test to validate the sign in action via sign in button on the page
	@Test
	public void Usrlogin_page() throws InterruptedException
	{
	
	driver=Utilities.startBrowser("chrome");
	driver.get(config.getApplicationURL());
	LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
	login_page.loginPage(config.getPrimaryUname(),config.getPrimaryPwd());
	Thread.sleep(500);
	String actual=driver.getTitle();
	Assert.assertEquals(actual, "Your WiFi - XFINITY Internet");
	System.out.println("********************Sign in is successful from the page*****************");
	driver.close();
	}
	
	// Test to validate the sign in action via sign in link on the polaris
	@Test
	public void userlogin_Polaris() throws InterruptedException
	{
		
		driver=Utilities.startBrowser("chrome");
		driver.get(config.getApplicationURL());
		LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
		login_page.loginPolaris(config.getPrimaryUname(),config.getPrimaryPwd());
		Thread.sleep(500);
		String actual=driver.getTitle();
		Assert.assertEquals(actual, "Your WiFi - XFINITY Internet");
		System.out.println("********************Sign in is successful from Polaris*****************");
		driver.close();
	}
	
	// Test to validate the sign in action with a wrong user name/password
	@Test
	public void userlogin_negetiveScenario()
	{
		
		driver=Utilities.startBrowser("chrome");
		driver.get(config.getApplicationURL());
		LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
		login_page.loginPolaris(config.getWrongUname(),config.getWrongPwd());
		String msg=driver.findElementByXPath("//p[@class='error_message']").getText();
		Assert.assertEquals(msg, "The username and password entered do not match. Please try again.");
		System.out.println("********************Sign in unsuccessful with wrong user name/password, scenario passed*****************");
		driver.close();
	}
}
