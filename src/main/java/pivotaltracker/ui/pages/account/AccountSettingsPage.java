/*
 * @(#) AccountSettingsPage.java Copyright (c) 2019 Jala Foundation.
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

import core.utils.DriverMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * AccountSettingsPage class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountSettingsPage extends AccountBasePage {
    @FindBy(className = "settings")
    private WebElement settingsAccountForm;

    @FindBy(css = "div[class='description'] a[data-method='delete']")
    private WebElement deleteLbl;

    @FindBy(id = "account_name")
    private WebElement accountNameTxt;

    @FindBy(xpath = "//h4[text()='ID']/following-sibling::div")
    private WebElement accountIdTxt;

    @FindBy(className = "account_name")
    private WebElement accountNameLbl;

    @FindBy(css = "div[class='save_changes'] input")
    private WebElement saveBtn;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(settingsAccountForm));
    }

    /**
     * Click delete option.
     */
    public void clickDeleteOption() {
        deleteLbl.click();
        driver.switchTo().alert().accept();
    }

    /**
     * Sets the account name in .
     *
     * @param accountName of type String.
     */
    public void setAccountName(final String accountName) {
        DriverMethods.setText(accountNameTxt, accountName);
        clickSaveAccountBtn();
    }

    /**
     * Sets the account name in .
     *
     * @param accountId of type String.
     */
    public void setIdAccount(final String accountId) {
        DriverMethods.setText(accountIdTxt, accountId);
    }

    /**
     * Account save button.
     */
    private void clickSaveAccountBtn() {
        saveBtn.click();
    }

    /**
     * Gets name in account settings.
     *
     * @return account name in String
     */
    public String getNameAccount() {
        return accountNameLbl.getText();
    }
}
