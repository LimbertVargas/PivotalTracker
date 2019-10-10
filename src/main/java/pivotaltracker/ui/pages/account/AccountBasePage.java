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

import pivotaltracker.ui.BasePage;
import pivotaltracker.ui.components.AccountMenu;

/**
 * AccountBasePage class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public abstract class AccountBasePage extends BasePage {
    private AccountMenu accountMenu;

    /**
     * Constructor.
     */
    public AccountBasePage() {
        super();
        accountMenu = new AccountMenu();
    }

    /**
     * Gets of account Bar tab.
     *
     * @return account of bar.
     */
    public AccountMenu getAccountMenu() {
        return accountMenu;
    }
}
