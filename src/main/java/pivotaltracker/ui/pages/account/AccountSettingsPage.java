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
import pivotaltracker.BasePage;
import pivotaltracker.ui.pages.user.AccountPage;

/**
 * AccountSettingsPage class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountSettingsPage extends BasePage {
    @FindBy(className = "settings")
    private WebElement settingsAccountForm;

    @FindBy(xpath = "//a[@data-method=\"delete\"]")
    private WebElement deleteLbl;

    @FindBy(id = "account_name")
    private WebElement accountNameTxt;

    @FindBy(xpath = "//h4[text()='ID']/following-sibling::div")
    private WebElement accountIdTxt;

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
    private void clickDeleteOption() {
        deleteLbl.click();
        driver.switchTo().alert().accept();
    }
    /**
     * Get account page then accept delete.
     *
     * @return account page
     */
    public AccountPage deleteAccount() {
        clickDeleteOption();
        return new AccountPage();
    }

    /**
     * Sets the account name in .
     *
     * @param accountName of type String.
     */
    public void setNameAccount(final String accountName) {
        DriverMethods.setText(accountNameTxt, accountName);
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
    private void clickCreateAccountBtn() {
        saveBtn.click();
    }
}
