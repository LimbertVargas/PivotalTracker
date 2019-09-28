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
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * PivotalTrackerUtils class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public final class PivotalTrackerUtils {

    protected WebDriverWait webDriverWait;
    protected WebDriver webDriver;
    /**
     * Constructor class.
     */
    private PivotalTrackerUtils() {
    }

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
     * This method work for see displayed webElement.
     *
     * @param elementBy web element.
     * @return true or false
     */
    private boolean isElementPresent(final By elementBy) {
        webDriverWait = new WebDriverWait(webDriver, 1);
        boolean isDisplayed;
        try {
            webDriver.findElement(elementBy);
            isDisplayed = true;
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        } finally {
            webDriverWait = WebDriverManager.getInstance().getWait();
        }
        return isDisplayed;
    }
}
