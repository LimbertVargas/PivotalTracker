package steps;

import core.utils.Log;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pivotaltracker.entities.Context;
import pivotaltracker.entities.Workspace;
import pivotaltracker.ui.pages.workspace.WorkspacePage;
import pivotaltracker.ui.pages.workspace.WorkspacePopup;
import pivotaltracker.ui.pages.workspace.WorkspaceTrackerPage;

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
    private WorkspacePopup workspacePopup;
    private WorkspaceTrackerPage workspaceTrackerPage;

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
     * Creates a new workspace sending the information.
     *
     * @param nameWorkspace contains the workspace values.
     */
    @When("I create a new workspace (.*)")
    public void iCreateANewWorkspace(final String nameWorkspace) {
        logs.info("Create a new workspace "+nameWorkspace);
        workspace.setNameWorkspace(nameWorkspace);
        workspacePage = new WorkspacePage();
        workspacePopup = workspacePage.clickNewWorkspaceCreateBtn();
        workspaceTrackerPage = workspacePopup.createNewWorkspace(nameWorkspace);
    }

    /**
     * This method check the created workspace in workspace page.
     */
    @Then("I should see the workspace in Workspace Page.")
    public void iShouldSeeTheWorkspaceInWorkspacePage() {
        Assert.assertEquals(workspaceTrackerPage.getNameWorkspace(),workspace.getNameWorkspace());
    }

    @Then("I should see the workspace in Dashboard Page.")
    public void iShouldSeeTheWorkspaceInDashboardPage() {
    }
}
