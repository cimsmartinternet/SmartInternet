/**
 * 
 */
package Libraries;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;


/**
 * @author 266963
 * 
 *  This will have most common used methods
 *
 */
public class Utilities 

{
	static WebDriver driver;
	
	//method for selecting and initiating the browser
	@BeforeTest
	public static WebDriver startBrowser(String browsername)
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
		return driver;
		
	}
	
	//method for highlighting an element
	public static WebDriver highLightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
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
		return driver;
	}
	
	//method to mouse hover on an element
	
	public static WebDriver mouseHover(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		return driver;
		
	}	
		
}
