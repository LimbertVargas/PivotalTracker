/*
 * @(#) Invitation.java Copyright (c) 2019 Jala Foundation.
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

import java.util.Map;

/**
 * Invitation class.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class Invitation {
    private static final String VIEWER = "Viewer";
    private static final String MEMBER = "Member";
    private static final String OWNER = "Owner";
    private Map<String, String> invites;

    /**
     * Gets the map <member, role>.
     *
     * @return invites as map.
     */
    public Map<String, String> getInvites() {
        return invites;
    }

    /**
     * Sets invites map.
     *
     * @param invites for the account.
     */
    public void setInvites(Map<String, String> invites) {
        this.invites = invites;
    }
}
