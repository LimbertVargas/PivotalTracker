/*
 * @(#) DriverMethods.java Copyright (c) 2019 Jala Foundation.
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
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * DriverMethods class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public final class DriverMethods {

    private static WebDriverWait webDriverWait = WebDriverManager.getInstance().getWait();
    private static WebDriver webDriver;

    /**
     * Constructor class.
     */
    private DriverMethods() {
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
    public static boolean isElementPresent(final By elementBy) {
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

    /**
     * Get array text from WebElements.
     *
     * @return list of text
     */
    public static String[] getElementsText(final List<WebElement> listWebelements) {
        String[] title = new String[listWebelements.size()];
        for (int i = 0; i < listWebelements.size(); i++) {
            title[i] = listWebelements.get(i).getText();
        }
        return title;
    }

    /**
     * Double click for open story.
     */
    public static void dualClick(final WebElement element,final WebDriver webDriver) {
        Actions actions = new Actions(webDriver);
        actions.doubleClick(element).perform();
    }
}
