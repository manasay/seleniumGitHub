package in.jsoft.newtours.allpagesfunctionality;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewToursRegConfirmationPage {

	
	
	@FindBy(xpath="//tbody/tr[3]/td[p]") private WebElement we;
	public String getConfirmationText()
	{
		return we.getText();
		
		
	}
	
}
