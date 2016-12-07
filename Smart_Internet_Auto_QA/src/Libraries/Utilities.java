/**
 * 
 */
package Libraries;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;



/**
 * @author 266963
 * 
 *  This will have most common used methods
 *
 */
public class Utilities 

{
	static RemoteWebDriver driver;
	
	//method for selecting and initiating the browser
	
	public static RemoteWebDriver startBrowser(String browsername)
	{
		ConfigReader config=new ConfigReader();
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",config.getChromePath());
			driver =  new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",config.getFFPath());
			driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",config.getIEPath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
		
	}
	
	//method for highlighting an element
	public static void highLightElement(RemoteWebDriver driver,WebElement element)
	{
		JavascriptExecutor js=driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
		try
		{
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style', border:  solid 2px white;');", element);
		
	}
	
	
	
	//method to mouse hover on an element
	
	public static WebDriver mouseHover(RemoteWebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		return driver;
		
	}	
		
	//method to take screenshots
	
	public static String captureScreenshots(RemoteWebDriver driver, String screenshotname)
	{
		try {
			TakesScreenshot ts=driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			String dest="C:\\Users\\266963\\git\\Local_Smart_Internet_Auto_QA\\Smart_Internet_Auto_QA\\Screenshots\\"+screenshotname+".png";
			File destination=new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot taken");
			return dest;
			} 
		catch (Exception e) 
			{
			System.out.println("Exception while taking screenshot"+e.getMessage());
			return e.getMessage();
			} 
			
	}	
	
	//method to take text box
	public void TextBox (String element, String text) throws Exception
	{
		WebElement text2 = driver.findElementById(element);	
		text2.sendKeys(text);
		System.out.println(element);	
	}
	
	//method to take dropdown
	public void Dropdown (String str1, String str2)
	{
		WebElement dropdown1 = driver.findElementByName(str1);
		Select se = new Select(dropdown1);
		se.selectByVisibleText(str2);
		List<WebElement>sele =driver.findElementsByTagName("a");
		System.out.println(sele.size());
		for(int i=0;i<sele.size();i++)
		{
			System.out.println(sele.get(i).getText());
		}
		
	}
	
	//method to take radio button
	public void radio (String rad)
	{
		Boolean state;
		WebElement radio = driver.findElement(By.id(rad));
		state = radio.isSelected();
		System.out.println(state);
		radio.click();
		
	}
	
	//method to take check box
	public void checkbox (String chk)
	{
		WebElement chkbx = driver.findElement(By.id(chk));
		chkbx.click();
	}
}
