package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends TestBase{


    @Test
    public void appHealthCheck() {

        logger.info("Navigating to the main page and checking main page URL");
        Assert.assertEquals("https://www.zillow.com/", driver.getCurrentUrl());
    }

    @Test
    public void ClickingBuyButtonAndPageVerification(){

    logger.info("Clicking on BUY button");
    homePage.buyButton.click();
    logger.info("Verifying if the User passed to the expected page");
    Assert.assertEquals(driver.getCurrentUrl(), buyPageUrl, "The BUY page expected url is wrong");
    }
}
