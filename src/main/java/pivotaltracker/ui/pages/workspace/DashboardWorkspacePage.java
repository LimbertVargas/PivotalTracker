package pivotaltracker.ui.pages.workspace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;
import pivotaltracker.ui.pages.DashboardPage;

/**
 * DashboardWorkspacePage class
 *
 * @author Limbert Vargas
 * @version 1.0
 */
public class DashboardWorkspacePage extends BasePage {
    @FindBy(className = "Dashboard")
    private WebElement DashboardForm;

    @FindBy(css = "[class='Dashboard__Tabs__tab']")
    private WebElement projectTab;

    @FindBy(className = "Dropdown__content")
    private WebElement userName;

    @FindBy(id = "create-workspace-button")
    private WebElement createWorkspaceBtn;


    /**
     * This method is in charge of finds the name of the workspace.
     */
    private final String LIST_WORKSPACE = "//a[@class='WorkspaceTile__name'] [text()='nameWorkspace']";

    /**
     * Waits until page object is loaded
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(DashboardForm));
    }

    /**
     * This method is in charge of finds a workspaces for lists.
     *
     * @param nameWorkspace is the name of the Workspace created.
     * @return the comparision of workspace's name.
     */
    public boolean IsDisplayedWorkspaceInTheList(final String nameWorkspace) {
        return driver.findElement(By.xpath(LIST_WORKSPACE.replace("nameWorkspace", nameWorkspace))).isDisplayed();
    }

    /**
     * This method verifies the access to a project tab.
     */
    private void accessProjectTab() {
        projectTab.click();
    }

    /**
     * This method is in charge of to access to workspace popup.
     *
     * @return a workspace popup.
     */
    public WorkspacePopup clickCreateWorkspacePopup() {
         clickWorkspaceBtn();
        return new WorkspacePopup();
    }

    /**
     * This method shows de user name.
     *
     * @return text of user name.
     */
    public String getTextProfileDrownBtn() {
        return userName.getText();
    }

    /**
     * This method verifies to access to workspace button.
     */
    private void clickWorkspaceBtn() {
        createWorkspaceBtn.click();
    }
}
