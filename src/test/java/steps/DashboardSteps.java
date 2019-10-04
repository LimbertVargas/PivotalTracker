package steps;

import core.utils.Log;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import pivotaltracker.entities.Context;
import pivotaltracker.entities.Workspace;
import pivotaltracker.ui.pages.workspace.WorkspacePage;
import pivotaltracker.ui.pages.workspace.WorkspacePopup;
import pivotaltracker.ui.pages.workspace.WorkspaceTab;
import pivotaltracker.ui.pages.workspace.WorkspaceTrackerPage;

/**
 * DashboardSteps class
 *
 * @author Limbert Vargas
 * @version 1.0
 */
public class DashboardSteps {
    WorkspaceTab workspaceTab;

    private Logger logs = Log.getInstance().getLog();
    private Workspace workspace;
    private Context context;
    private WorkspacePage workspacePage;
    private WorkspacePopup workspacePopup;
    private WorkspaceTrackerPage workspaceTrackerPage;

    @When("I Create a (.*) on Project tab with following data")
    public void iCreateAProjectOnProjectTabWithFollowingData(final String dashboardRef) {

    }


    /**
     * Creates a new workspace sending the information.
     *
     * @param nameWorkspace contains the workspace values.
     */
    @When("I create a new workspace (.*)")
    public void iCreateANewWorkspace(final String nameWorkspace) {
        logs.info("Create a new workspace " + nameWorkspace);
        workspace.setNameWorkspace(nameWorkspace);
        workspacePage = new WorkspacePage();
        workspacePopup = workspacePage.clickNewWorkspaceCreateBtn();
        workspaceTrackerPage = workspacePopup.createNewWorkspace(nameWorkspace);
    }
}
