/**
 * 
 */
package Libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


/**
 * @author 266963
 * 
 *  This will invoke the browsers according to users preference 
 *
 */
public class Utitlities 

{
	static WebDriver driver;
	
	//method for selecting and initiating the browser
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
	
	
		
}
