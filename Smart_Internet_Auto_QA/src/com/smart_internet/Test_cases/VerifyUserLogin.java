/**
 * 
 */
package com.smart_internet.Test_cases;


import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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
	
	ExtentReports report;
	ExtentTest logger;
	RemoteWebDriver driver;
	SoftAssert assertion;
	ConfigReader config;
	LoginPage ele;
	
	
	// Test to validate the sign in action via sign in button on the page
	@Test
	public void Usrlogin_page() 
	{
		
	/*report=new ExtentReports("C:\\Users\\266963\\git\\Local_Smart_Internet_Auto_QA\\Smart_Internet_Auto_QA\\Reports\\Login.html");
	logger=report.startTest("Usrlogin_page");*/
	config=new ConfigReader();
	driver=Utilities.startBrowser("chrome");
	driver.get(config.getApplicationURL());
	LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
	login_page.loginPage(config.getPrimaryUname(),config.getPrimaryPwd());
	String actual=driver.getTitle();
	assertion=new SoftAssert();
	assertion.assertEquals(actual, "Your WiFi - XFINITY Internet");
	assertion.assertAll();
	System.out.println("********************Sign in is successful from the page*****************");
	
	}
	
	// Test to validate the sign in action via sign in link on the polaris
	@Test
	public void userlogin_Polaris() 
	{
		/*report=new ExtentReports("C:\\Users\\266963\\git\\Local_Smart_Internet_Auto_QA\\Smart_Internet_Auto_QA\\Reports\\Usrlogin_page.html");
		logger=report.startTest("userlogin_Polaris");*/
		config=new ConfigReader();
		driver=Utilities.startBrowser("chrome");
		driver.get(config.getApplicationURL());
		LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
		login_page.loginPolaris(config.getPrimaryUname(),config.getPrimaryPwd());
		String actual=driver.getTitle();
		assertion=new SoftAssert();
		assertion.assertEquals(actual, "Your WiFi - XFINITY Internet");
		assertion.assertAll();
		System.out.println("********************Sign in is successful from Polaris*****************");
		
	}
	
	// Test to validate the sign in action with a wrong user name/password
	@Test
	public void userlogin_negetiveScenario()
	{
		/*report=new ExtentReports("C:\\Users\\266963\\git\\Local_Smart_Internet_Auto_QA\\Smart_Internet_Auto_QA\\Reports\\Usrlogin_page.html");
		logger=report.startTest("userlogin_negetiveScenario");*/
		config=new ConfigReader();
		driver=Utilities.startBrowser("chrome");
		driver.get(config.getApplicationURL());
		LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
		login_page.loginPolaris(config.getWrongUname(),config.getWrongPwd());
		String msg=driver.findElementByXPath("//p[@class='error_message']").getText();
		Assert.assertEquals(msg, "The username and password entered do not match. Please try again.");
		System.out.println("********************Sign in unsuccessful with wrong user name/password, scenario passed*****************");
		
	}
	
	// Method to close the browser after each test
	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Thread.sleep(5000);
			String screenshot_path=Utilities.captureScreenshots(driver, result.getName());
			String img=logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "Usrlogin_page", img);
			driver.close();
		}
		else
		{
			report.endTest(logger);
			report.flush();
			driver.close();
		}
	}
}
