/**
 * 
 */
package com.smart_internet.Test_cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.smart_internet.Pages.Devices;
import com.smart_internet.Pages.LoginPage;

import Libraries.ConfigReader;
import Libraries.Utilities;

/**
 * @author 266963
 * 
 * This Test will verify the device rename functionality in device tab
 *
 */
public class VerifyDeviceRename
{
	
	
	RemoteWebDriver driver;
	ConfigReader config;
	
	@Test
	public void VerifyDeviceRenameCheck() throws InterruptedException
	{
		config=new ConfigReader();
		driver=Utilities.startBrowser("chrome");
		driver.get(config.getApplicationURL());
		LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
		login_page.loginPolaris(config.getStgUname(),config.getStgPwd());
		Devices dev=PageFactory.initElements(driver, Devices.class);
		Thread.sleep(10000);
		dev.VerifyDeviceRename();
		
	
	}
	
	

}
