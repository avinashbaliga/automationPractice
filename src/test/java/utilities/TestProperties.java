package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private static Properties properties = null;

    public static String getProperty(String key) {
        if (properties == null) {
            try {
                properties = new Properties();
                FileInputStream fileInputStream = new FileInputStream(new File("src/main/resources/testconfig.properties"));
                properties.load(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (properties.containsKey(key))
            return properties.getProperty(key);
        else throw new RuntimeException(key + " doesn't exist in properties file");
    }
}
