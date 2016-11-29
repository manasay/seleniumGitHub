package in.jsoft.newtours.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Library {

	public static String getLocators(String s1,String s2) throws IOException
	{
		FileInputStream ft = new FileInputStream(s2);
		Properties p = new Properties();
		p.load(ft);
		return p.getProperty(s1);
		
	}
	
	public static void takeScreenShot(WebDriver driver, String name) throws IOException
	{
		String fileName = getCurrentSysTime()+"_"+name.replace(":", "").replace("/", "");
		System.out.println("------------------------"+fileName);
	
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrFile, new File("c:\\tmp\\"+fileName+".png"));
	}
	
	public static String getCurrentSysTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	
}
