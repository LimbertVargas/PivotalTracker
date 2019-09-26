/*
 * @(#) AccountBasePage.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.ui.pages.account;

import pivotaltracker.ui.components.AccountBar;

/**
 * AccountBasePage class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public abstract class AccountBasePage extends AccountPage {

    private AccountBar accountBar;

    public AccountBasePage() {
        super();
        accountBar = new AccountBar();
    }

    public AccountBar getAccountBar() {
        return accountBar;
    }
}
