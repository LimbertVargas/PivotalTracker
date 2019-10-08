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

package hooks;

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
import pivotaltracker.ui.components.TopBar;
import pivotaltracker.ui.pages.LoginPage;
import pivotaltracker.ui.pages.account.AccountSettingsPage;

/**
 * Hooks class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class Hooks {
    private Logger logs = Log.getInstance().getLog();
    private WebDriver webDriver;
    private Context context;
    private Account account;
    private AccountSettingsPage accountSettingsPage;
    private TopBar topBar;

    /**
     * constructor for the class.
     *
     * @param context init the context.
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

    /**
     * Method for delete a account.
     */
    @After("@deleteAccount")
    public void deleteAccount() {
        int accountId = account.getId();
        PageTransporter.navigatePageById(Permalink.ACCOUNT_PAGE, accountId, Permalink.ACCOUNT_SETTINGS_PAGE);
        accountSettingsPage = new AccountSettingsPage();
        accountSettingsPage.clickDeleteOption();
        logs.info("The Account is deleting");
    }

    /**
     * Method for logOut.
     */
    @After(value = "@logOut", order = 0)
    public void logOutWebSite() {
        topBar = new TopBar();
        topBar.logOut();
        webDriver.manage().deleteAllCookies();
        LoginPage loginPage = new LoginPage();
        logs.info("The Web Site log out");
    }
}
