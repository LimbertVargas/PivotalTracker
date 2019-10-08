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
import pivotaltracker.BasePage;

/**
 * ImportProjectPAge class.
 *
 * @author John Salazar Pinto
 * @version 1.0
 */
public class ImportProjectPage extends BasePage {
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

    private final String SELENIUM_PROJECT_PATH = System.getProperty("user.dir") + "/src/test/resources/files/";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
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
    public String[] getList() {
        String[] a = new String[listWebElements.size()];
        for (int i = 0; i < listWebElements.size(); i++) {
            a[i] = listWebElements.get(i).getText();
        }
        return a;
    }
}
