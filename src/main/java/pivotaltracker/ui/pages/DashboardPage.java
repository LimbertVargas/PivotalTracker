package pivotaltracker.ui.pages;

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
