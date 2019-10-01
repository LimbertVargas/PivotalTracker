/*
 * @(#) AccountMenu.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.ui.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;
import pivotaltracker.ui.pages.account.AccountMemberPage;
import pivotaltracker.ui.pages.account.AccountSettingsPage;

/**
 * AccountMenu class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountMenu extends BasePage {

    @FindBy(className = "account_name")
    private WebElement nameAccountLbl;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameAccountLbl));
    }

    /**
     * Gets name Account.
     *
     * @return a string.
     */
    public String getNameAccount() {
        return nameAccountLbl.getText();
    }

    public AccountMemberPage goToAccountMemberPage() {
        return new AccountMemberPage();
    }

    public AccountSettingsPage goToAccountSettingsPage() {
        return new AccountSettingsPage();
    }
}
