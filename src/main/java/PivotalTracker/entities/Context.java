/*
 * @(#) Context.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package trabajopolis.entities;

import PivotalTracker.entities.Dashboard;

/**
 * Context class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class Context {
    private Dashboard dashboard;

    /**
     * Constructs all elements in the context.
     */
    public Context() {
        this.dashboard = new Dashboard();
    }

    /**
     * Allows to get context's search.
     *
     * @return - search.
     */
    public Dashboard getDashboard() {
        return dashboard;
    }
}
