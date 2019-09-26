/*
 * @(#) AccountBar.java Copyright (c) 2019 Jala Foundation.
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
import pivotaltracker.ui.pages.account.AccountBasePage;


/**
 * AccountBar class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountBar extends AccountBasePage {

    @FindBy(className = SELECTED_TAB)
    private WebElement accountsTabs;

    private static final String SELECTED_TAB = "//div[@class='sections'] //a[contains(text(),'%s')]";
}
