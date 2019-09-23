/*
 * @(#) Dashboard.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package PivotalTracker.entities;

/**
 * Dashboard class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class Dashboard {
    private String user;

    /**
     * This method get user name that user fill.
     *
     * @return user
     */
    public String getUserName() {
        return user;
    }

    /**
     * This method set user name.
     *
     * @param user - User name
     */
    public void setUserName(final String user) {
        this.user = user;
    }
}
