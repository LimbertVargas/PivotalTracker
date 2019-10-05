/*
 * @(#) CreateProjectPopup.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;

/**
 * CreateProjectPopup class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class CreateProjectPopup extends BasePage {

    @FindBy (className = "tc-account-selector__header")
    private WebElement accountCmb;

    private static final String ACCOUNT_LIST =
            "//div[@class='tc-account-selector__option-account-name'] [text()='listNameAccount']";

    /**
     * Waits until page object is loaded.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountCmb));
    }

    /**
     * Selects account combo box.
     */
    private void clickAccountCmb() {
        accountCmb.click();
    }

    /**
     * Checks name account in combo box.
     *
     * @param nameAccount of type string
     * @return boolean
     */
    public Boolean verifyAccountInList(final String nameAccount) {
        clickAccountCmb();
        return driver.findElement(By.xpath(ACCOUNT_LIST.replace("listNameAccount", nameAccount))).isDisplayed();
    }
}
