package pivotaltracker.ui.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotaltracker.BasePage;
import pivotaltracker.ui.pages.DashboardPage;

/**
 * TopBarBasePage class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class TopBarBasePage extends BasePage {
    private DashboardPage dashboardPage;
    @FindBy(css = "[aria-label='Profile Dropdown']")
    private WebElement profileBtn;

    @FindBy(css = "[class='Dropdown__option selected Dropdown__option--button']")
    private WebElement singOutBtn;

    @FindBy(linkText = "Help")
    private WebElement helpBtn;

    @FindBy(linkText = "What's New")
    private WebElement newsBtn;

    @FindBy(xpath = "//div[@class='Dropdown__options Dropdown__options--small'] //a[@href='/profile']")
    private WebElement profileOptionLink;

    @FindBy(xpath = "//div[@class='Dropdown__options Dropdown__options--small'] //a[@href='/accounts']")
    private WebElement accountOptionLink;

    @FindBy(xpath = "//div[@class='Dropdown__options Dropdown__options--small'] //button")
    private WebElement signOutBtn;

    @FindBy(css = "[class='search_bar']")
    private WebElement searchTxtBox;

    @FindBy(css = "[class='tc_projects_dropdown_link tc_context_name']")
    private WebElement principalBtn;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    public TopBarBasePage() {
        super();
        this.dashboardPage = new DashboardPage();
    }

    public DashboardPage getDashboardPage() {
        return dashboardPage;
    }
}
