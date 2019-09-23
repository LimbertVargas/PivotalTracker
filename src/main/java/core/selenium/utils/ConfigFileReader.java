/*
 * @(#) ConfigFileReader.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package core.selenium.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigFileReader class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath = "PivotalTracker.properties";

    /**
     * Creates a new property that read the datas from an external file.
     */
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

    /**
     * Gets number for chrome implicit wait from external file.
     *
     * @return implicitWaitChrome - Number for chrome implicit wait.
     */
    public String getImplicitWaitChrome() {
        String implicitWaitChrome = properties.getProperty("implicitWaitChrome");
        if (implicitWaitChrome != null) {
            return implicitWaitChrome;
        } else throw new RuntimeException("implicitWaitChrome not specified in the Configuration.properties file.");
    }

    /**
     * Gets number for chrome explicit wait from external file.
     *
     * @return explicitWaitFirefox - Number for chrome explicit wait.
     */
    public String getExplicitWaitChrome() {
        String explicitWaitChrome = properties.getProperty("explicitWaitChrome");
        if (explicitWaitChrome != null) {
            return explicitWaitChrome;
        } else throw new RuntimeException("explicitWaitChrome not specified in the Configuration.properties file.");
    }

    /**
     * Gets number for firefox explicit wait from external file.
     *
     * @return explicitWaitFirefox - Number for firefox explicit wait.
     */
    public String getExplicitWaitFirefox() {
        String explicitWaitFirefox = properties.getProperty("explicitWaitFirefox");
        if (explicitWaitFirefox != null) {
            return explicitWaitFirefox;
        } else throw new RuntimeException("explicitWaitFirefox not specified in the Configuration.properties file.");
    }

    /**
     * Gets number for firefox implicit wait from external file.
     *
     * @return implicitWaitFirefox - Number for firefox implicit wait.
     */
    public long getImplicitWaitFirefox() {
        String implicitWaitFirefox = properties.getProperty("implicitWaitFirefox");
        if (implicitWaitFirefox != null) {
            return Long.parseLong(implicitWaitFirefox);
        } else throw new RuntimeException("implicitWaitFirefox not specified in the Configuration.properties file.");
    }

    /**
     * Gets url Pivotal Tracker home page.
     *
     * @return url - Url home page.
     */
    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) {
            return url;
        } else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
}
