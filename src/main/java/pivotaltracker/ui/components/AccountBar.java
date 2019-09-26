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
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.ui.pages.account.AccountBasePage;

/**
 * AccountBar class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountBar extends AccountBasePage {

    @FindBy(css = "div[class='content clearfix']")
    private WebElement accountForm;

    @FindBy(css = "h2[class='account_name'] span")
    private WebElement nameAccountTxt;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountForm));
    }

    public String getNameAccount() {
        return nameAccountTxt.getText();
    }
}
