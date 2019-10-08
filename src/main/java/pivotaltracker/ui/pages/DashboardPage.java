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
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;
import pivotaltracker.ui.pages.workspace.DashboardWorkspacePage;

/**
 * DashboardPage class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class DashboardPage extends BasePage {
    @FindBy(className = "Dashboard")
    private WebElement dashboardForm;

    @FindBy(css = "[aria-label='Profile Dropdown']")
    private WebElement profileBtn;

    @FindBy(id = "create-project-button")
    private WebElement createProjectBtn;

    @FindBy(css = "[class='Dashboard__Tabs__tab']")
    private WebElement workspaceTab;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(dashboardForm));
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
     * Does click on create new project.
     */
    private void createProjectBtn() {
        createProjectBtn.click();
    }

    /**
     * This method is in charge of show the project Popup.
     * @return
     */
    public CreateProjectPopup clickCreateProjectBtn() {
        createProjectBtn();
        return new CreateProjectPopup();
    }

    /**
     * This method verifies the access to a workspace tab.
     */
    public DashboardWorkspacePage accessWorkspaceTab() {
        workspaceTab.click();
        return new DashboardWorkspacePage();
    }
}
