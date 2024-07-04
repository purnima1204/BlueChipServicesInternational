package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;
import testBase.BaseClass;
import utilities.DataProviders;
@Listeners(utilities.ExtentReportManager.class)
public class TC_004_LoginDDT extends BaseClass{



	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	// dataProviderClass is requited when dataProvider is in another class

	public void validateLoginDDT(String email,String pwd,String res)
	{

		//HomePage
		logger.info("***Starting TC_004_Login DDT***");

		try
		{

			logger.info("Home page is Launched!");
			HomePage hp = new HomePage(driver);
			logger.info("Clicked on Login Button!");
			hp.clickLogin();

			// Loginpage
			LoginPage lp = new LoginPage(driver);
			
			logger.info("Entered Email from Excel!");
			lp.setUsername(email);
			logger.info("Enter password from Excel!");
			lp.setPassword(pwd);
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

			if(res.equalsIgnoreCase("ValidData")) // valid data 
			{

				if(myTargetpage == true)
				{
					pp.clickLogout();
					Assert.assertTrue(true); // Data valid --> myTargetpage True --> Test pass
				}
				else
				{
					Assert.assertTrue(false); // Data Invalid --> login fail --> Test fail
				}

			}
			if(res.equalsIgnoreCase("InvalidData"))
			{
				if(myTargetpage == true)
				{
					pp.clickLogout();
					Assert.assertTrue(false); // Data valid --> myTargetpage True --> Test pass
				}
				else
				{
					pp.clickLogout();
					Assert.assertTrue(false);
				}
			}
		}catch (Exception e) {
            if (res.equalsIgnoreCase("ValidData")) {
                Assert.fail("Test failed due to exception: " + e.getMessage());
            } else {
                Assert.assertTrue(true, "Expected failure for invalid data: " + e.getMessage());
            }
        }
        logger.info("===>Finished TC_004_Login DataDriven TestCase <===");
    }
	
	
}


