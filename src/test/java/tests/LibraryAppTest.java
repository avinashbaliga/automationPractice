package tests;

import baseClasses.ApiBaseTest;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ManageApiObjects;

public class LibraryAppTest extends ApiBaseTest
{

    private ManageApiObjects manageApiObjects = null;

    @BeforeClass
    public void beforeClass()
    {
        manageApiObjects = new ManageApiObjects();
    }

    @Test
    public void getListOfBooks()
    {
        log("Get list of books by hitting library api");
        Response response = manageApiObjects.getLibraryApp().getListOfBooks();
        log(response.asPrettyString());
        log(response.getBody().asString());
    }
}
