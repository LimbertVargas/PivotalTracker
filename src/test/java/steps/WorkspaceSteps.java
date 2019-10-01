package steps;

import cucumber.api.java.en.Then;
import org.testng.Assert;
import pivotaltracker.entities.Workspace;
import pivotaltracker.ui.pages.DashboardPage;
import pivotaltracker.ui.pages.WorkspacePage;
import pivotaltracker.ui.pages.WorkspaceTab;

/**
 * WorkspaceSteps class
 *
 * @author Limbert Vargas
 * @version 1.0
 */
public class WorkspaceSteps {
    Workspace workspace;
    WorkspacePage workspacePage;
    WorkspaceTab workspaceTab;

    /**
     * This method check the created workspace in workspace page.
     */
    @Then("I should see the workspace in Workspace Page.")
    public void iShouldSeeTheWorkspaceInWorkspacePage() {
        Assert.assertEquals(workspacePage.getNameWorkspace(), workspace.getNameWorkspace());
    }

    @Then("I should see the workspace in Dashboard Page.")
    public void iShouldSeeTheWorkspaceInDashboardPage() {
        Assert.assertEquals(workspacePage.getNameWorkspace(), workspaceTab.getNameWorkspace());
    }
}
