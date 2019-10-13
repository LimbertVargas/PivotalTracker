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
    private User user;
    private CSVFile csvFile;
    private Story story;

    /**
     * Context for creation of the constructor.
     */
    public Context() {
        this.account = new Account();
        this.user = new User();
        this.csvFile = new CSVFile();
        this.story = new Story();
    }

    /**
     * Returns the account of context.
     *
     * @return account.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Returns the user of context.
     *
     * @return user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter method.
     *
     * @param user A User instance to be shared across step definitions.
     */
    public void setUser(final User user) {
        this.user = user;
    }

    /**
     * Setter method.
     *
     * @param account A User instance to be shared across step definitions.
     */
    public void setAccount(final Account account) {
        this.account = account;
    }

    /**
     * Gets csv file.
     *
     * @return csvFile
     */
    public CSVFile getCsvFile() {
        return csvFile;
    }

    /**
     * Gets story context.
     *
     * @return story
     */
    public Story getStory() {
        return story;
    }
}
