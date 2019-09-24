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

import org.openqa.selenium.WebElement;

/**
 * PivotalTrackerUtils class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public final class PivotalTrackerUtils {

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
}
