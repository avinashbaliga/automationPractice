package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utilities.TestProperties;

public class UiBaseTest extends BaseTest
{

    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public void initiateDriver()
    {
        WebDriver driver;

        switch (TestProperties.getProperty("browser"))
        {
            case "chrome":
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                webDriverThreadLocal.set(driver);
                break;
            default:
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                webDriverThreadLocal.set(driver);
                break;
        }

    }

    public WebDriver getWebDriver()
    {
        if (webDriverThreadLocal.get() == null)
            initiateDriver();

        return webDriverThreadLocal.get();
    }
}
