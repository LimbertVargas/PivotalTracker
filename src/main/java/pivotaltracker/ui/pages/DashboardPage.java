/*
 * @(#) DashboardPage.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.ui.pages;

import core.utils.DriverMethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pivotaltracker.BasePage;

/**
 * DashboardPage class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class DashboardPage extends BasePage {
    @FindBy(css = "[aria-label='Profile Dropdown']")
    private WebElement profileBtn;

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

    /**
     * Create Project.
     *
     * @param projectName - Name of the project.
     */
    public void createProject(final String projectName) {
        openCreateProjectForm();
        projectFormFocus();
        DriverMethods.setText(projectNameTxtBox, projectName);
        accountSelectorClick();
        selectAccount();
        createProjectBtn();
    }
}
