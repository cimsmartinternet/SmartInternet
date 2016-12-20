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
	@FindBy(how=How.XPATH,using="//div[contains(@class, 'tabs__nav-title style-scope') and .//text()='Devices']") 
	WebElement Devices_Tab;

		
	@FindBy(how=How.XPATH,using="//div[@class='si-page-devices__device-list-assigned style-scope si-page-devices']//iron-pages/ul/li/a/div/div") 
	WebElement Device_Name;
	
	@FindBy(how=How.XPATH,using="//button[@class='header-call-to-action style-scope si-page-device-entity']") 
	WebElement Device_Entity_Page_Change_link;
	
	@FindBy(how=How.CSS,using="#si-input-text-11") 
	WebElement Device_Nickname_Box;
	
	@FindBy(how=How.XPATH,using="//button[contains(@class, 'style-scope si-settings') and .//text()='Apply Changes']") 
	WebElement Apply_Changes_Button;
	
	@FindBy(how=How.XPATH,using="(.//*[@id='pages']/div[3]/div/button)[3]") 
	WebElement Close_Button;
	
	@FindBy(how=How.XPATH,using="(//*[@class='style-scope si-back-button'])[1]") 
	WebElement Back_Button;
}
