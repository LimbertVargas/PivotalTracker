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

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    private void clickImportBtn() {
        importBtn.click();
    }

    private void sendPath() {
        DriverMethods.setText(chooseFileBtn, System.getProperty("user.dir") + "/" + "src/test/resources/files/test_20191006_1736.csv");
    }

    public void importFile() {
        sendPath();
        clickImportBtn();
    }

    private String getMessageTxt() {
        return messagingTxt.getText();
    }

    private String getMessageTxtPupUP() {
        return noticeMessage.getText();
    }

    public String messageCorrectImport() {
        return getMessageTxt();
    }

    public String messageCorrretImportPopUP() {
        return getMessageTxtPupUP();
    }

    public String[] getList() {
        String[] a = new String[listWebElements.size()];
        System.out.println(listWebElements.size() + " element size");
        for (int i = 0; i < listWebElements.size(); i++) {
            a[i] = listWebElements.get(i).getText();
            System.out.printf(a[i] + " LIST");
        }
        return a;
    }
}
