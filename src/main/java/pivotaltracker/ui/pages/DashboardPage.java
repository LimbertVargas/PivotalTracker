package pivotaltracker.ui.pages;

import groovy.lang.Newify;
import pivotaltracker.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * DashboardPage class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class DashboardPage extends BasePage {
    @FindBy(css = "[aria-label='Profile Dropdown']")
    private WebElement profileBtn;

    @FindBy(css = "[class='Dashboard__Tabs__tab']")
    public WebElement projectTab;

    @FindBy(css = "[class='Dashboard__Tabs__tab Dashboard__Tabs__tab--active']")
    public WebElement workspaceTab;

    @FindBy(css = "[class='content clearfix']")
    public WebElement dashboardForm;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    /**
     * Return text from profile button.
     *
     * @return textProfileDrownBtn - Profile name text.
     */
    public String getTextProfileDrownBtn() {
        return profileBtn.getText();
    }
}
