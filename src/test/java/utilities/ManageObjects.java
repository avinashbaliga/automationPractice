package utilities;

import apiClasses.LibraryApp;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class ManageObjects
{

    private final WebDriver driver;

    public ManageObjects(WebDriver driver)
    {
        this.driver = driver;
    }

    private HomePage homePage = null;

    public HomePage getHomePage()
    {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }


}
