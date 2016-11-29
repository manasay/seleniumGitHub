package in.jsoft.newtours.testscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import in.jsoft.newtours.allpagesfunctionality.NewToursFlightConfirmationPage;
import in.jsoft.newtours.allpagesfunctionality.NewToursHomePage;
import in.jsoft.newtours.allpagesfunctionality.NewToursRegConfirmationPage;
import in.jsoft.newtours.allpagesfunctionality.NewToursRegistrationPage;
import in.jsoft.newtours.allpagesfunctionality.NewToursSignOn;
import in.jsoft.newtours.constants.AllConstants;
import in.jsoft.newtours.utility.Browser;
import in.jsoft.newtours.utility.Library;
import in.jsoft.newtours.utility.ListenersClass;
import in.jsoft.newtours.utility.TestDataProvider;


@Listeners(ListenersClass.class)


public class AllTestCases {

	private WebDriver driver = null;
	private NewToursHomePage hp = null;
	


	@Parameters({ "bname" })
	@BeforeMethod
	public void beforeHomePage(@Optional("me") String n) throws IOException {

		try {
			System.out.println("ff");

			driver = Browser.getBrowser(n);

			driver.get(Library.getLocators("appUrl", AllConstants.CONFIGFILE));
			hp = PageFactory.initElements(driver, NewToursHomePage.class);
		} catch (Exception e) {
			String errormsg = e.getMessage();
			
		}

	}

