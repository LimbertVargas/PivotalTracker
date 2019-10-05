/*
 * @(#) AccountMemberPage.java Copyright (c) 2019 Jala Foundation.
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

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;

/**
 * AccountMemberPage class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountMemberPage extends BasePage {
    @FindBy(className = "card tabular_data")
    private WebElement accountHeader;

    @FindBy(id = "new_member_button")
    private WebElement newMemberBtn;

    @FindBy(id = "members_for_lookup")
    private WebElement memberForLookupTxt;

    @FindBy(id = "notice")
    private WebElement messageConfirmation;

    @FindBy(id = "membership_project_creator")
    private WebElement projectCreatorChk;

    @FindBy(id = "add_member_button")
    private WebElement addMemberBtn;

    @FindBy(id = "remove_member_button")
    private WebElement removeMemberBtn;

    @FindBy(id = "remove_member_tab")
    private WebElement removeMemberTab;

    @FindBy(id = "save_roles")
    private WebElement saveRoles;

    @FindBy(xpath = "//div[@class=\"actions_overlay removable\"]")
    private WebElement actionMemberForm;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(actionMemberForm));
    }

    /**
     * Clicks in new member button.
     */
    private void clickNewMemberBtn() {
        newMemberBtn.click();
    }

    /**
     * Clicks in add member button.
     */
    private void clickAddMemberBtn() {
        addMemberBtn.click();
    }

    /**
     * Clicks in project creator check.
     */
    private void checkProjectCreatorChk() {
        projectCreatorChk.click();
    }
}
