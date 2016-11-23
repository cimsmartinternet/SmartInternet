package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

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
	
	//method to get the primary username
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
	
}
