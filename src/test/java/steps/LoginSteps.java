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

import PivotalTracker.PageTransporter;
import PivotalTracker.entities.User;
import PivotalTracker.ui.pages.DashboardPage;
import PivotalTracker.ui.pages.LoginPage;
import core.utils.CredentialsReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

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
     * Steps for visit any page.
     *
     * @param page - Page to visit.
     */
    @Given("I visit the (.*) Page of Pivotal Tracker")
    public void goThePagesOfPivotalTracker(final String page) {
        PageTransporter.navigatePage("signin?source=navbar");
    }

    /**
     * 
     * @param userName
     */
    @When("^I fill the field with credentials from user \"([^\"]*)\"$")
    public void fillTheFieldWithCredentialsFromUser(String userName) {
        user = new User();
        user.setUserName(userName);
        loginPage = new LoginPage();
        loginPage.setCredentials(userName);
    }

    @Then("I verify the user name will be shown on the top bar")
    public void verifyTheUserNameTheWillBeShownOnTheTopBar() {
        DashboardPage dashboardPage = new DashboardPage();
        String actual = dashboardPage.getTextProfileDrownBtn();
        String userName = user.getUserName();
        String expected = CredentialsReader.getInstance().getUserName(userName);
        Assert.assertEquals(actual, expected);
    }
}
