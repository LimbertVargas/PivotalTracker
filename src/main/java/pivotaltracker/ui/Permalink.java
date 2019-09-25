/*
 * @(#) Permalink.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.ui;

import java.util.HashMap;
import java.util.Map;

/**
 * Permalink class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public final class Permalink {
    public static final String LOGIN_PAGE = "/signin";
    public static final String DASHBOARD_PAGE = "/dashboard";

    private static Map<String, String> course = new HashMap<>();
    static {
        course.put("Login", LOGIN_PAGE);
        course.put("Dashboard", DASHBOARD_PAGE);
    }

    /**
     * Gets of course map.
     *
     * @param urlKey of type string.
     * @return value of map.
     */
    public static String getPermalink(final String urlKey) {
        return course.get(urlKey);
    }

    /**
     * Constructor private.
     */
    private Permalink() { }
}
