/*
 * @(#) AccountPlansPage.java Copyright (c) 2019 Jala Foundation.
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

import core.utils.ConfigFileReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;
import pivotaltracker.ui.Permalink;
import pivotaltracker.ui.components.AccountMenu;

/**
 * AccountPlansPage class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountPlansPage extends BasePage {

    @FindBy(id = "plans_table")
    private WebElement accountPlansForm;

    private AccountMenu accountMenu;

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountPlansForm));
    }

    /**
     * Constructor.
     */
    public AccountPlansPage() {
        this.accountMenu = new AccountMenu();
    }

    /**
     * Gets of account menu.
     *
     * @return new account menu.
     */
    public AccountMenu getAccountMenu() {
        return accountMenu;
    }

    public String getUrlAccount() {
        String urlResult =  driver.getCurrentUrl()
                .replace(ConfigFileReader.getInstance().getBaseUrl(), "")
                .replace(Permalink.ACCOUNT_PAGE, "");
        return urlResult;
    }

    public int getId() {
        String idResult = getUrlAccount()
                .replace(ConfigFileReader.getInstance().getBaseUrl(), "")
                .replace(Permalink.ACCOUNT_PAGE, "")
                .replace(Permalink.ACCOUNT_PLANS_PAGE, "")
                .replaceAll("/", "");
        return Integer.parseInt(idResult);
    }
}
