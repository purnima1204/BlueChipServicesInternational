package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

@Listeners(utilities.ExtentReportManager.class)
public class TC_001_HomePage extends BaseClass {
	
	
	@Test
	
	public void accountRegistration() throws InterruptedException
	{
		
		HomePage hp = new HomePage(driver);
		logger.info("Home page is Launched!");
		hp.clickRegisterBtn();
		logger.info("Clicked RegisterNow Button!");
		hp.clickStudentBtn();
		logger.info("Clicked STUDENT Button!");
		
		
		AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
		logger.info("Filling the Registration Form!");
		registrationPage.setName(randomString().toLowerCase());
		registrationPage.setPhoneNum(randomNumber());
		registrationPage.setEmail(randomString()+"@gmail.com");

        String password = randomPassword();
        registrationPage.setPassword(password);
        registrationPage.setCountry(randomString().toLowerCase());
        registrationPage.setAddress(randomAddress());
        
        registrationPage.clickSubmit();
        logger.info("Clicked Submit Button!");
        implicitWait();
	     String confirmMsg = registrationPage.getConfirmationmsg();
	     
	    // Assert.assertEquals(confirmMsg, "You successfully registered please login");
	     logger.info("Alert is captured!");
	     alert();
	}

}
