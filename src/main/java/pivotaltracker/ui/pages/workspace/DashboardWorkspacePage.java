package pivotaltracker.ui.pages.workspace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;

/**
 * DashboardWorkspacePage class
 *
 * @author Limbert Vargas
 * @version 1.0
 */
public class DashboardWorkspacePage extends BasePage {
    @FindBy(id = "create-workspace-button")
    private WebElement workspaceBtn;

    @FindBy(className = "Dashboard")
    private WebElement DashboardForm;

    @FindBy(css = "[class='Dashboard__Tabs__tab']")
    private WebElement projectTab;

    @FindBy(css = "[class='Dashboard__Tabs__tab Dashboard__Tabs__tab--active']")
    private WebElement workspaceTab;

    private final String LIST_WORKSPACE = "//a[@class='WorkspaceTile__name'] [text()='nameWorkspace']";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(DashboardForm));
    }

    public Boolean IsDisplayedWorkspaceInTheList(final String nameWorkspace) {
        return driver.findElement(By.xpath(LIST_WORKSPACE.replace("nameWorkspace",nameWorkspace))).isDisplayed();
    }
    /**
     * This method verifies the access to a project tab.
     */
    private void accessProjectTab() {
        projectTab.click();
    }

    /**
     * This method verifies the access to a workspace tab.
     */
    private void accessWorkspaceTab() {
        workspaceTab.click();
    }

    /**
     * This method verifies to access to workspace button.
     */
    private void clickWorkspaceBtn() {
        workspaceBtn.click();
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
}
