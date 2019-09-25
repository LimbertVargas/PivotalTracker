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
}
