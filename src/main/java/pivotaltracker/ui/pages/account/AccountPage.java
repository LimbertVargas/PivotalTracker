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

import core.utils.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * AccountPage class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountPage extends AccountBasePage {
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


    @Override
    public void waitUntilPageObjectIsLoaded() {
        Log.getInstance().getLog().info("Wait for Create Account Popup upload in the Browser");
        wait.until(ExpectedConditions.visibilityOf(accountCreateForm));
    }

    public CreateAccountPopup clickNewAccountCreateBtn() {
        newAccountCreateBtn.click();
        return new CreateAccountPopup();
    }

    public String getMessageDelete() {
        return messageDelete.getText();
    }

}