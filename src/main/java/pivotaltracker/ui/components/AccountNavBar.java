/*
 * @(#) AccountNavBar.java Copyright (c) 2019 Jala Foundation.
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

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;
import pivotaltracker.ui.pages.account.AccountPage;
import pivotaltracker.ui.pages.account.NotificationsPage;
import pivotaltracker.ui.pages.account.ProfilePage;

/**
 * AccountNavBar class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountNavBar extends BasePage {
    @FindBy(className = "user_management_header")
    private WebElement accountsBar;

    @FindBy(className = SELECTED_TAB)
    private WebElement accountTabs;

    private static final String SELECTED_TAB = "//div[@class='sections'] //a[contains(text(),'%s')]";
    private static final String ACCOUNT = "accounts";
    private AccountPage accountPage;
    private ProfilePage profilePage;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountsBar));
    }

    /**
     * Clicks in account menu nameTab.
     *
     * @param nameTab is for navigate to tabs.
     */
    private void clickTabOption(final String nameTab) {
        String.format(SELECTED_TAB, nameTab);
        accountTabs.click();
    }

    /**
     * Gets of account Page.
     *
     * @return new account Page.
     */
    public AccountPage goToAccountPage() {
        clickTabOption(ACCOUNT);
        return new AccountPage();
    }

    /**
     * Gets of profile Page.
     *
     * @return new profile Page.
     */
    public ProfilePage goToProfilePage(final String namTab) {
        clickTabOption(namTab);
        return new ProfilePage();
    }

    /**
     * Gets of notification Page.
     *
     * @return new notification Page.
     */
    public NotificationsPage goToNotificationsPage(final String namTab) {
        clickTabOption(namTab);
        return new NotificationsPage();
    }
}
