package in.jsoft.newtours.allpagesfunctionality;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewToursRegistrationPage {

//	private WebDriver driver;
//	
//	NewToursRegistrationPage(WebDriver driver)
//	{
//		this.driver=driver;
//	}
	
	@FindBy(xpath="//input[@name='firstName']") private WebElement firstName;
	public void setFirstName(String fn)
	{
		firstName.sendKeys(fn);
	}
	
	@FindBy(xpath="//input[@name='lastName']") private WebElement lastName;
	public void setLastName(String ln)
	{
		lastName.sendKeys(ln);
	}
	
	@FindBy(xpath="//input[@name='phone']") private WebElement phone;
	public void setPhone(String ph)
	{
		phone.sendKeys(ph);
	}
	
	@FindBy(xpath="//input[@id='userName']") private WebElement email;
	public void setEmail(String em)
	{
		email.sendKeys(em);
	}
	
	
	
	@FindBy(xpath="//input[@name='address1']") private WebElement address;
	public void setAdd(String ad)
	{
		address.sendKeys(ad);
	}
	
	
	@FindBy(xpath="//input[@name='city']") private WebElement city;
	public void setCity(String c)
	{
		city.sendKeys(c);
	}
	
	@FindBy(xpath="//input[@name='state']") private WebElement state;
	public void setState(String st)
	{
		state.sendKeys(st);
	}
	
	@FindBy(xpath="//input[@name='postalCode']") private WebElement postalCode;
	public void setpostalCode(String pc)
	{
		postalCode.sendKeys(pc);
	}
	
	
	@FindBy(xpath="//select[@name='country']") private WebElement country;
	public void setcountry(String ct) throws InterruptedException
	{
		
		TimeUnit.SECONDS.sleep(5);
		Select s = new Select(country);
		s.selectByVisibleText(ct);
	}
	
	
	@FindBy(xpath="//input[@id='email']") private WebElement userName;
	public void setuserName(String un)
	{
		userName.sendKeys(un);
	}
	
	@FindBy(xpath="//input[@name='password']") private WebElement pwd;
	public void setpwd(String pw)
	{
		pwd.sendKeys(pw);
	}
	
	
	@FindBy(xpath="//input[@name='confirmPassword']") private WebElement conPwd;
	public void conPwd(String cp)
	{
		pwd.sendKeys(cp);
	}
	
	@FindBy(xpath="//input[@name='register']") private WebElement submit;
	public void clickSubmit() 
	{
		submit.click();
	}
}
