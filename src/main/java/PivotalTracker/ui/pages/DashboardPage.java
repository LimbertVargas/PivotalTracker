package PivotalTracker.ui.pages;

import PivotalTracker.ui.BasePage;
import core.utils.PivotalTrackerUtils;
import java.util.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * DashboardPage class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class DashboardPage extends BasePage {
    @FindBy(xpath = "//div[@class=\"Dropdown__content\"] //button[@aria-label=\"Profile Dropdown\"]")
    private WebElement profileBtn;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    public String profileDropDownButtonText() {
        String profileDropDownButtonText = PivotalTrackerUtils.getMessage(profileBtn);
        return profileDropDownButtonText;
    }
}