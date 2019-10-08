/*
 * @(#) MembersPage.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package pivotaltracker.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;

/**
 * MembersPage class.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class MembersPage extends BasePage {

    @FindBy(id = "invite-people-button")
    private WebElement inviteButton;

    @FindBy(css = "li.MembershipItem--inactive div.MembershipItem__Email")
    private WebElement invitedMail;

    @FindBy(css = "li.MembershipItem--inactive div.MembershipItem__Status")
    private WebElement invitedStatus;

    @FindBy(css = "li.MembershipItem--inactive div.MembershipItem__Role")
    private WebElement invitedRole;

    @FindBy(css = "li.MembershipItem--inactive button")
    private WebElement actionsButton;

    @FindBy(css = "button[data-aid=remove-from-project]")
    private WebElement removeButton;

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(inviteButton));
    }

    /**
     * Gives invitedMail web element.
     *
     * @return  invitedMail - web element.
     */
    public WebElement getInvitedMail() {
        return invitedMail;
    }

    /**
     * Gives invitedStatus web element.
     *
     * @return  invitedStatus - web element.
     */
    public WebElement getInvitedStatus() {
        return invitedStatus;
    }

    /**
     * Given invitedRole web element.
     *
     * @return  invitedRole - web element.
     */
    public WebElement getInvitedRole() {
        return invitedRole;
    }

    /**
     * Click on actions button web element.
     */
    public void clickActionsButton() {
       actionsButton.click();
    }

    /**
     * Click on remove for project button web element.
     */
    public void clickRemoveButton() {
        removeButton.click();
    }

    /**
     * Click on invite for project button web element.
     */
    public void clickInviteButton() {
        inviteButton.click();
    }

    /**
     * Click on actions and then on delete invitation for hook.
     */
    public void deleteInvitation() {
        actionsButton.click();
        wait.until(ExpectedConditions.visibilityOf(removeButton));
        removeButton.click();
        wait.until(ExpectedConditions.invisibilityOf(invitedMail));
    }
}
