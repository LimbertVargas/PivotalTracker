package pivotaltracker.ui.pages.workspace;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;

/**
 * WorkspaceTrackerPage class
 *
 * @author Limbert Vargas
 * @version 1.0
 */
public class WorkspacePage extends BasePage {
    @FindBy(id = "tracker")
    private WebElement workspaceForm;

    @FindBy(className = "raw_context_name")
    private WebElement nameWorkspaceLbl;

    /**
     * Waits until page object is loaded
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(workspaceForm));
    }

    /**
     * This method is in charge of get a workspace name.
     *
     * @return the workspace name.
     */
    public String getNameWorkspace() {
        return nameWorkspaceLbl.getText();
    }
}
