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

import core.utils.CredentialsReader;
import pivotaltracker.ui.PageTransporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pivotaltracker.entities.Context;
import pivotaltracker.entities.User;
import pivotaltracker.ui.Permalink;
import pivotaltracker.ui.pages.LoginPage;

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

    /**
     * Constructor of account steps sending the context.
     *
     * @param context init the context.
     */
    public LoginSteps(final Context context) {
        this.context = context;
        this.user = context.getUser();
    }

        /**
         * This method opens the page.
         *
         * @param page for navigate.
         */
    @Given("^I go to the (.*) Page$")
    public void goThePagesOfPivotalTracker(final String page) {
        PageTransporter.navigatePage(Permalink.getPermalink(page));
    }

        /**
         * This method fills in the user data to be able to log in.
         *
         * @param userName is string
         */
    @When("^I fill the field with credentials from user \"(.*)\"$")
    public void fillTheFieldWithCredentialsFromUser(final String userName) {
        loginPage = new LoginPage();
        context.setUser(CredentialsReader.getInstance().getUser(userName));
        user = context.getUser();
        loginPage.loginAuthentication(user.getUserName(), user.getPassword());
    }

    @Given("I (.*) of pivotal tracker with the crendentials from user \"(.*)\"")
    public void iLoginOfPivotalTrackerWithTheCrendentialsFromUser(final String urlKey, final String userName) {
        PageTransporter.navigatePage(Permalink.getPermalink(urlKey));
        loginPage = new LoginPage();
        loginPage.login(userName);
        user.setUserName(userName);
    }
}
