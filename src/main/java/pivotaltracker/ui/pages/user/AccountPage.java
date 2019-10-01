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

package pivotaltracker.ui.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;
import pivotaltracker.ui.pages.account.CreateAccountPopup;

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

    private static final String NAME_ACCOUNT = "//div[@class='header'] //div[contains(text(),'%s')]";

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

    /**
     * Checks name in account List.
     *
     * @param name of account string.
     * @return boolean.
     */
    public boolean isDisplayedNewAccount(final String name) {
        return driver.findElement(By.xpath(String.format(NAME_ACCOUNT, name))).isDisplayed();
    }
}
