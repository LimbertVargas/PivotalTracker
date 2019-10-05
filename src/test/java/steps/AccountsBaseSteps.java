/*
 * @(#) AccountsBaseSteps.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package steps;

import cucumber.api.java.en.When;
import pivotaltracker.ui.pages.account.AccountBasePage;
import pivotaltracker.ui.pages.account.AccountPlansPage;
import pivotaltracker.ui.pages.account.AccountSettingsPage;

/**
 * AccountsBaseSteps class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountsBaseSteps {
    private AccountSettingsPage accountSettingsPage;
    private AccountPlansPage accountPlansPage;

    /**
     * Opens page of selected in tab of account.
     */
    @When("^I go to the Settings tab inside Account page$")
    public void goToTheAccountSettingsPage() {
        accountPlansPage = new AccountPlansPage();
        accountSettingsPage = accountPlansPage.getAccountMenu().goToAccountSettingsPage();
    }
}
