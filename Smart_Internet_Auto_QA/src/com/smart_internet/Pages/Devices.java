/**
 * 
 */
package com.smart_internet.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author 266963
 *
 */
public class Devices {

	RemoteWebDriver driver;
	String expected_result;

	public Devices(WebDriver ldriver) {
		this.driver = (RemoteWebDriver) ldriver;
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'tabs__nav-title style-scope') and .//text()='Devices']")
	public static WebElement Devices_Tab;

	@FindBy(how = How.XPATH, using = "//div[@class='si-page-devices__device-list-assigned style-scope si-page-devices']//iron-pages/ul/li/a/div/div")
	static List<WebElement> Device_Name;

	@FindBy(how = How.XPATH, using = "//button[@class='header-call-to-action style-scope si-page-device-entity']")
	static WebElement Device_Entity_Page_Change_link;

	@FindBy(how = How.CSS, using = "#si-input-text-11")
	static WebElement Device_Nickname_Box;

	@FindBy(how = How.XPATH, using = "//button[contains(@class, 'style-scope si-settings') and .//text()='Apply Changes']")
	static WebElement Apply_Changes_Button;

	@FindBy(how = How.XPATH, using = "(.//*[@id='pages']/div[3]/div/button)[3]")
	static WebElement Close_Button;

	@FindBy(how = How.XPATH, using = "//div[@class='si-page-device-entity__heading style-scope si-page-device-entity']/div/h1")
	static WebElement Devicename_cleared;

	@FindBy(how = How.XPATH, using = "(//*[@class='style-scope si-back-button'])[1]")
	static WebElement Back_Button;

	@FindBy(how = How.XPATH, using = "(.//*[@id='states']/ul/li[1]/div/button)[2]")
	static WebElement Name_Link;

	public void VerifyDeviceRename() throws InterruptedException {

		Devices_Tab.click();
		Thread.sleep(1000);

		List<WebElement> listofelements = Device_Name;
		for (WebElement ele : listofelements) {
			System.out.println(listofelements.size());
			System.out.println(ele.getText());
			expected_result = ele.getText();
			try {
				ele.click();
				System.out.println(expected_result);
				break;
			} catch (Exception e) {

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,1671)", "");
				Thread.sleep(500);
				ele.click();
				break;
			}

		}

		Device_Entity_Page_Change_link.click();
		System.out.println("click is done");
		Thread.sleep(500);
		Device_Nickname_Box.clear();
		System.out.println("text field cleared");
		Thread.sleep(500);
		Apply_Changes_Button.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//*[@id='pages']/div[3]/div/button)[3]")));
		Close_Button.click();
		System.out.println("closed");
		Thread.sleep(5000);
		System.out.println(Devicename_cleared.getText());
		Back_Button.click();
		Thread.sleep(5000);
		System.out.println("Back button clicked");

		System.out.println(listofelements.size());
		Thread.sleep(5000);

		for (WebElement selected_device : listofelements) {

			String actual_device_name = selected_device.getText();
			System.out.println(actual_device_name);

			System.out.println("*****************************************************");

			if (Devicename_cleared.getText().trim().equals(selected_device.getText().trim())) {
				System.out.println("inside loop");
				break;
			} else {
				System.out.println("Device not found");
			}
			System.out.println("Device found");
			System.out.println(actual_device_name);

			System.out.println("*******************************************************");

		}

		String actual = Name_Link.getText();
		String expected = "Name";

		String[] value = actual.split("\\s+");

		if (value[0].trim().equals(expected))

		{
			System.out.println("Test case passed");
			driver.close();
		} else {
			System.out.println("Test case failed");
			driver.close();
		}

	}
}
