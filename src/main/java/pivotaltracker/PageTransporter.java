/*
 * @(#) PageTransporter.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker;

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
     * Navigates to a page sending the url with Id.
     *
     * @param keyUrl    type of page.
     * @param id        of object.
     * @param permalink type of page that belongs to an object.
     */
    public static void navigatePageById(final String keyUrl, final int id, final String permalink) {
        String baseUrl = ConfigFileReader.getInstance().getProperties().get("baseUrl");
        goToURL(baseUrl.concat(keyUrl).concat("/").concat(String.valueOf(id)).concat(permalink));
    }

    /**
     * Navigates on page with id.
     *
     * @param keyUrl - Url key.
     * @param id     - Project id.
     */
    public static void navigatePageThroughId(final String keyUrl, final int id) {
        String baseUrl = ConfigFileReader.getInstance().getProperties().get("baseUrl");
        goToURL(baseUrl.concat(keyUrl).concat("/").concat(String.valueOf(id)));
    }

    /**
     * Constructor for class.
     */
    private PageTransporter() {
    }
}
