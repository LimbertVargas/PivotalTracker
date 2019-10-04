package steps;

import core.utils.Log;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

import org.testng.Assert;
import pivotaltracker.entities.Context;
import pivotaltracker.entities.Workspace;
import pivotaltracker.ui.pages.workspace.DashboardWorkspacePage;
import pivotaltracker.ui.pages.workspace.WorkspacePage;
import pivotaltracker.ui.pages.workspace.WorkspacePopup;

/**
 * DashboardSteps class
 *
 * @author Limbert Vargas
 * @version 1.0
 */
public class DashboardSteps {
    private DashboardWorkspacePage dashboardWorkspacePage;

    private Logger logs = Log.getInstance().getLog();
    private Workspace workspace;
    private Context context;
    private WorkspacePopup workspacePopup;
    private WorkspacePage workspacePage;
    private DashboardWorkspacePage dashboard;

    /**
     * Creates a new workspace sending the information.
     *
     * @param nameWorkspace contains the workspace values.
     */
    @When("I create a new workspace (.*)")
    public void createANewWorkspace(final String nameWorkspace) {
        dashboardWorkspacePage = new DashboardWorkspacePage();
        logs.info("Create a new workspace " + nameWorkspace);
        workspace.setNameWorkspace(nameWorkspace);
        workspacePopup = dashboardWorkspacePage.clickCreateWorkspacePopup();
        workspacePage = workspacePopup.createNewWorkspace(nameWorkspace);
    }

    //cambiar titulo de metodo
    @Then("I should see the workspace in Dashboard Page.")
    public void iShouldSeeTheWorkspaceInDashboardPage(final String nameWorkspace) {
        dashboard = new DashboardWorkspacePage();
        Assert.assertEquals(dashboard.IsDisplayedWorkspaceInTheList(nameWorkspace),workspace.getNameWorkspace());
    }
}
