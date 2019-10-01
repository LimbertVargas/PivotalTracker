/*
 * @(#) Hooks.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package hook;

import core.selenium.WebDriverManager;
import core.utils.Log;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import pivotaltracker.PageTransporter;
import pivotaltracker.entities.Account;
import pivotaltracker.entities.Context;
import pivotaltracker.ui.Permalink;
import pivotaltracker.ui.pages.account.AccountPlansPage;
import pivotaltracker.ui.pages.account.AccountSettingsPage;
import pivotaltracker.ui.pages.user.AccountPage;

/**
 * Hooks class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class Hooks {
    private Logger logs = Log.getInstance().getLog();
    private WebDriver webDriver;
    private AccountPage accountPage;
    private Context context;
    private Account account;
    private AccountPlansPage accountPlansPage;
    private AccountSettingsPage accountSettingsPage;

    /**
     * Constructor of class.
     */
    public Hooks(final Context context) {
        this.context = context;
        account = context.getAccount();
        webDriver = WebDriverManager.getInstance().getWebDriver();
    }

    /**
     * Method for attachment a picture.
     *
     * @param scenario of type scenario;
     */
    @After
    public void embedScreenshot(final Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }

    @After("@deleteAccount")
    public void deleteAccount() {
        logs.info("The Account is deleting");
        String urlAccount = account.getUrlAccount()
                .replace(Permalink.ACCOUNT_SETTINGS_PAGE,Permalink.ACCOUNT_PLANS_PAGE);
        PageTransporter.navigatePage(Permalink.ACCOUNT_PAGE.concat(urlAccount));
        accountSettingsPage = new AccountSettingsPage();
        accountSettingsPage.deleteAccount();
    }
}
