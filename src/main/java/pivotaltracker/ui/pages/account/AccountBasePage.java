/*
 * @(#) AccountBasePage.java Copyright (c) 2019 Jala Foundation.
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
import pivotaltracker.ui.components.AccountNavBar;

/**
 * AccountBasePage class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountBasePage extends BasePage {
    @FindBy(className = "user_management_header")
    private WebElement accountHeader;
    private AccountNavBar accountNavBar;

    /**
     * Constructor.
     */
    public AccountBasePage() {
        super();
        accountNavBar = new AccountNavBar();
    }

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountHeader));
    }

    /**
     * Gets of account Bar tab.
     *
     * @return account of bar.
     */
    public AccountNavBar getAccountNavBar() {
        return accountNavBar;
    }
}
