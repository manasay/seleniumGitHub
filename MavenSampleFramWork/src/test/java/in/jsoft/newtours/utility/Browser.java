package in.jsoft.newtours.utility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {

	static private WebDriver driver = null;
	
	public static WebDriver getBrowser(String s)
	{
		System.out.println(s);
		
		if(s.equalsIgnoreCase("ff"))
		{
			//System.setProperty("webdriver.gecko.driver", .//)
			driver = new FirefoxDriver();
		}
		
		else if(s.equalsIgnoreCase("me"))
		{
			driver = new EdgeDriver();
		}
		
		else if(s.equalsIgnoreCase("gc"))
		{
			driver = new ChromeDriver();
		}
		
		else if(s.equalsIgnoreCase("ie"))
		{
			driver = new InternetExplorerDriver();
		}
		
		return driver;
		
	}
	
	static 	String nodeURL = null;
	public static WebDriver getGridBrowser(String s) throws MalformedURLException
	{
		if(s.equalsIgnoreCase("ff"))
		{
			nodeURL = "http://localhost:5566/wd/hub";
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WIN10);
			driver = new RemoteWebDriver(new URL(nodeURL),capability);
		}
		
		else if(s.equalsIgnoreCase("me"))
		{
			nodeURL = "http://localhost:5566/wd/hub";
			DesiredCapabilities capability = DesiredCapabilities.edge();
			capability.setBrowserName("EDGE");
			capability.setPlatform(Platform.WIN10);
			driver = new RemoteWebDriver(new URL(nodeURL),capability);
		}
		
		else if(s.equalsIgnoreCase("gc"))
		{
			nodeURL = "http://localhost:5566/wd/hub";
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			capability.setBrowserName("Chrome");
			capability.setPlatform(Platform.WIN10);
			driver = new RemoteWebDriver(new URL(nodeURL),capability);
		}
		
		else if(s.equalsIgnoreCase("ie"))
		{
			nodeURL = "http://localhost:5566/wd/hub";
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
			capability.setBrowserName("IE");
			capability.setPlatform(Platform.WIN10);
			driver = new RemoteWebDriver(new URL(nodeURL),capability);
		}
		
		return driver;
	}
}
