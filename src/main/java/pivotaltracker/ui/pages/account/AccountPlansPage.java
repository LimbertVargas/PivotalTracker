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

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;
import pivotaltracker.ui.components.AccountBar;

/**
 * AccountPlansPage class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountPlansPage extends BasePage {

    @FindBy(id = "plans_table")
    private WebElement accountPlansForm;

    private static final String URL_SETTINGS = "//a[@class='button'] [normalize-space()='Settings']";

    private AccountBar accountBar;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountPlansForm));
    }

    public AccountPlansPage() {
        this.accountBar = new AccountBar();
    }

    public String getURLAccountSettings() {
        return driver.findElement(By.xpath(URL_SETTINGS)).getAttribute("href");
    }

    public AccountBar getAccountBar() {
        return accountBar;
    }
}
