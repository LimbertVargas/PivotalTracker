/*
 * @(#) UserNavBar.java Copyright (c) 2019 Jala Foundation.
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
import pivotaltracker.ui.pages.user.AccountPage;
import pivotaltracker.ui.pages.user.NotificationsPage;
import pivotaltracker.ui.pages.user.ProfilePage;

/**
 * UserNavBar class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class UserNavBar extends BasePage {
    @FindBy(className = "user_management_header")
    private WebElement accountsBar;

    @FindBy(xpath = "//a[text()='accounts']")
    private WebElement accountTabOption;

    @FindBy(xpath = "//a[text()='profile']")
    private WebElement profileTabOption;

    @FindBy(xpath = "//a[text()='notifications']")
    private WebElement notificationTabOption;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountsBar));
    }

    /**
     * Clicks in account menu nameTab.
     */
    private void clickAccountTabOption() {
        accountTabOption.click();
    }

    /**
     * Clicks in profile menu nameTab.
     */
    private void clickProfileTabOption() {
        profileTabOption.click();
    }

    /**
     * Clicks in notification menu nameTab.
     */
    private void clickNotificationTabOption() {
        notificationTabOption.click();
    }

    /**
     * Gets of account Page.
     *
     * @return new account Page.
     */
    public AccountPage goToAccountPage() {
        clickAccountTabOption();
        return new AccountPage();
    }

    /**
     * Gets of profile Page.
     *
     * @return new profile Page.
     */
    public ProfilePage goToProfilePage() {
        clickProfileTabOption();
        return new ProfilePage();
    }

    /**
     * Gets of notification Page.
     *
     * @return new notification Page.
     */
    public NotificationsPage goToNotificationsPage() {
        clickNotificationTabOption();
        return new NotificationsPage();
    }
}
