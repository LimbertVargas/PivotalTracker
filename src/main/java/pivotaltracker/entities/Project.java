/*
 * @(#) Project.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.entities;

/**
 * Project class.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class Project {
    private int id;

    /**
     * Returns the project ID.
     *
     * @return user.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the project ID.
     *
     * @param id - Project identifier.
     */
    public void setId(final int id) {
        this.id = id;
    }
}
