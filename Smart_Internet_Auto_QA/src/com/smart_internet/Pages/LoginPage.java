/**
 * 
 * 
 */
package com.smart_internet.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



/**
 * @author 266963
 *
 *  This class will store all the locators and methods of Login Page
 *
 */
public class LoginPage 

{
	WebDriver driver;
	
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	
	@FindBy(how=How.XPATH,using="//a[contains(@class, 'style-scope si-page') and .//text()='Sign In']") 
	WebElement SignInButton_Page;
	
	@FindBy(how=How.XPATH,using="//a[contains(@class, 'polaris-link') and .//text()='Sign In']")
	WebElement SignInButton_Polaris;
	
	@FindBy(how=How.ID,using="user") 
	WebElement uname_field;
	
	@FindBy(how=How.ID,using="passwd") 
	WebElement password_field;
	
	@FindBy(how=How.ID,using="sign_in")
	WebElement signin_btn;
	
	// Login in using Polaris Sign in link
	public void loginPolaris(String uname, String pwd)
	{
		SignInButton_Polaris.click();
		uname_field.sendKeys(uname);
		password_field.sendKeys(pwd);
		signin_btn.click();
	}
	
	// Login in using SI page Sign in button
	public void loginPage(String uname,String pwd)
	
	{
		SignInButton_Page.click();
		uname_field.sendKeys(uname);
		password_field.sendKeys(pwd);
		signin_btn.click();
				
		
	}
	
			
}
