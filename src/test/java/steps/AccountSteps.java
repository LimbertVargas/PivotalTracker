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
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import pivotaltracker.entities.Account;
import pivotaltracker.entities.Context;

/**
 * AccountSteps class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountSteps {
    private Account account;
    private Context context;
    private Logger logs = Log.getInstance().getLog();

    /**
     * Constructor of account steps sending the context.
     *
     * @param context init the context.
     */
    public AccountSteps(Context context) {
        this.context = context;
        this.account = context.getAccount();
    }

    @When("^I create a new account \"(.*)\" in Pivotal Tracker$")
    public void createANewAccountInPivotalTracker(final String nameAccount) {
        logs.info("Create a new account " + nameAccount + " in Pivotal Tracker");
        account.setNameAccount(nameAccount);
    }

}