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
import pivotaltracker.ui.pages.account.AccountPage;
import pivotaltracker.ui.pages.account.NotificationsPage;
import pivotaltracker.ui.pages.account.ProfilePage;

/**
 * UserNavBar class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class UserNavBar extends BasePage {
    @FindBy(className = "user_management_header")
    private WebElement accountsBar;

    @FindBy(xpath = "//div[@class='sections'] //a[contains(text(),'accounts')]")
    private WebElement accountTab;

    @FindBy(xpath = "//div[@class='sections'] //a[contains(text(),'profile')]")
    private WebElement profileTab;

    @FindBy(xpath = "//div[@class='sections'] //a[contains(text(),'notifications')]")
    private WebElement notificationTab;

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
        accountTab.click();
    }

    /**
     * Clicks in profile menu nameTab.
     */
    private void clickProfileTabOption() {
        profileTab.click();
    }

    /**
     * Clicks in notification menu nameTab.
     */
    private void clickNotificationTabOption() {
        notificationTab.click();
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
