/*
 * @(#) DashboardSteps.java Copyright (c) 2019 Jala Foundation.
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
import cucumber.api.java.en.Then;
import org.testng.Assert;
import pivotaltracker.entities.Account;
import pivotaltracker.entities.Context;
import pivotaltracker.entities.User;
import pivotaltracker.ui.pages.CreateProjectPopup;
import pivotaltracker.ui.pages.DashboardPage;

/**
 * DashboardSteps class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class DashboardSteps {
    private CreateProjectPopup createProjectPopup;
    private DashboardPage dashboardPage;
    private Context context;
    private Account account;
    private User user;

    /**
     * Constructor for the class.
     *
     * @param context init the context.
     */
    public DashboardSteps(final Context context) {
        this.context = context;
        this.account = context.getAccount();
        this.user = context.getUser();
    }

    /**
     * This method checks the account name in create project popup.
     */
    @Then("I should see the new account in the Project Creation Popup")
    public void verifyTheNewAccountInTheProjectCreationPopup() {
        dashboardPage = new DashboardPage();
        createProjectPopup = dashboardPage.clickCreateProjectBtn();
        createProjectPopup.verifyAccountInList(account.getNameAccount());
    }

    /**
     * This method checks the user login with a text in the window.
     */
    @Then("I verify the user name will be shown on the top bar")
    public void verifyTheUserNameTheWillBeShownOnTheTopBar() {
        DashboardPage dashboardPage = new DashboardPage();
        String actual = dashboardPage.getTextProfileDrownBtn();
        String userName = user.getUserName();
        String expected = CredentialsReader.getInstance().getUserName(userName).toUpperCase();
        Assert.assertEquals(actual, expected);
    }
}
