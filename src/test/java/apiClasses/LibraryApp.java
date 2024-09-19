package apiClasses;

import io.restassured.http.Method;
import io.restassured.response.Response;
import org.testng.Assert;
import utilities.RestUtilities;
import utilities.TestProperties;

public class LibraryApp extends RestUtilities
{

    private String baseUri;
    private Response response;

    public LibraryApp()
    {
        baseUri = TestProperties.getProperty("apiBaseUri");
    }

    public Response getListOfBooks()
    {
        response = request(baseUri, "/books", Method.GET, null, null, null, null);
        Assert.assertEquals(response.statusCode(), 200);

        return response;
    }
}
