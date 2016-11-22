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
	
	public String getChromePath()
	{
		String path=pro.getProperty("ChromePath");
		return path;
	}
	
	public String getFFPath()
	{
		String path=pro.getProperty("FirefoxPath");
		return path;
	}
	
	public String getIEPath()
	{
		String path=pro.getProperty("IEPath");
		return path;
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("SIapplicationURL");
		return url;
	}
	public String getStagingURL()
	{
		String url=pro.getProperty("SIstagingURL");
		return url;
	}
	
	public String getProductionURL()
	{
		String url=pro.getProperty("SIproductionURL");
		return url;
	}
	
	public String getPrimaryUname()
	{
		String uname=pro.getProperty("PrimaryUname");
		return uname;
	}
	
	public String getPrimaryPwd()
	{
		String pwd=pro.getProperty("PrimaryPwd");
		return pwd;
	}
	
}
