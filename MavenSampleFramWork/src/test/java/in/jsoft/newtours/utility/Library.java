package in.jsoft.newtours.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Library {

	public static String getLocators(String s1,String s2) throws IOException
	{
		FileInputStream ft = new FileInputStream(s2);
		Properties p = new Properties();
		p.load(ft);
		return p.getProperty(s1);
		
	}
}
