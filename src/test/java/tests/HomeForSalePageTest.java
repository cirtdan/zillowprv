package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomesForSalePage;

public class HomeForSalePageTest extends TestBase{

    HomesForSalePage homesForSalePage = new HomesForSalePage();

    @BeforeMethod (alwaysRun = true)
    public void pageSetup(){
        HomePageTest homePageTest = new HomePageTest();
        homePageTest.ClickingBuyButtonAndPageVerification();
    }

    @Test
    public void filtering(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();", homesForSalePage.locationField);

        js.executeScript("document.getElementById('srp-search-box').value=zip;");

//        homesForSalePage.locationField.clear();
//        homesForSalePage.locationField.sendKeys(zip);
//        homesForSalePage.priceButton.click();
//        homesForSalePage.priceMinField.sendKeys(minPrice);
//        homesForSalePage.priceMaxField.sendKeys(maxPrice, Keys.ENTER);

    }
}
