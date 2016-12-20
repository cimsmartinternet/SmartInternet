/**
 * 
 */
package com.smart_internet.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author 266963
 *
 */
public class Devices 
{
	
RemoteWebDriver driver;
String 	expected_result;
	
	public Devices(WebDriver ldriver)
	{
		this.driver=(RemoteWebDriver) ldriver;
	}
	
	@FindBy(how=How.XPATH,using="//div[contains(@class, 'tabs__nav-title style-scope') and .//text()='Devices']") 
	public static WebElement Devices_Tab;

		
	@FindBy(how=How.XPATH,using="//div[@class='si-page-devices__device-list-assigned style-scope si-page-devices']//iron-pages/ul/li/a/div/div") 
	static List<WebElement> Device_Name;
	
	@FindBy(how=How.XPATH,using="//button[@class='header-call-to-action style-scope si-page-device-entity']") 
	static WebElement Device_Entity_Page_Change_link;
	
	@FindBy(how=How.CSS,using="#si-input-text-11") 
	static WebElement Device_Nickname_Box;
	
	@FindBy(how=How.XPATH,using="//button[contains(@class, 'style-scope si-settings') and .//text()='Apply Changes']") 
	static WebElement Apply_Changes_Button;
	
	@FindBy(how=How.XPATH,using="(.//*[@id='pages']/div[3]/div/button)[3]") 
	static WebElement Close_Button;
	
	@FindBy(how=How.XPATH,using="(//*[@class='style-scope si-back-button'])[1]") 
	static WebElement Back_Button;
	
	@FindBy(how=How.XPATH,using="(.//*[@id='states']/ul/li[1]/div/button)[2]") 
	static WebElement Name_Link;
	
	
	public void VerifyDeviceRename() throws InterruptedException
	{

		Devices_Tab.click();
		Thread.sleep(1000);
		
		
		List<WebElement> listofelements = Device_Name;
		for(WebElement ele: listofelements)
		{
			System.out.println(listofelements.size());
			System.out.println(ele.getText());
			expected_result = ele.getText();
			ele.click();
			System.out.println(expected_result);
			break;
			
		}
		
		Device_Entity_Page_Change_link.click();
		System.out.println("click is done");
		Thread.sleep(500);
		Device_Nickname_Box.clear();
		System.out.println("text field cleared");
		Thread.sleep(500);
		Apply_Changes_Button.click();
		Thread.sleep(10000);
		Close_Button.click();
		System.out.println("closed");
		Thread.sleep(1000);
		Back_Button.click();
		System.out.println("Back button clicked");
		
		System.out.println(listofelements.size());
		Thread.sleep(5000);
		
		for (WebElement selected_device : listofelements)
		{
		
			String actual_device_name = selected_device.getText();
			System.out.println(actual_device_name);
			
			System.out.println("*****************************************************");
			
			if (expected_result.equals(selected_device.getText()))
			{
			System.out.println("inside loop");
			break;
			}
			else
			{
			System.out.println("Device not found");
			}
			System.out.println("Device found");
			System.out.println(actual_device_name);
			
			System.out.println("*******************************************************");
			
		}
		
		String output = Name_Link.getText();	
		output.equals("Name");
		System.out.println(output);
		System.out.println("1st Test completed");
	}
}
