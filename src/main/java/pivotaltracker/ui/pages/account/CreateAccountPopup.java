/*
 * @(#) CreateAccountPopup.java Copyright (c) 2019 Jala Foundation.
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

import core.utils.Log;
import core.utils.PivotalTrackerUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;

/**
 * CreateAccountPopup class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class CreateAccountPopup extends BasePage {
    @FindBy(className = "tc_modal_content")
    private WebElement createAccountPopup;

    @FindBy(css = "input[class='tc-form__input']")
    private WebElement nameAccountTxt;

    @FindBy(css = "footer [class='zWDds__Button pvXpn__Button--positive']")
    private WebElement createAccountBtn;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        Log.getInstance().getLog().info("Wait for Create Account Popup upload in the Browser");
        wait.until(ExpectedConditions.visibilityOf(createAccountPopup));
    }

    public AccountPlansPage createNewAccount(final String accountName) {
        Log.getInstance().getLog().info("Create a New Account setting " + accountName + " in the Name Account Text");
        setAccountName(accountName);
        Log.getInstance().getLog().info("Click to the Create Project Button");
        clickCreateAccountBtn();
        return new AccountPlansPage();
    }

    private void setAccountName(final String accountName) {
        PivotalTrackerUtils.setText(nameAccountTxt, accountName);
    }

    private void clickCreateAccountBtn() {
        createAccountBtn.click();
    }
}
