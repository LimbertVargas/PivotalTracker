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
    private WebElement createWorkspacePopupForm;

    @FindBy(className = "tc-form__input")
    private WebElement workspaceNameTxt;

    @FindBy(className = "zWDds__Button pvXpn__Button--positive")
    private WebElement createWorkspaceBtn;

    @FindBy(className = "zWDds__Button CMa1J__Button--open")
    private WebElement cancelWorkspaceBtn;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        Log.getInstance().getLog().info("Wait for Crete Workspace Popup upload in the Browser");
        wait.until(ExpectedConditions.visibilityOf(createWorkspacePopupForm));
    }

    /**
     * Gets worksapce page with workspace name.
     *
     * @param workspaceName of type string.
     * @return an workspace trancker page.
     */
    public WorkspacePage createNewWorkspace(final String workspaceName) {
        setWorkspaceName(workspaceName);
        clickCreateWorkspaceBtn();
        return new WorkspacePage();
    }

    /**
     * Sets the workspace name.
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

    /**
     * Workspace cancel button.
     */
    private void clickCancelWorkspaceBtn() {
        cancelWorkspaceBtn.click();
    }
}
