/*
 * @(#) PageTransporter.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

<<<<<<< HEAD:src/main/java/PivotalTracker/PageTransporter.java
package PivotalTracker;
=======
package pivotaltracker;
>>>>>>> develop:src/main/java/PivotalTracker/ui/PageTransporter.java

import core.selenium.WebDriverManager;

import core.utils.ConfigFileReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * PageTransporter class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public final class PageTransporter {
    /**
     * Navigates to a page sending the url.
     *
     * @param url for navigate.
     */
    private static void goToURL(final String url) {
        try {
            WebDriverManager.getInstance().getWebDriver().navigate().to(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navigates to a page sending the url.
     *
     * @param keyUrl for navigate.
     */
    public static void navigatePage(final String keyUrl) {
        String baseUrl = ConfigFileReader.getInstance().getProperties().get("baseUrl");
        goToURL(baseUrl.concat(keyUrl));
    }

    /**
     * Constructor for class.
     */
    private PageTransporter() { }
}
