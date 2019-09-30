package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pivotaltracker.ui.pages.WorkspaceTab;

import java.util.Map;

/**
 * DashboardSteps class
 *
 * @author Limbert Vargas
 * @version 1.0
 */
public class DashboardSteps {
WorkspaceTab workspaceTab;
    @When("I Create a (.*) on Project tab with following data")
    public void iCreateAProjectOnProjectTabWithFollowingData(final String dashboardRef) {

    }

    @Then("I should see the project in Project Page.")
    public void iShouldSeeTheProjectInProjectPage() {
    }

    @When("I Create a Workspace on Workspaces tab with following data")
    public void iCreateAWorkspaceOnWorkspacesTabWithFollowingData(Map name) {
        workspaceTab = new WorkspaceTab();
        workspaceTab.createWorkspace(name.get("Workspace Name").toString());
    }

    @Then("I should see the workspace in Workspace Page.")
    public void iShouldSeeTheWorkspaceInWorkspacePage() {
    }
}
