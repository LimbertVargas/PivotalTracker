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

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @FindBy(css = "[class='Dashboard__Tabs__tab']")
    private WebElement projectTab;

    @FindBy(css = "[class='Dashboard__Tabs__tab Dashboard__Tabs__tab--active']")
    private WebElement workspaceTab;

    @FindBy(css = "[class='content clearfix']")
    private WebElement dashboardForm;

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
}
