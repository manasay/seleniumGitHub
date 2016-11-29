package in.jsoft.newtours.allpagesfunctionality;

import org.openqa.selenium.WebDriver;

public class NewToursFlightConfirmationPage {

	private WebDriver driver;
	
	public NewToursFlightConfirmationPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public String getFlightTitle()
	{
		return driver.getTitle();
	}
}
