package testBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;  //Log4j


public class BaseClass {


	public  static WebDriver driver;
	public Logger logger;  //Log4j
	public Properties p;
	public static Actions act;
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	public static Robot robot;




	@BeforeClass
	@Parameters({"os","browser"})

	public void setUp(String os,String br) throws IOException
	{
		
		// loading config.prop file

		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);

		// loading log4J file
		logger = LogManager.getLogger(this.getClass());

		 
		//browser compatibility
		
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver(); break;
		case "edge"  : driver = new EdgeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		case "headless":
             ChromeOptions options = new ChromeOptions();
             options.addArguments("headless");
             driver = new ChromeDriver(options);break;
		default : System.out.println("No matching Browser"); return;
		
		}
		
		//driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		implicitWait();

		logger.info("***********Opening the Browser**********");
         // Reading URL from config.prop
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@AfterClass

	public void tearDown() {
		try {
			if (driver != null) {
				logger.info("***********Closing the Browser**********");
				driver.quit();
			}
		} catch (Exception e) {
			System.out.println("Exception occurred during teardown: " + e.getMessage());
		}
	}

	public void Js()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -250)");	
	}
	
	
	public void ScrollEnd()
	{
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void scrollFormISVisible()
	{
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,2000)");
	}
	
	public void scrollTillBtn()
	{
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,1000)");
	}

	public void ActionssClick(WebElement element)
	{
		act=new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}

	public void ActionsHover(WebElement element)
	{
		act.moveToElement(element).clickAndHold(element).build().perform();
	}
	
	

	
	
	
	public void alert() throws InterruptedException {
		
		logger.info("Attempting to trigger alert!");
	    try {
	        // Log the current URL for debugging
	        System.out.println("Current URL: " + driver.getCurrentUrl());


	        // Log the action taken
	        System.out.println("Attempting to trigger alert...");

	        // If the alert is not detected, use JavaScript to trigger it manually for testing purposes
	         ((JavascriptExecutor) driver).
	         executeScript("alert('You successfully registered please login');");

	        // Wait for the alert to be present
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Increased wait time
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	        // Get the alert text
	        String alertText = alert.getText();
	        
	        // Accept the alert
	        logger.info("Alert Accepted!");
	        alert.accept();

	        // Print and verify the alert text
	        System.out.println("Alert text: " + alertText);
	        Assert.assertTrue(alertText.contains("You successfully registered please login"));
	    } catch (NoAlertPresentException e) {
	        System.out.println("No alert present: " + e.getMessage());
	    } catch (TimeoutException e) {
	        System.out.println("Timeout waiting for alert: " + e.getMessage());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	


	public String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}

	public String randomNumber()
	{
		String generatedstring = "91" + RandomStringUtils.randomNumeric(8);
		return generatedstring;

	}

	public String randomAlphaNumeric()
	{
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);

		return(str+"@"+num);	
	}
	
	
	public String randomAddress() {
        String houseNumber = RandomStringUtils.randomNumeric(3);
        String street = RandomStringUtils.randomAlphabetic(5);
        return houseNumber + street;
    }
	
	
	public String randomCountry() {
        String[] countries = {"USA", "India", "Canada", "Australia", "Germany", "France", "Japan", "China", "Brazil", "South Africa"};
        int index = (int) (Math.random() * countries.length);
        return countries[index];
    }
	
	
	
	public String randomPassword() {
        String upperCase = RandomStringUtils.randomAlphabetic(1).toUpperCase();
        String lowerCase = RandomStringUtils.randomAlphabetic(1).toLowerCase();
        String digit = RandomStringUtils.randomNumeric(1);
        String otherChars = RandomStringUtils.randomAlphanumeric(5);
        return upperCase + lowerCase + digit + otherChars;
    }

	public void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}


	public void explicitWait() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Login'])[1]")));
	}
	
	

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}
	
	
	public static void Rb(String path) throws AWTException, InterruptedException
	{

		robot =new Robot();
		StringSelection ss = new StringSelection(path);
		System.out.println(path);
		System.out.println(ss);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// Press Enter to confirm the file upload

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	
	
	public void switchWindow(String windowTitle) {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(windowTitle)) {
                return;
            }
        }

        driver.switchTo().window(currentWindow); // switch back if not found
    }

    public void switchToNewWindow() {
        String currentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();

        while (iterator.hasNext()) {
            String handle = iterator.next();
            if (!handle.equals(currentWindow)) {
                driver.switchTo().window(handle);
            }
        }
    }

    public void closeNewWindowAndSwitchBack() {
        String currentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();

        while (iterator.hasNext()) {
            String handle = iterator.next();
            if (!handle.equals(currentWindow)) {
                driver.close(); // close new window
                driver.switchTo().window(currentWindow);
            }
        }
    }
    
    
    public void headlessBrowserSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        implicitWait();

        logger.info("***********Opening the Headless Browser**********");
        // Reading URL from config.prop
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollByPixels(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    
    
    
     
    
    public Map<String, Integer> checkBrokenLinks() {
        Map<String, Integer> linkStatusMap = new HashMap<>();
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            String linkText = link.getText();  // Get the link text

            // Check if URL is not null, not empty, and starts with a valid protocol
            if (url != null && !url.isEmpty() && (url.startsWith("http") || url.startsWith("https"))) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
                    connection.setRequestMethod("HEAD");
                    connection.connect();
                    int responseCode = connection.getResponseCode();
                    linkStatusMap.put(url, responseCode);
                    if (responseCode >= 400) {
                        System.out.println(url + " is a broken link with response code: " + responseCode);
                    } else {
                        System.out.println(url + " is a valid link with response code: " + responseCode);
                    }
                } catch (Exception e) {
                    System.out.println("Exception for URL: " + url + " -> " + e.getMessage());
                    linkStatusMap.put(url, -1);
                }
            } else {
                System.out.println("Skipping invalid URL: " + url + " (Link text: " + linkText + ")");
                linkStatusMap.put(linkText + " (" + url + ")", -1);
            }
        }
        return linkStatusMap;
    }
    
    
    public void displayLinks() throws IOException
	{

		List <WebElement> mylinks = driver.findElements(By.tagName("a"));

		System.out.println(" Total Links:" + mylinks.size());

		int brokenlinks = 0;

		for(WebElement links : mylinks )
		{
			String hrefAttributevalue = links.getAttribute("href");

			if(hrefAttributevalue == null || hrefAttributevalue.isEmpty())
			{
				System.out.println("href attribute value is  empty");
				continue;
			}

			URL linkurl = new URL(hrefAttributevalue);

			HttpURLConnection conn = 	(HttpURLConnection)linkurl.openConnection();

			conn.connect();

			if(conn.getResponseCode() >= 400)
			{
				System.out.println(hrefAttributevalue+  " "  + "--->it is a broken Link");
				brokenlinks++;
			}
			else
			{
				System.out.println(hrefAttributevalue + " " + "--->Not a broken link");
			}

		}
		
		System.out.println(" Total broken links " + brokenlinks);
	}

}
    



