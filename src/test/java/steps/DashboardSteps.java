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

import core.utils.Log;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pivotaltracker.entities.Account;
import pivotaltracker.entities.Context;
import pivotaltracker.entities.User;
import pivotaltracker.entities.Workspace;
import pivotaltracker.ui.pages.CreateProjectPopup;
import pivotaltracker.ui.pages.DashboardPage;
import pivotaltracker.ui.pages.workspace.DashboardWorkspacePage;
import pivotaltracker.ui.pages.workspace.WorkspacePage;
import pivotaltracker.ui.pages.workspace.WorkspacePopup;

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
    private DashboardWorkspacePage dashboardWorkspacePage;
    private Logger logs = Log.getInstance().getLog();
    private Workspace workspace;
    private WorkspacePopup workspacePopup;
    private WorkspacePage workspacePage;
    private DashboardWorkspacePage dashboard;

    /**
     * Constructor for the class.
     *
     * @param context init the context.
     */
    public DashboardSteps(final Context context) {
        this.context = context;
        this.account = context.getAccount();
        this.user = context.getUser();
        this.workspace = context.getWorkspace();
    }

    /**
     * Creates a new workspace sending the information.
     *
     * @param nameWorkspace contains the workspace values.
     */
    @When("I create a new workspace \"(.*)\"")
    public void createANewWorkspace(final String nameWorkspace) {
        dashboardWorkspacePage = new DashboardWorkspacePage();
        logs.info("Create a new workspace " + nameWorkspace);
        workspace.setNameWorkspace(nameWorkspace);
        workspacePopup = dashboardWorkspacePage.clickCreateWorkspacePopup();
        workspacePage = workspacePopup.createNewWorkspace(nameWorkspace);
    }

    /**
     * This method check the created workspace in dashboard page.
     */
    @Then("I should see the workspace in Dashboard Page")
    public void verifyThatIShouldSeeTheWorkspaceInDashboardPage() {
        dashboard = new DashboardWorkspacePage();
        Assert.assertTrue(dashboard.IsDisplayedWorkspaceInTheList(workspace.getNameWorkspace()), workspace.getNameWorkspace());
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
        dashboardPage = new DashboardPage();
        Assert.assertEquals(dashboardPage.getTextProfileDrownBtn(), user.getUserName().toUpperCase());
    }
}
