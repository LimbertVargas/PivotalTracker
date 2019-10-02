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

package pivotaltracker.entities;

/**
 * Context class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class Context {

    private Account account;
    private Workspace workspace;

    /**
     * Context for creation of the constructor.
     */
    public Context() {
        this.account = new Account();
    }

    /**
     * Returns the account of context.
     *
     * @return account.
     */
    public Account getAccount() {
        return account;
    }

    public Workspace getWorkspace() {
        return workspace;
    }
}
