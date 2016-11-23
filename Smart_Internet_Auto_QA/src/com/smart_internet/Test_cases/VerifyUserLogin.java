/**
 * 
 */
package com.smart_internet.Test_cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.smart_internet.Pages.LoginPage;
import Utility.BrowserActions;
import Utility.ConfigReader;




/**
 * @author 266963
 * 
 *  This Test will verify the user login with sign in button on the page and sign in link on polaris
 *
 */

@Test
public class VerifyUserLogin 

{
	WebDriver driver;
	ConfigReader config=new ConfigReader();
	
	
	// Test to validate the sign in action via sign in button on the page
	public void Usrlogin_page()
	{
	
	driver=BrowserActions.startBrowser("chrome");
	driver.get(config.getApplicationURL());
	LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
	login_page.loginPage(config.getPrimaryUname(),config.getPrimaryPwd());
	System.out.println("********************Sign in is successful from the page*****************");
	driver.close();
	}
	
	// Test to validate the sign in action via sign in link on the polaris
	public void userlogin_Polaris()
	{
		
		driver=BrowserActions.startBrowser("chrome");
		driver.get(config.getApplicationURL());
		LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
		login_page.loginPolaris(config.getPrimaryUname(),config.getPrimaryPwd());
		System.out.println("********************Sign in is successful from Polaris*****************");
		driver.close();
	}
}
