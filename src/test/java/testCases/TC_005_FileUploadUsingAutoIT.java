package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;
import pageObjects.StudentDashBoard;
import testBase.BaseClass;

public class TC_005_FileUploadUsingAutoIT extends BaseClass {
	
		
		@Test
		
		public void verifyFileUploadUsingAUTOIT() throws IOException, InterruptedException
		{
			
			//HomePage
			logger.info("***Starting TC_005_Login TestCase***");
			
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
			logger.info("****clicked on Profile Logo****");
			pp.clickProfile();	
			implicitWait();
			
			// click Toggle sidebar
			logger.info("****clicked on ProfileSideBar****");
			StudentDashBoard sdb = new StudentDashBoard(driver);
			
			sdb.clickProfile();
			logger.info("****clicked on EditProfileLink****");
			sdb.clickEditProfileLink();
			
			// Scroll to the "Passport Details" input field
	        WebElement passportDetailsLabel = driver.findElement(By.xpath("//label[@for='HSC']"));
	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        logger.info("****clicked on Passport InputField****");
	        Select PassportSelect = new Select(driver.findElement(By.xpath("//select[@id='havePassport']")));
	        logger.info("****Selected As YES ****");
	        PassportSelect.selectByVisibleText("Yes");
	       
	       //Explicit wait is added
	        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
	        WebElement chooseFileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section/div/div[2]/div/div/div/div[2]/form/div[16]/div/div[1]/input[1]")));
 
	       
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", chooseFileButton);

	        
	        logger.info("***opened downloads folder ***");
	        // Click the "Choose File" button 
	        jsExecutor.executeScript("arguments[0].click();", chooseFileButton);
	        

	        logger.info("***File Uploaded! ***");
	        
	       // Runtime.getRuntime().exec("C:\\Users\\MS\\Downloads\\fileupload.exe.exe");
	        
	        logger.info("***File Uploaded Using properties Path! ***");
	        
	        Runtime.getRuntime().exec(p.getProperty("FilePathToUpload"));
		      
			Thread.sleep(5000);
			
			  logger.info("**Clicked SaveChanges! ***");
			
			sdb.clickSaveChangesBtn();
		}
		
		
}


