package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.ManageObjects;

public class HomePageTest extends BaseTest {

    private ManageObjects manageObjects;
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = getWebDriver();
        manageObjects = new ManageObjects(driver);
    }

    @Test
    public void launchHomePage() {
        log("Launching home page");
        manageObjects.getHomePage().launchHomePage();
        log("Home page launched successfully");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
