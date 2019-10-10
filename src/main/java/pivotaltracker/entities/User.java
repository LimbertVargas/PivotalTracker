/*
 * @(#) User.java Copyright (c) 2019 Jala Foundation.
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
 * User class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class User {
    private String user;
    private String password;
    private String email;

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

    /**
     * This method get user password that user fill.
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method set user password.
     *
     * @param password - password user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method get user email that user fill.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method set user email.
     *
     * @param email user
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
