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
import pivotaltracker.ui.pages.account.AccountPlansPage;
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

    @FindBy(xpath = "//a[text()='Plans & Billing']")
    private WebElement plansTabOption;

    @FindBy(xpath = "//a[text()='Settings']")
    private WebElement settingsTabOption;

    @FindBy(xpath = "//a[text()='Projects']")
    private WebElement projectsTabOption;

    @FindBy(xpath = "//a[text()='//a[text()='Account Members']']")
    private WebElement membersTabOption;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameAccountLbl));
    }

    /**
     * Click in plans tab option.
     */
    private void clickPlansTabOption() {
        plansTabOption.click();
    }

    /**
     * Click in settings tab option.
     */
    private void clickSettingsTabOption() {
        settingsTabOption.click();
    }

    /**
     * Click in project tab option.
     */
    private void clickProjectsTabOption() {
        projectsTabOption.click();
    }

    /**
     * Click in member tab option.
     */
    private void clickMembersTabOption() {
        membersTabOption.click();
    }

    /**
     * Gets name Account.
     *
     * @return a string.
     */
    public String getNameAccount() {
        return nameAccountLbl.getText();
    }

    /**
     * Gets of account member Page.
     *
     * @return new account member Page.
     */
    public AccountMemberPage goToAccountMemberPage() {
        clickMembersTabOption();
        return new AccountMemberPage();
    }

    /**
     * Gets of account settings Page.
     *
     * @return new account settings Page.
     */
    public AccountSettingsPage goToAccountSettingsPage() {
        clickSettingsTabOption();
        return new AccountSettingsPage();
    }

    /**
     * Gets of account plans Page.
     *
     * @return new account plans Page.
     */
    public AccountPlansPage goToAccountPlansPage() {
        clickPlansTabOption();
        return new AccountPlansPage();
    }
}
