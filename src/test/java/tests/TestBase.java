package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import pages.HomePage;

import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;


    HomePage homePage = new HomePage();

    String buyPageUrl = ConfigReader.getProperty("buyPageUrl");
    String zip = "10006";
    String minPrice = "700000";
    String maxPrice = "1000000";

    protected static ExtentReports reporter;
    protected static ExtentSparkReporter htmlReporter;
    protected static ExtentTest logger;

    @BeforeSuite  (alwaysRun = true)
    public void setupReport(){

        reporter = new ExtentReports();
        String path = System.getProperty("user.dir") + "/test-output/extentReports/index.html";
        htmlReporter = new ExtentSparkReporter(path);
        htmlReporter.config().setReportName("ZILLOW AUTOMATION TEST");

        reporter.attachReporter(htmlReporter);

        // Configuration settings
        reporter.setSystemInfo("Tester", "Rafael Azizov");
        reporter.setSystemInfo("Environment", "ZILLOW APPLICATION");
        reporter.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
    }

    @BeforeMethod (alwaysRun = true)
    @Parameters("browser")
    public void setupMethod(@Optional String browser, Method method){

        driver = Driver.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));

        logger = reporter.createTest("TEST CASE: " + method.getName());


    }


    @AfterMethod  (alwaysRun = true)
    public void tearDownMethod(ITestResult result) {

        if(result.getStatus()==ITestResult.SUCCESS){
            logger.pass("Test " + result.getName() + " Passed");
        } else if(result.getStatus()==ITestResult.SKIP){
            logger.skip("Test " + result.getName() + " Skipped");
        } else if(result.getStatus()==ITestResult.FAILURE){
            logger.fail("Test " + result.getName() + " Failed");
            logger.fail("Exception: " + result.getThrowable());

            String path = SeleniumUtils.getScreenshot("failureScreenshot");
            logger.addScreenCaptureFromPath(path);
        }

        //Driver.quitDriver();
    }

    @AfterSuite  (alwaysRun = true)
    public void tearDownReport(){
        reporter.flush();
    }

}
