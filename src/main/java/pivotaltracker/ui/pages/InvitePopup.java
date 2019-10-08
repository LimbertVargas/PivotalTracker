/*
 * @(#) InvitePopup.java Copyright (c) 2019 Jala Foundation.
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

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pivotaltracker.BasePage;

/**
 * InvitePopup class.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class InvitePopup extends BasePage {

    @FindBy(id = "invite-modal-search-bar")
    private WebElement inviteField;

    @FindBy(css = "footer button[id^='invite']")
    private WebElement inviteButton;

    @FindBy(id = "invite-search-results")
    private WebElement inviteResults;

    @FindBy(id = "button.SelectBox__button")
    private WebElement inviteRole;

    @FindBy(id = "ul.SelectBox__options li:first-child")
    private WebElement viewerRoleButton;


    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(inviteButton));
    }

    public void fillInviteForm(final String mail) {
        inviteField.sendKeys(mail);
        wait.until(ExpectedConditions.visibilityOf(inviteResults));
        inviteField.sendKeys(Keys.RETURN);
    }

    /**
     * Click on invite button web element.
     */
    public void clickInviteButton() {
        waitUntilPageObjectIsLoaded();
        inviteButton.click();
    }

    public void setRoles() {
        inviteRole.click();
        viewerRoleButton.click();
        clickInviteButton();
    }
}
