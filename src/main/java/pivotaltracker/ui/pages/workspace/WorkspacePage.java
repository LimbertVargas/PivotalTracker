/*
 * @(#) WorkspacePage.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.ui.pages.workspace;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.ui.BasePage;

/**
 * WorkspaceTrackerPage class
 *
 * @author Limbert Vargas
 * @version 1.0
 */
public class WorkspacePage extends BasePage {
    @FindBy(id = "tracker")
    private WebElement workspaceForm;

    @FindBy(className = "raw_context_name")
    private WebElement nameWorkspaceLbl;

    /**
     * Waits until page object is loaded
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(workspaceForm));
    }

    /**
     * This method is in charge of get a workspace name.
     *
     * @return the workspace name.
     */
    public String getNameWorkspace() {
        return nameWorkspaceLbl.getText();
    }
}