	@Test(dataProvider = "NewTours", dataProviderClass = TestDataProvider.class) // 4
	public void verifyHomePage(String f1,String rowNum) throws IOException {

		String testResult = "fail";
		String errMsg = "";
		try {
			String actualResult = hp.getHomePageTitle();
			System.out.println("Hello" + actualResult);
//			String expectedResult =  Library.getLocators("expectedTitle",
//									 AllConstants.HOMEFILE);
			
			String expectedResult =  f1;
			System.out.println("Hello" + expectedResult);
			//System.out.println("The Rownum is:" + new Integer(rownum));
			Assert.assertEquals(actualResult, expectedResult);
			testResult = "pass";
		} catch (Exception e) {
			Library.takeScreenShot(driver, driver.getTitle());
			// e.printStackTrace();
			errMsg = e.getMessage();
		} catch (Error e) {
			// String errmsg = er.getMessage();
			errMsg = e.getMessage();
			Library.takeScreenShot(driver, driver.getTitle());
			throw e;
		} finally {
			try {
				TestDataProvider.writeExcel(testResult, new Integer(rowNum), AllConstants.RESULTCELL);
				TestDataProvider.writeExcel(errMsg, new Integer(rowNum), AllConstants.ERRORCELL);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Test(dataProvider = "NewTours", dataProviderClass = TestDataProvider.class)
	public void verifyRegistrationPage(String f1, String f2, String f3, String f4, String f5, String f6, String f7,
			String f8, String f9, String f10, String f11, String f12, String f13, String rownum)
			throws IOException, InterruptedException {

		String testResult = "fail";
		String errMsg = "";
		try {

			hp.clickRegister();

			NewToursRegistrationPage rp = PageFactory.initElements(driver, NewToursRegistrationPage.class);
			TimeUnit.SECONDS.sleep(5);
			String firstName = f1;// Library.getLocators("FirstName",
									// AllConstants.REGFILE);
			rp.setFirstName(firstName);

			String lastName = f2;// Library.getLocators("LastName",
									// AllConstants.REGFILE);
			rp.setLastName(lastName);

			String phone = f3;// Library.getLocators("phone",
								// AllConstants.REGFILE);
			rp.setPhone(phone);

			String email = f4;// Library.getLocators("Email",
								// AllConstants.REGFILE);
			rp.setEmail(email);

			String address = f5;// Library.getLocators("Address",
								// AllConstants.REGFILE);
			rp.setAdd(address);

			String city = f6;// Library.getLocators("City",
								// AllConstants.REGFILE);
			rp.setCity(city);

			String state = f7;// Library.getLocators("State",
								// AllConstants.REGFILE);
			rp.setState(state);

			String postalCode = f8;// Library.getLocators("Postal",
									// AllConstants.REGFILE);
			rp.setpostalCode(postalCode);

			String country = f9;// Library.getLocators("Country",
								// AllConstants.REGFILE);
			rp.setcountry(country);

			String username = f10;// Library.getLocators("UserName",
									// AllConstants.REGFILE);
			rp.setuserName(username);

			String pwd = f11;// Library.getLocators("Password",
								// AllConstants.REGFILE);
			rp.setpwd(pwd);

			String confirmpwd = f12;// Library.getLocators("confirmpwd",
									// AllConstants.REGFILE);
			rp.conPwd(confirmpwd);

			rp.clickSubmit();

			TimeUnit.SECONDS.sleep(5);

			NewToursRegConfirmationPage np = PageFactory.initElements(driver, NewToursRegConfirmationPage.class);
			String actualResult = np.getConfirmationText();
			System.out.println(actualResult);
			System.out.println("------------------------------------");
			String expectedResult = f13;// Library.getLocators("expectedTitle",AllConstants.CONFIRMFILE);

			System.out.println(f13);
			System.out.println("------------------------------------");
			Assert.assertEquals(actualResult, expectedResult);
		} catch (Exception e) {
			Library.takeScreenShot(driver, driver.getTitle());
			// e.printStackTrace();
			errMsg = e.getMessage();
		} catch (Error e) {
			// String errmsg = er.getMessage();
			errMsg = e.getMessage();
			Library.takeScreenShot(driver, driver.getTitle());
			throw e;
		} finally {
			try {
				TestDataProvider.writeExcel(testResult, new Integer(rownum), AllConstants.RESULTCELL);
				TestDataProvider.writeExcel(errMsg, new Integer(rownum), AllConstants.ERRORCELL);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Test(dataProvider = "NewTours", dataProviderClass = TestDataProvider.class)
	public void verifySignOn(String f1, String f2, String rownum) throws IOException, InterruptedException {
		String testResult = "fail";
		String errMsg = "";

		try {
			hp.clickSignOn();

			NewToursSignOn ns = PageFactory.initElements(driver, NewToursSignOn.class);
			TimeUnit.SECONDS.sleep(5);

			String username = f1;// Library.getLocators("username",
									// AllConstants.SIGNONFILE);
			ns.setUserName(username);

			String pwd = f2;// Library.getLocators("password",
							// AllConstants.SIGNONFILE);
			ns.setPassword(pwd);

			ns.clickSubmit();

			TimeUnit.SECONDS.sleep(5);

			NewToursFlightConfirmationPage fc = new NewToursFlightConfirmationPage(driver);
			String actualResult = fc.getFlightTitle();
			String expectedResult = Library.getLocators("expectedTitle", AllConstants.FLIGHTFILE);
			Assert.assertEquals(actualResult, expectedResult);
		} catch (Exception e) {
			Library.takeScreenShot(driver, driver.getTitle());
			// e.printStackTrace();
			errMsg = e.getMessage();
		} catch (Error e) {
			// String errmsg = er.getMessage();
			errMsg = e.getMessage();
			Library.takeScreenShot(driver, driver.getTitle());
			throw e;
		} finally {
			try {
				TestDataProvider.writeExcel(testResult, new Integer(rownum), AllConstants.RESULTCELL);
				TestDataProvider.writeExcel(errMsg, new Integer(rownum), AllConstants.ERRORCELL);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@AfterMethod()
	public void afterMethod() {
		hp.closeBrowser();
	}
	
	@AfterSuite
	public void testCount()
	{
		System.out.println("Total TestCases executed:");
		System.out.println(ListenersClass.passCount);
	}
}
