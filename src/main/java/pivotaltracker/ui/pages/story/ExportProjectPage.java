/*
 * @(#) ExportProjectPage.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.ui.pages.story;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;

/**
 * ExportProjectPage class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class ExportProjectPage extends BasePage {
    @FindBy(id = "csv_import_file")
    private WebElement exportBtn;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(exportBtn));
    }

    /**
     * Click on export button.
     */
    private void clickExportBtn() {
        exportBtn.click();
    }

    /**
     * Exports project to csv.
     */
    public void exportProject() {
        clickExportBtn();
    }
}
