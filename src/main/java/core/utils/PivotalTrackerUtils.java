/*
 * @(#) PivotalTrackerUtils.java Copyright (c) 2019 Jala Foundation.
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

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * PivotalTrackerUtils class
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class PivotalTrackerUtils {
    private static WebDriver driver = WebDriverManager.getInstance().getWebDriver();

    /**
     * This method works for fill data.
     *
     * @param element - WebElement of the text field.
     * @param text    - String for the text field.
     */
    public static void setText(final WebElement element, final String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * This method get the result for assert.
     *
     * @param element - Locator type.
     * @return value - Text of the locator.
     */
    public static String getMessage(final WebElement element) {
        String message = element.getText();
        return message;
    }

    /**
     * This method close the browser after of the test.
     */
    public void close() {
        driver.close();
    }

    /**
     * This method quit the browser after of the test.
     */
    public void quit() {
        driver.quit();
    }
}