/*
 * @(#) AccountPage.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.ui.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;

/**
 * AccountPage class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountPage extends BasePage {
    @FindBy(css = "[class='page_description']")
    private WebElement accountCreateForm;

    @FindBy(id = "new_account_link")
    private WebElement newAccountCreateBtn;

    @FindBy(css = "div[id='accounts_module'] [class='name']")
    private WebElement accountsModuleList;

    @FindBy(css = ".content")
    private WebElement accountForm;

    @FindBy(id = "notice")
    private WebElement messageDelete;

    private String accountPath = "//div[contains(text(),'account')]";

    private String accountList = "//div[@id='accounts_module']//div[@class='name']";

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountCreateForm));
    }

    /**
     * Gets add account.
     *
     * @return new account Popup.
     */
    public CreateAccountPopup clickNewAccountCreateBtn() {
        newAccountCreateBtn.click();
        return new CreateAccountPopup();
    }

    /**
     * Gets of message delete.
     *
     * @return text of message.
     */
    public String getMessageDelete() {
        return messageDelete.getText();
    }
}