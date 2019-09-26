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

package core.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * ConfigFileReader class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public final class ConfigFileReader {

    private static final String PIVOTAL_TRACKER_PROPERTIES = "pivotaltracker.properties";
    private Map<String, String> properties;

    /**
     * Initializes a new reader with the properties for driver.
     */
    private ConfigFileReader() {
        properties = new HashMap<>();
        addPropertiesDriver();
    }

    /**
     * Gets the properties of map.
     *
     * @return driver properties.
     */
    public Map<String, String> getProperties() {
        return properties;
    }

    /**
     * Adds the properties from driver.properties file to the map.
     */
    public void addPropertiesDriver() {
        Properties propertiesGradle = loadFile(PIVOTAL_TRACKER_PROPERTIES);
        propertiesGradle.forEach((key, value) -> properties.put(key.toString(), value.toString()));
    }

    /**
     * Initializes a new reader for the properties.
     *
     * @return a ReaderDriverProperties.
     */
    public static ConfigFileReader getInstance() {
        return new ConfigFileReader();
    }

    /**
     * Loads a property file.
     *
     * @param url - Url of properties.
     * @return properties - Loaded properties
     */
    private Properties loadFile(final String url) {
        Properties properties = new Properties();
        try {
            InputStream input = new FileInputStream(url);
            properties.load(input);
        } catch (IOException e) {
            Log.getInstance().getLog().error(e.getMessage());
        }
        return properties;
    }

    /**
     * Returns the token from the properties file.
     *
     * @return the token as string.
     */
    public String getAccessToken() {
        return getProperties().get("accessToken");
    }

    /**
     * Returns the url to request to the Base URL from the properties file.
     *
     * @return the url as string.
     */
    public String getBaseUrl() {
        return getProperties().get("baseUrl");
    }

    /**
     * Returns the url to request to the API Url from the properties file.
     *
     * @return the url as string.
     */
    public String getApiUrl() {
        return getProperties().get("apiUrl");
    }

    /**
     * Returns the content type from the properties file.
     *
     * @return the content type as string.
     */
    public String getContentType() {
        return getProperties().get("contentType=application/json");
    }
}
