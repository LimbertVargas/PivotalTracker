package steps;

import core.utils.Log;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pivotaltracker.entities.Context;
import pivotaltracker.entities.Workspace;
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
    @Then("I should see the workspace in Workspace Page.")
    public void verifyTheWorkspaceCreatedIsInWorkspacePage() {
        Assert.assertEquals(workspacePage.getNameWorkspace(),workspace.getNameWorkspace());
    }
}
