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

import org.testng.Assert;

import core.utils.CredentialsReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pivotaltracker.PageTransporter;
import pivotaltracker.entities.User;
import pivotaltracker.ui.Permalink;
import pivotaltracker.ui.pages.LoginPage;
import pivotaltracker.ui.pages.workspace.DashboardWorkspacePage;

/**
 * LoginSteps class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class LoginSteps {
    private LoginPage loginPage;
    private User user;

    /**
     * This method opens the page.
     *
     * @param page for navigate.
     */
    @Given("I go to the (.*) Page")
    public void goThePagesOfPivotalTracker(final String page) {
        PageTransporter.navigatePage(Permalink.getPermalink(page));
    }

    /**
     * This method fills in the user data to be able to log in.
     *
     * @param userName
     */
    @When("^I fill the field with credentials from user \"([^\"]*)\"$")
    public void fillTheFieldWithCredentialsFromUser(String userName) {
        user = new User();
        user.setUserName(userName);
        loginPage = new LoginPage();
        loginPage.login(userName);
    }

    /**
     * This method checks the user login with a text in the window.
     */
    @Then("I verify the user name will be shown on the top bar")
    public void verifyTheUserNameTheWillBeShownOnTheTopBar(String nameWorkspace) {
        DashboardWorkspacePage dashboardPage = new DashboardWorkspacePage();
        Boolean actual = dashboardPage.IsDisplayedWorkspaceInTheList(nameWorkspace);
        String userName = user.getUserName();
        String expected = CredentialsReader.getInstance().getUserName(userName).toUpperCase();
        Assert.assertEquals(actual, expected);
    }
}
