package core.selenium.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "PivotalTracker.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getImplicitWaitChrome() {
        String implicitWaitChrome = properties.getProperty("implicitWaitChrome");
        if (implicitWaitChrome != null) {
            return implicitWaitChrome;
        } else throw new RuntimeException("implicitWaitChrome not specified in the Configuration.properties file.");
    }


    public String getExplicitWaitFirefox() {
        String explicitWaitFirefox = properties.getProperty("explicitWaitFirefox");
        if (explicitWaitFirefox != null) {
            return explicitWaitFirefox;
        } else throw new RuntimeException("explicitWaitFirefox not specified in the Configuration.properties file.");
    }

    public long getImplicitWaitFirefox() {
        String implicitWaitFirefox = properties.getProperty("implicitWaitFirefox");
        if (implicitWaitFirefox != null) {
            return Long.parseLong(implicitWaitFirefox);
        } else throw new RuntimeException("implicitWaitFirefox not specified in the Configuration.properties file.");
    }

    public String getExplicitWaitChrome() {
        String explicitWaitChrome = properties.getProperty("explicitWaitChrome");
        if (explicitWaitChrome != null) {
            return explicitWaitChrome;
        } else throw new RuntimeException("explicitWaitChrome not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) {
            return url;
        } else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
}
