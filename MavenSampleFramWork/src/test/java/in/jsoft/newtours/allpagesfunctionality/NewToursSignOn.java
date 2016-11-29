package in.jsoft.newtours.allpagesfunctionality;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewToursSignOn {

	@FindBy(xpath="//input[@name='userName']") private WebElement we;
	public void setUserName(String un) 
	{
		 
		we.sendKeys(un);
	}
	
	@FindBy(xpath="//input[@name='password']") private WebElement we1;
	public void setPassword(String pwd) throws IOException
	{
		
		we1.sendKeys(pwd);
	}
	
	@FindBy(xpath="//input[@name='login']") private WebElement we2;
	public void clickSubmit() throws IOException 
	{
		
		we2.click();
	}
}
