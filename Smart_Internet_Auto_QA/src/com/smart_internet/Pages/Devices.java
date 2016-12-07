/**
 * 
 */
package com.smart_internet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author 266963
 *
 */
public class Devices 
{


	@FindBy(how=How.XPATH,using="//button[@class='header-call-to-action style-scope si-page-device-entity']") 
	WebElement Device_Entity_Page_Change_link;
	
	@FindBy(how=How.XPATH,using="(.//*[@id='states']/ul)[2]/li[1]/a/div") 
	WebElement Device_Name;
	
	@FindBy(how=How.XPATH,using="//form[@id='form']/div[1]/div/si-input-text") 
	WebElement Device_Nickname_Box;
	
	@FindBy(how=How.XPATH,using=".//*[@id='form']/div[2]/button[1]") 
	WebElement Apply_Changes_Button;
	
	@FindBy(how=How.XPATH,using=".//*[@id='pages']/div[3]/div/button") 
	WebElement Close_Button;
	
	@FindBy(how=How.XPATH,using=".//*[@id='pages']/div[3]/div/button") 
	WebElement Back_Button;
}
