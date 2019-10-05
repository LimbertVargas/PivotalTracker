/*
 * @(#) LoginSteps.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package steps;

import pivotaltracker.PageTransporter;
import pivotaltracker.entities.Context;
import pivotaltracker.entities.User;
import pivotaltracker.ui.Permalink;
import pivotaltracker.ui.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * LoginSteps class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class LoginSteps {
    private LoginPage loginPage;
    private User user;
    private Context context;
<<<<<<< HEAD
    /**
     * Constructor of account steps sending the context.
     *
     * @param context init the context.
     */
    public LoginSteps(final Context context) {
        this.context = context;
        this.user = context.getUser();
=======

    /**
     * Constructor class.
     */
    private LoginSteps(Context context) {
        this.context = context;
        user = context.getUser();
>>>>>>> develop
    }

    /**
     * This method opens the page.
     *
     * @param page for navigate.
     */
<<<<<<< HEAD
    @Given("^I go to the (.*) Page$")
=======
    @Given("I go to the (.*) Page")
>>>>>>> develop
    public void goThePagesOfPivotalTracker(final String page) {
        PageTransporter.navigatePage(Permalink.getPermalink(page));
    }

    /**
     * This method fills in the user data to be able to log in.
     *
     * @param userName is string
     */
<<<<<<< HEAD
    @When("^I fill the field with credentials from user \"(.*)\"$")
    public void fillTheFieldWithCredentialsFromUser(final String userName) {
=======
    @When("^I fill the field with credentials from user \"([^\"]*)\"$")
    public void fillTheFieldWithCredentialsFromUser(String userName) {
        user.setUserName(userName);
>>>>>>> develop
        loginPage = new LoginPage();
        loginPage.login(userName);
        user.setUserName(userName);
    }

}
