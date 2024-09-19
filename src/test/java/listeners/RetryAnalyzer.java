package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utilities.TestProperties;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < Integer.parseInt(TestProperties.getProperty("retryCount"))) {
            retryCount++;
            return true;
        }
        else {
            retryCount = 0;
            return false;
        }
    }
}
