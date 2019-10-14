/*
 * @(#) Workspace.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.entities;

/**
 * Workspace class.
 *
 * @author Limbert Vargas
 * @version 1.0
 */
public class Workspace {
    private String nameWorkspace;

    /**
     * Gets the name of the Workspace.
     *
     * @return workspace name.
     */
    public String getNameWorkspace() {
        return nameWorkspace;
    }

    /**
     * Sets the name of the Workspace.
     *
     * @param nameWorkspace for the workspace.
     */
    public void setNameWorkspace(final String nameWorkspace) {
        this.nameWorkspace = nameWorkspace;
    }
}
