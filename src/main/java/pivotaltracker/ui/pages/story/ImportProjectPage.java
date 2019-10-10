/*
 * @(#) ImportProjectPage.java Copyright (c) 2019 Jala Foundation.
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

import core.utils.DriverMethods;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.ui.BasePage;
import pivotaltracker.entities.CSVFile;
import pivotaltracker.entities.Context;

/**
 * ImportProjectPAge class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class ImportProjectPage extends BasePage {
    public static final String TITLE = "title";
    public static final String LABELS = "labels";
    public static final String STORY_TYPE = "storyType";
    public static final String ID = "id";
    public static final String ESTIMATE = "estimate";
    private Context context;
    private CSVFile csvFile;

    @FindBy(xpath = "//div[@class='file_uploader field_column'] //input")
    private WebElement chooseFileBtn;

    @FindBy(id = "csv_import_file")
    private WebElement importBtn;

    @FindBy(xpath = "//div[@class='import_messaging'] //div[@class='result import_success']")
    private WebElement messagingTxt;

    @FindBy(id = "notice")
    private WebElement noticeMessage;

    @FindBy(css = "[class='tracker_markup']")
    private List<WebElement> listWebElements;

    @FindBy(css = "[class='std label']")
    private List<WebElement> listWebElementsLabels;

    @FindBy(css = "[class=\"tn-panel__loom\"] [data-aid=\"StoryPreviewItem\"]")
    private List<WebElement> listWebElementsID;

    private static final String SELENIUM_PROJECT_PATH = System.getProperty("user.dir") + "/src/test/resources/files/";
    private final String storyLocator = "//div[@data-id=\"%s\"] //button[@tabindex=\"-1\"]";

    /**
     * Waits element for run steps.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(importBtn));
    }

    /**
     * Click on import button.
     */
    private void clickImportBtn() {
        importBtn.click();
    }

    /**
     * Sends path for upload file.
     *
     * @param filePath - File path
     */
    private void sendPath(final String filePath) {
        DriverMethods.setText(chooseFileBtn, SELENIUM_PROJECT_PATH + filePath);
    }

    /**
     * Imports csv file.
     *
     * @param fileName - File name
     */
    public void importFile(final String fileName) {
        sendPath(fileName);
        clickImportBtn();
    }

    /**
     * Gets confirmation message.
     *
     * @return message
     */
    private String getMessageTxt() {
        return messagingTxt.getText();
    }

    /**
     * Gets message from popup.
     *
     * @return popup messasge
     */
    private String getMessageTxtPopUP() {
        return noticeMessage.getText();
    }

    /**
     * Gets message correct import from text.
     *
     * @return message import.
     */
    public String messageCorrectImport() {
        return getMessageTxt();
    }

    /**
     * Gets message correct import from popup.
     *
     * @return message import popup
     */
    public String messageCorrretImportPopUP() {
        return getMessageTxtPopUP();
    }

    /**
     * Get array text from WebElements.
     *
     * @return list of text
     */
    public String[] getTitleList() {
        return DriverMethods.getElementsText(listWebElements);
    }

    /**
     * Get array text from WebElements.
     *
     * @return list of text
     */
    public String[] getLabels() {
        return DriverMethods.getElementsText(listWebElementsLabels);
    }
}
