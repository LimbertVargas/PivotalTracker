/*
 * @(#) WebDriverConfig.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package core.selenium;

import core.utils.ConfigFileReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * WebDriverConfig class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class WebDriverConfig {
    private String browser;
    private int implicitWaitTime;
    private int explicitWaitTime;
    private int waitSleepTime;
    private static final String BROWSER = "browser";
    private Properties prop = new Properties();
    private InputStream input = null;
    private static WebDriverConfig instance;

    /**
     * Constructor WebDriverConfig.
     */
    protected WebDriverConfig() {
        initialize();
    }

    /**
     * Constructor of WebDriverConfig.
     * Gets WebDriverConfig as Singleton.
     *
     * @return a instance.
     */
    public static WebDriverConfig getInstance() {
        if (instance == null) {
            instance = new WebDriverConfig();
        }
        return instance;
    }

    /**
     * Initializes WebDriverConfig.
     */
    public void initialize() {
<<<<<<< HEAD
        try {
            input = new FileInputStream("gradle.properties");
            prop.load(input);
        } catch (IOException event) {
            event.printStackTrace();
        }
        browser = System.getProperty(BROWSER) != null ? System.getProperty(BROWSER) : prop.getProperty(BROWSER);
=======
        browser = ConfigFileReader.getInstance().getProperties().get("browser");
>>>>>>> 055e921a294920c689277a7112ad0e1b27185b58
        implicitWaitTime = Integer.parseInt(ConfigFileReader.getInstance().getProperties().get("implicitWait"));
        explicitWaitTime = Integer.parseInt(ConfigFileReader.getInstance().getProperties().get("explicitWait"));
        waitSleepTime = Integer.parseInt(ConfigFileReader.getInstance().getProperties().get("waitSleepTime"));
    }

    /**
     * Gets the browser in which the tests are being executed.
     *
     * @return Browser.
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * Gets the implicit wait time set for the WebDriver.
     *
     * @return The implicit time.
     */
    public int getImplicitWaitTime() {
        return implicitWaitTime;
    }

    /**
     * Gets the explicit wait time set for the WebDriver.
     *
     * @return The explicit time.
     */
    public int getExplicitWaitTime() {
        return explicitWaitTime;
    }

    /**
     * Gets the sleep time wait set for the WebDriver.
     *
     * @return Sleep time wait.
     */
    public int getWaitSleepTime() {
        return waitSleepTime;
    }
}
