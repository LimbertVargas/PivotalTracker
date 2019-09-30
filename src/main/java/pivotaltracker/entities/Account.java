/*
 * @(#) Account.java Copyright (c) 2019 Jala Foundation.
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
 * Account class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class Account {
    private int id;
    private String nameAccount;
    private String roleMember;
    private String nameMember;
    private boolean isProjectCreator;

    /**
     * Gets the id of the account.
     *
     * @return id as string.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id of account.
     *
     * @param id for the account.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Gets the name of the account.
     *
     * @return nameAccount as string.
     */
    public String getNameAccount() {
        return nameAccount;
    }

    /**
     * Sets name of account.
     *
     * @param nameAccount for the account.
     */
    public void setNameAccount(final String nameAccount) {
        this.nameAccount = nameAccount;
    }

    /**
     * Gets the role of the member.
     *
     * @return roleMember as string.
     */
    public String getRoleMember() {
        return roleMember;
    }

    /**
     * Sets roleMember of account.
     *
     * @param roleMember for the account.
     */
    public void setRoleMember(final String roleMember) {
        this.roleMember = roleMember;
    }

    /**
     * Gets the name of the member.
     *
     * @return nameMember as string.
     */
    public String getNameMember() {
        return nameMember;
    }

    /**
     * Sets nameMember of account.
     *
     * @param nameMember for the account.
     */
    public void setNameMember(final String nameMember) {
        this.nameMember = nameMember;
    }

    /**
     * Gets the project creator of the account.
     *
     * @return nameMember as true.
     */
    public boolean isProjectCreator() {
        return isProjectCreator;
    }

    /**
     * Sets projectCreator of account.
     *
     * @param projectCreator for the account.
     */
    public void setProjectCreator(boolean projectCreator) {
        isProjectCreator = projectCreator;
    }
}
