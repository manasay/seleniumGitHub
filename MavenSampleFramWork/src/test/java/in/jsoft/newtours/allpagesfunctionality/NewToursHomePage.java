package in.jsoft.newtours.allpagesfunctionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewToursHomePage {

	private	WebDriver driver;
	
	public NewToursHomePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String getHomePageTitle()
	{
		return driver.getTitle();
		
	}
	
	@FindBy(xpath="//a[text()='REGISTER']") private WebElement we;
	
	public void clickRegister()
	{
		we.click();
	}
	
	@FindBy(xpath="//a[text()='SIGN-ON']") private WebElement we1;
	
	public void clickSignOn()
	{
		we1.click();
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
}
