package pivotaltracker.ui.pages;

import org.kohsuke.rngom.parse.host.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import pivotaltracker.BasePage;

/**
 * WorkspacePage class
 *
 * @author Limbert Vargas
 * @version 1.0
 */
public class WorkspacePage extends BasePage {

    @FindBy(css = "[class='main workspace']")
    private WebElement workspaceForm;

    @FindBy(css = "[class='raw_context_name']")
    private  WebElement nameWorkspaceLbl;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(workspaceForm));
    }

    /**
     * This method returns the name of workspace.
     *
     * @return getNameWorkspace.
     */
    public String getNameWorkspace() {
        return nameWorkspaceLbl.getText();
    }
}
