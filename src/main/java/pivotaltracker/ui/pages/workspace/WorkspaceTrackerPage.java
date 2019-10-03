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
public class WorkspaceTrackerPage extends BasePage {
    @FindBy(id = "tracker")
    private WebElement workspaceTracker;

    @FindBy(className = "tc_context_name")
    private WebElement nameWorkspaceLbl;

    /**
     * Waits until page object is loaded
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(workspaceTracker));
    }

    public String getNameWorkspace() {
        return nameWorkspaceLbl.getText();
    }
}
