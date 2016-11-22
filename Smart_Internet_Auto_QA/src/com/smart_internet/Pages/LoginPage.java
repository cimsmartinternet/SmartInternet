/**
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
	
	

	@FindBy(how=How.XPATH,using="html/body/si-page-login/si-front-door/div[1]/div[1]/a") 
	WebElement SignInButton_Page;
	
	@FindBy(how=How.XPATH,using=".//*[@id='polaris-header']/div/ul[2]/li[7]/a")
	WebElement SignInButton_Polaris;
	
	@FindBy(how=How.ID,using="user") 
	WebElement uname_field;
	
	@FindBy(how=How.ID,using="passwd") 
	WebElement password_field;
	
	@FindBy(how=How.ID,using="sign_in")
	WebElement signin_btn;
	
	
	public void loginPolaris(String uname, String pwd)
	{
		SignInButton_Page.click();
		uname_field.sendKeys(uname);
		password_field.sendKeys(pwd);
		signin_btn.click();
	}
	
	public void loginPage(String uname,String pwd)
	
	{
		SignInButton_Polaris.click();
		uname_field.sendKeys(uname);
		password_field.sendKeys(pwd);
		signin_btn.click();
		
		
	}
	
			
}
