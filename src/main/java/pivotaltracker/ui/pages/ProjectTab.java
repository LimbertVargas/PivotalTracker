package pivotaltracker.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;

/**
 * ProjectTab class
 *
 * @author Limbert Vargas
 * @version 1.0
 */
public class ProjectTab extends BasePage {
    @FindBy(id = "create-project-button")
    private WebElement openProjectFormBtn;

    @FindBy(css = "[class='tc_modal tc-form-modal g-zym__ProjectModalDialog']")
    private WebElement createProjectForm;

    @FindBy(css = "[class='tc-form__input']")
    private WebElement projectNameTxtBox;

    @FindBy(css = "[class='zWDds__Button pvXpn__Button--positive']")
    private WebElement createProjectBtn;

    @FindBy(css = "[class='tc-account-selector__header']")
    private WebElement accountSelectorMenu;

    @FindBy(css = "[class='tc-account-selector__option-account-name']")
    private WebElement optionAccountNameComboBox;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(createProjectForm));
    }

    /**
     * Opens the form for creates project.
     */
    private void openCreateProjectForm() {
        openProjectFormBtn.click();
    }

    /**
     * Focuses the project form.
     */
    private void projectFormFocus() {
        createProjectForm.click();

    }

    /**
     * Opens account selector.
     */
    private void accountSelectorClick() {
        accountSelectorMenu.click();
    }

    /**
     * Selects first account.
     */
    private void selectAccount() {
        optionAccountNameComboBox.click();
    }

    /**
     * Does click on create project.
     */
    private void createProjectBtn() {
        createProjectBtn.click();
    }
}
