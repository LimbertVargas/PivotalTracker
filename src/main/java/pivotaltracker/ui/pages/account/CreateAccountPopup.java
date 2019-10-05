/*
 * @(#) CreateAccountPopup.java Copyright (c) 2019 Jala Foundation.
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
import core.utils.DriverMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;

/**
 * CreateAccountPopup class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class CreateAccountPopup extends BasePage {
    @FindBy(className = "tc_modal_content")
    private WebElement createAccountPopup;

    @FindBy(className = "tc-form__input")
    private WebElement accountNameTxt;

    @FindBy(css = "footer [class='zWDds__Button pvXpn__Button--positive']")
    private WebElement createAccountBtn;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        Log.getInstance().getLog().info("Wait for Create Account Popup upload in the Browser");
        wait.until(ExpectedConditions.visibilityOf(createAccountPopup));
    }

    /**
     * Gets account plan page with account name.
     *
     * @param accountName of type string
     * @return an account plan page.
     */
    public AccountPlansPage createNewAccount(final String accountName) {
        Log.getInstance().getLog().info("Create a New Account setting " + accountName + " in the Name Account Text");
        setAccountName(accountName);
        clickCreateAccountBtn();
        return new AccountPlansPage();
    }

    /**
     * Sets the account name.
     *
     * @param accountName of type String.
     */
    private void setAccountName(final String accountName) {
        DriverMethods.setText(accountNameTxt, accountName);
    }

    /**
     * Account save button.
     */
    private void clickCreateAccountBtn() {
        createAccountBtn.click();
    }
}
