package pivotaltracker.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * TopBar class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class TopBar {
    @FindBy(css = "[aria-label='Profile Dropdown']")
    private WebElement profileBtn;

    @FindBy(xpath = "//div[@class='Dropdown'] //button[contains(.,'Help')]")
    private WebElement helpBtn;

    @FindBy(xpath = "//div[@class='Dropdown'] //button[contains(.,'What's New')]")
    private WebElement newsBtn;
}
