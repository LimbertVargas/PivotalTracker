package pivotaltracker.ui.pages.workspace;

import core.utils.DriverMethods;
import core.utils.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;

/**
 * WorkspacePopup class
 *
 * @author Limbert Vargas
 * @version 1.0
 */
public class WorkspacePopup extends BasePage {
    @FindBy(className = "tc_modal_content")
    private WebElement createWorkspacePopup;

    @FindBy(className = "tc-form__input")
    private WebElement workspaceNameTxt;

    @FindBy(css = "footer [class='zWDds__Button pvXpn__Button--positive']")
    private WebElement createWorkspaceBtn;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        Log.getInstance().getLog().info("Wait for Crete Workspace Popup upload in the Browser");
        wait.until(ExpectedConditions.visibilityOf(createWorkspacePopup));
    }

    /**
     * Gets worksapce tracker page with workspace name.
     *
     * @param workspaceName of type string.
     * @return an workspace trancker page.
     */
    public WorkspaceTrackerPage createNewWorkspace(final String workspaceName) {
        Log.getInstance().getLog().info("Create a New Workspace setting " + workspaceName);
        setWorkspaceName(workspaceName);
        Log.getInstance().getLog().info("Click to the Create Workspace Button");
        clickCreateWorkspaceBtn();
        return new WorkspaceTrackerPage();
    }

    /**
     * Sets the worksapce name.
     *
     * @param workspaceName of type String.
     */
    private void setWorkspaceName(final String workspaceName) {
        DriverMethods.setText(workspaceNameTxt, workspaceName);
    }

    /**
     * Workspace save button.
     */
    private void clickCreateWorkspaceBtn() {
        createWorkspaceBtn.click();
    }
}
