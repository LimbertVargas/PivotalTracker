package pivotaltracker.ui.pages.workspace;

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
}
