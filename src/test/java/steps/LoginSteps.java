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
import PivotalTracker.ui.pages.LoginPage;
import core.utils.CredentialsReader;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * LoginSteps class
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class LoginSteps {
    private LoginPage loginPage;

//    @Given("I visit the {string} page of Pivotal Tracker")
//    public void iVisitThePageOfPivotalTracker(String arg0) {
//        PageTransporter.navigatePage("signin?source=navbar");
//    }
    @Given("^I visit the \"([^\"]*)\" page of Pivotal Tracker$")
    public void iVisitThePageOfPivotalTracker(String arg0) {
        PageTransporter.navigatePage("signin?source=navbar");
    }

//    @When("I fill the field with credentials from user {string}")
//    public void iFillTheFieldWithCredentialsFromUser(String user) {
//        loginPage = new LoginPage();
//        loginPage.putCredentials(user);
//    }
    @When("^I fill the field with credentials from user \"([^\"]*)\"$")
    public void iFillTheFieldWithCredentialsFromUser(String user) {
        loginPage = new LoginPage();
        loginPage.putCredentials(user);
    }

//    @Then("To verify the user the {string} will be shown")
//    public void toVerifyTheUserTheWillBeShown(String user) {
//        String actual = user;
//        String expected = CredentialsReader.getInstance().getUserName(user);
//        Assert.assertEquals(actual, expected);
//    }
    @Then("^To verify the user the \"([^\"]*)\" will be shown$")
    public void toVerifyTheUserTheWillBeShown(String user) {
        String actual = user;
        String expected = CredentialsReader.getInstance().getUserName(user);
        Assert.assertEquals(actual, expected);
    }
}
