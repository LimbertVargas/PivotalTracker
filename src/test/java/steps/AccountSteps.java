/*
 * @(#) AccountSteps.java Copyright (c) 2019 Jala Foundation.
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

import core.utils.Log;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import pivotaltracker.entities.Account;
import pivotaltracker.entities.Context;
import pivotaltracker.ui.pages.account.AccountSettingsPage;
import pivotaltracker.ui.pages.user.AccountPage;
import pivotaltracker.ui.pages.account.AccountPlansPage;
import pivotaltracker.ui.pages.account.CreateAccountPopup;

import static org.testng.AssertJUnit.assertEquals;

/**
 * AccountSteps class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountSteps {
    private Logger logs = Log.getInstance().getLog();
    private Account account;
    private Context context;
    private AccountPage accountPage;
    private CreateAccountPopup createAccountPopup;
    private AccountPlansPage accountPlansPage;
    private AccountSettingsPage accountSettingsPage;

    /**
     * Constructor of account steps sending the context.
     *
     * @param context init the context.
     */
    public AccountSteps(final Context context) {
        this.context = context;
        this.account = context.getAccount();
    }

    /**
     * Creates a new account sending the information.
     *
     * @param nameAccount contains the account values.
     */
    @When("I create a new account \"(.*)\"")
    public void createANewAccountInPivotalTracker(final String nameAccount) {
        logs.info("Create a new account " + nameAccount + " in Pivotal Tracker");
        accountPage = new AccountPage();
        createAccountPopup = accountPage.clickNewAccountCreateBtn();
        accountPlansPage = createAccountPopup.createNewAccount(nameAccount);
        account.setNameAccount(nameAccount);
        account.setId(accountPlansPage.getId());
    }

    /**
     * Verifies name of account in accounts plans page.
     */
    @Then("I should see the new account in Account Plans Page")
    public void verifyTheNewAccountPage() {
        logs.info("The Account Page is tested if it owns to the account created");
        assertEquals(accountPlansPage.getAccountMenu().getNameAccount(), account.getNameAccount());
    }

    /**
     * Verifies name of account in account page.
     */
    @Then("I should see the new account in list of Accounts page")
    public void displayTheNewAccountInTheAccountsPage() {
        logs.info("The Account Page is tested if show in the account page");
        assertEquals(accountPage.isDisplayedNewAccount(account.getNameAccount()),
                account.getNameAccount().toUpperCase());
    }

    /**
     * Updates  a new account sending the information.
     *
     * @param nameAccount of type string.
     */
    @And("I update the account Name with {string}")
    public void updateTheAccountNameWith(final String nameAccount) {
        logs.info("Update the name of " + account.getNameAccount() + " to: " + nameAccount);
        accountSettingsPage.setNameAccount(nameAccount);
        account.setNameAccount(nameAccount);
    }

    /**
     * Verifies name of account in accounts settings page.
     */
    @Then("I should see the new name in account settings page")
    public void displayTheNewNameInAccountSettingsPage() {
        assertEquals(accountSettingsPage.getNameAccount(), account.getNameAccount());
    }
}
