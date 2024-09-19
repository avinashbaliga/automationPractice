package utilities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import customExceptions.PayloadNotFoundException;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class RestUtilities
{

    private RequestSpecification requestSpecification;
    private JsonParser jsonParser;
    private JsonObject data;

    public RestUtilities()
    {
        requestSpecification = RestAssured.given();
        try
        {
            jsonParser = new JsonParser();
            data = (JsonObject) jsonParser.parse(new FileReader("src/main/resources/requestPayload.json"));
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * For any not applicable argument/parameter, send null
     */
    public Response request(String baseUri, String endpoint, Method crudMethod, Map<String, ?> header, Map<String, ?> pathParam, Map<String, ?> queryParam, Object payload)
    {
        if (header != null)
            requestSpecification.headers(header);
        if (pathParam != null)
            requestSpecification.pathParams(pathParam);
        if (queryParam != null)
            requestSpecification.queryParams(queryParam);
        if (payload != null)
            requestSpecification.body(payload);
        requestSpecification.baseUri(baseUri);
        requestSpecification.basePath(endpoint);

        requestSpecification.log().all();

        return requestSpecification.request(crudMethod);
    }

    public Object getPayload(String key)
    {
        if (data.has(key))
            return data.get(key);
        else throw new PayloadNotFoundException(key);
    }
}
