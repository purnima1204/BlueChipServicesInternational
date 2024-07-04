package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;
import testBase.BaseClass;
@Listeners(utilities.ExtentReportManager.class)
public class TC_003_LoginValidation extends BaseClass{
	
	
	
	@Test
	
	public void verifyLogin()
	{
		
		//HomePage
		logger.info("***Starting TC_003_Login TestCase***");
		
		try {
			logger.info("Home page is Launched!");
		HomePage hp = new HomePage(driver);
		logger.info("Clicked on Login Button!");
		hp.clickLogin();
		
		// Loginpage
		LoginPage lp = new LoginPage(driver);
		logger.info("Entered Email!");
		lp.setUsername(p.getProperty("email"));
		logger.info("Enter password!");
		lp.setPassword(p.getProperty("password"));
		 // Ensure the element is in view
		logger.info("Scrolled To click on LoginButton!");
        lp.scrollToLoginBtn();

        // Try regular click
        try {
        	logger.info("clicked on LoginButton!");
            lp.clickLoginBtn();
        } catch (Exception e) {
           // System.out.println("Click failed, trying with JS: " + e.getMessage());
            // Use JavaScript click if normal click fails
            lp.clickLoginBtnWithJS();
        }
		
		//Profile
        logger.info("Profile Title is Visible !");
		ProfilePage pp = new ProfilePage(driver);
		implicitWait();
		logger.info("****clicked on Logo Link****");
		pp.clickLogo();
		implicitWait();
		
		boolean myTargetpage= pp.isMyProfileexists();
		logger.info("***clicked Logout***");
		pp.clickLogout();
		
		//Assert.assertEquals(myTargetpage, true);
		
		Assert.assertTrue(myTargetpage);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Login test failed due to exception: " + e.getMessage());
        }

        logger.info("===>Finished TC_003_Login TestCase<===");
    }

	
	}

