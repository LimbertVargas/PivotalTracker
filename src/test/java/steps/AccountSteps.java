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
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import pivotaltracker.entities.Account;
import pivotaltracker.entities.Context;
import pivotaltracker.ui.pages.account.AccountPage;
import pivotaltracker.ui.pages.account.AccountPlansPage;
import pivotaltracker.ui.pages.account.CreateAccountPopup;

import static org.testng.Assert.assertTrue;
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

    /**
     * Constructor of account steps sending the context.
     *
     * @param context init the context.
     */
    public AccountSteps(Context context) {
        this.context = context;
        this.account = context.getAccount();
    }

    /**
     * Creates a new account sending the information.
     *
     * @param nameAccount contains the account values.
     */
    @When("^I create a new account \"(.*)\" in Pivotal Tracker$")
    public void createANewAccountInPivotalTracker(final String nameAccount) {
        logs.info("Create a new account " + nameAccount + " in Pivotal Tracker");
        account.setNameAccount(nameAccount);
        accountPage = new AccountPage();
        createAccountPopup = accountPage.clickNewAccountCreateBtn();
        accountPlansPage = createAccountPopup.createNewAccount(nameAccount);
    }

    /**
     * Verify name of account in accounts plans page.
     */
    @Then("I should see the new Account Page")
    public void seeTheNewAccountPage() {
        logs.info("The Account Page is tested if it owns to the account created");
        assertEquals(accountPlansPage.getAccountMenu().getNameAccount(), account.getNameAccount());
    }

    /**
     *
     */
    @Then("I should see the new account in list of Accounts page")
    public void displayTheNewAccountInTheAccountsPage() {
        logs.info("The Account Page is tested if show in the account page");
        assertTrue(accountPage.isDisplayedNewAccount(account.getNameAccount()),"the account Name not displayed");
    }
}
