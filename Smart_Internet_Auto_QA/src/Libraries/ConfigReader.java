package Libraries;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


/**
 * @author 266963
 * 
 *  This class contains method to access the congig file 
 *
 */

public class ConfigReader 
{
	Properties pro;
	public ConfigReader()
	{
		try 
		{
			File src=new File("./Configuration/Config.property");
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}	
	
	//method to get the chrome path
	public String getChromePath()
	{
		String path=pro.getProperty("ChromePath");
		return path;
	}
	
	//method to get the Firefox path
	public String getFFPath()
	{
		String path=pro.getProperty("FirefoxPath");
		return path;
	}
	
	//method to get the InternetExplorer path
	public String getIEPath()
	{
		String path=pro.getProperty("IEPath");
		return path;
	}
	
	//method to get the application URL
	public String getApplicationURL()
	{
		String url=pro.getProperty("SIapplicationURL");
		return url;
	}
	
	//method to get the staging URL
	public String getStagingURL()
	{
		String url=pro.getProperty("SIstagingURL");
		return url;
	}
	
	//method to get the production URL
	public String getProductionURL()
	{
		String url=pro.getProperty("SIproductionURL");
		return url;
	}
	
	//method to get the primary user name
	public String getPrimaryUname()
	{
		String uname=pro.getProperty("PrimaryUname");
		return uname;
	}
	
	//method to get the primary password
	public String getPrimaryPwd()
	{
		String pwd=pro.getProperty("PrimaryPwd");
		return pwd;
	}
	
	//method to get the Wrong user name
	public String getWrongUname()
	{
		String uname=pro.getProperty("WrongUname");
		return uname;
	}
		
	//method to get the Wrong password
	public String getWrongPwd()
	{
		String pwd=pro.getProperty("WrongPwd");
		return pwd;
	}
		
	//method to get the Staging user name
	public String getStgUname()
	{
		String uname=pro.getProperty("StagingUname");
		return uname;
	}
				
	//method to get the Staging password
	public String getStgPwd()
	{
		String pwd=pro.getProperty("StagingPwd");
		return pwd;
	}
	
	//method to get the browser 
	public String getBrowser()
	{
		String browser=pro.getProperty("Browser");
		return browser;
	}
	
}
