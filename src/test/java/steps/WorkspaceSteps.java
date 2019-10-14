/*
 * @(#) WorkspaceSteps.java Copyright (c) 2019 Jala Foundation.
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
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pivotaltracker.entities.Context;
import pivotaltracker.entities.Workspace;
import pivotaltracker.ui.pages.DashboardPage;
import pivotaltracker.ui.pages.workspace.WorkspacePage;

/**
 * WorkspaceSteps class
 *
 * @author Limbert Vargas
 * @version 1.0
 */
public class WorkspaceSteps {
    private Logger logs = Log.getInstance().getLog();
    private Workspace workspace;
    private Context context;
    private WorkspacePage workspacePage;
    private DashboardPage dashboardPage;

    /**
     * Constructor of workspace steps sending the context.
     *
     * @param context init the context.
     */
    public WorkspaceSteps(Context context) {
        this.context = context;
        this.workspace = context.getWorkspace();
    }

    /**
     * This method check the created workspace in workspace page.
     */
    @Then("I should see the workspace in Workspace Page")
    public void verifyTheWorkspaceCreatedIsInWorkspacePage() {
        workspacePage = new WorkspacePage();
        Assert.assertEquals(workspacePage.getNameWorkspace(),workspace.getNameWorkspace());
    }

    /**
     * This method access a workspace tab in dashboard to see a workspace created.
     */
    @When("I go to the Workspace Tab inside Dashboard page")
    public void goToTheWorkspaceTabInsideDashboardPage() {
        dashboardPage = new DashboardPage();
        dashboardPage.accessWorkspaceTab();
    }
}
