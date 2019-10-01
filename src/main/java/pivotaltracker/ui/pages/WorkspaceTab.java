package pivotaltracker.ui.pages;

import core.utils.DriverMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * WorkspaceTab class
 *
 * @author Limbert Vargas
 * @version 1.0
 */
public class WorkspaceTab extends DashboardPage {
    @FindBy(id="create-workspace-button")
    private WebElement workspaceBtn;

    @FindBy(css = "[class='tc_modal_content']")
    private WebElement workspacePopup;

    @FindBy(xpath = "//div[@class='tc_modal_content'] //input")
    private WebElement workspaceNameTextBox;

    @FindBy(css = "[class='zWDds__Button pvXpn__Button--positive']")
    private WebElement createWorkspaceBtn;

    /**
     *
     * @param workspaceName
     */
    public void createWorkspace(final String workspaceName) {
        workspaceTab.click();
        workspaceBtn.click();
        DriverMethods.setText(workspaceNameTextBox, workspaceName);
        createWorkspaceBtn.click();
    }

    private String nameWorkspace;

    public String getNameWorkspace(){
        return nameWorkspace;
    }
}
