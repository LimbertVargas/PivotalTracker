/*
 * @(#) WebDriverManager.java Copyright (c) 2019 Jala Foundation .
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * WebDriverManager class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class WebDriverManager {
    private static WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private WebDriverConfig webDriverConfig;
    private static WebDriverManager instance = null;

    /**
     * Constructor of page WebDriverManager.
     */
    protected WebDriverManager() {
        webDriverConfig = WebDriverConfig.getInstance();
        initialize();
    }

    /**
     * Gets Instance of a Web Element.
     *
     * @return Instance of WebElement.
     */
    public static WebDriverManager getInstance() {
        if (instance == null || instance.webDriver == null) {
            instance = new WebDriverManager();
        }
        return instance;
    }

    /**
     * Initializes the settings for the driver.
     */
    private void initialize() {
        this.webDriver = FactoryBrowser.getWebDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage()
                .timeouts()
                .implicitlyWait(webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, webDriverConfig.getExplicitWaitTime(),
                webDriverConfig.getWaitSleepTime());
    }

    /**
     * Gets the WebDriver.
     *
     * @return WebDriver.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Gets the WebDriver Wait.
     *
     * @return WebDriverWait.
     */
    public WebDriverWait getWait() {
        return webDriverWait;
    }
}
