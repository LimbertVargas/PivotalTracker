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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.ui.Permalink;

/**
 * AccountPlansPage class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountPlansPage extends AccountBasePage {

    @FindBy(className = "accounts_plans_page-wrapper")
    private WebElement accountPlansForm;

    private static final String URL_SETTINGS = "//a[@class='button'][text()='Settings']";

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountPlansForm));
    }

    /**
     * Gets url setting of account.
     *
     * @return string of url account
     */
    public String getUrlAccount() {
        return driver.findElement(By.xpath(URL_SETTINGS)).getAttribute("href");
    }

    /**
     * Gets id from url account setting.
     *
     * @return id of type int.
     */
    public int getId() {
        String idResult = getUrlAccount()
                .replace(ConfigFileReader.getInstance().getBaseUrl(), "")
                .replace(Permalink.ACCOUNT_PAGE, "")
                .replace(Permalink.ACCOUNT_SETTINGS_PAGE, "")
                .replaceAll("/", "");
        return Integer.valueOf(idResult);
    }
}
