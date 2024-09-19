package baseClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.TestProperties;

public class BaseTest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private static ExtentReports extentReports = null;
    private static ExtentSparkReporter extentSparkReporter = null;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private String testName;

    public void log(String message) {
        logger.log(Level.INFO, message);
        extentTest.get().info(message);
    }

    @BeforeMethod
    public void beforeMethod(ITestResult iTestResult) {
        testName = iTestResult.getMethod().getMethodName();

        if (extentSparkReporter == null) {
            extentSparkReporter = new ExtentSparkReporter("src/main/resources/reports/report.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);
        }

        if (extentTest.get() == null) {
            extentTest.set(extentReports.createTest(testName));
        }
    }

    private void logTestFailed(String message) {
        logger.log(Level.ERROR, message);
        extentTest.get().fail(message);
    }

    @AfterMethod
    public void afterMethod(ITestResult iTestResult) {

        if (!iTestResult.isSuccess()) {
            logTestFailed("Test Failed");
        }
        extentReports.flush();
        extentTest.remove();
    }
}
