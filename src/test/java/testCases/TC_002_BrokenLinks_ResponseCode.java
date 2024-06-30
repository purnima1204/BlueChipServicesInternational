package testCases;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC_002_BrokenLinks_ResponseCode extends BaseClass {
	
	@Test(priority=0)
    public void testBrokenLinks() throws IOException {
        // Log the start of the test
        logger.info("Starting test for broken links and response codes");

        // Call the method to check broken links
        Map<String, Integer> linkStatusMap = checkBrokenLinks();

        // Assert no broken links
        for (Map.Entry<String, Integer> entry : linkStatusMap.entrySet()) {
            String url = entry.getKey();
            int responseCode = entry.getValue();
            Assert.assertTrue(responseCode < 400, url + " is a broken link with response code: " + responseCode);
        }
        
        
        // Log the end of the test
        logger.info("Finished test for broken links and response codes");
    }
	
	
	@Test(priority=1)
	
	public void displayLinks() 
	{
		displayLinks() ;
		logger.info("Links are displayed!");
	}	
	
}
	


