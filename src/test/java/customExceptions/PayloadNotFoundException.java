package customExceptions;

public class PayloadNotFoundException extends RuntimeException
{
    public PayloadNotFoundException(String key)
    {
        super("No payload found in requestPayload.json for key: " + key);
    }
}
