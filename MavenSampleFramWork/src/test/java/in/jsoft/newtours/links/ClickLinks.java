package in.jsoft.newtours.links;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickLinks {

	private WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void verifyLinks() throws InterruptedException {
		List<WebElement> no = driver.findElements(By.xpath("//td[p[img[@alt='Mercury Tours']]]" + "/table/tbody/tr"));
		int nooflinks = no.size();
		System.out.println(nooflinks);
		for (int i = 1; i <= nooflinks; i++) {
			TimeUnit.SECONDS.sleep(3);
			WebElement we = driver.findElement(By.xpath("//td[p[img[@alt='Mercury Tours']]]" + "//tr[" + i + "]//a"));
			// WebElement we = no.get(i).findElement(By.xpath("//a"));

			String linktext = we.getText();
			System.out.println(linktext);
			we.click();

			//

		}

	}

}
