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

import core.utils.DriverMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * AccountMemberPage class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class AccountMemberPage extends AccountBasePage {
    @FindBy(css = "div[class='content_section']")
    private WebElement accountHeader;

    @FindBy(id = "new_member_button")
    private WebElement newAddMemberBtn;

    @FindBy(id = "members_for_lookup")
    private WebElement nameMemberTxtBox;

    @FindBy(id = "membership_account_role_none")
    private WebElement accountRoleMemberCmbBox;

    @FindBy(id = "notice")
    private WebElement messageConfirmation;

    @FindBy(id = "membership_project_creator")
    private WebElement projectCreatorChk;

    @FindBy(id = "add_member_button")
    private WebElement addMemberBtn;


    @FindBy(id = "person_name")
    private WebElement fullNameMemberTxtBox;

    @FindBy(id = "person_email")
    private WebElement emailMemberTxtBox;

    @FindBy(id = "person_initials")
    private WebElement initialsMemberTxtBox;

    @FindBy(id = "membership_account_role_")
    private WebElement roleMemberCmbBox;

    @FindBy(id = "membership_project_creator_row")
    private WebElement projectCreatorChkBox;

    @FindBy(id = "new_add_member_button")
    private WebElement addNewMemberBtn;


    @FindBy(id = "remove_member_button")
    private WebElement removeMemberBtn;

    @FindBy(id = "remove_member_tab")
    private WebElement removeMemberTab;

    @FindBy(id = "save_roles")
    private WebElement saveRoles;

    private static final String NAME_MEMBER = "//div[@class='name ellipsify'] [contains(text(),'%s')]";
    private static final String EMAIL_MEMBER = "//div[@class='email ellipsify'] [contains(text(),'%s')]";

    /**
     * Waits until page object is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountHeader));
    }

    /**
     * Clicks in new member button.
     */
    private void clickNewMemberBtn() {
        newAddMemberBtn.click();
    }

    /**
     * Clicks in add member button.
     */
    private void clickAddMemberBtn() {
        addMemberBtn.click();
    }

    /**
     * Sets name Member.
     *
     * @param nameMember of type String.
     */
    private void setNameMember(final String nameMember) {
        DriverMethods.setText(nameMemberTxtBox, nameMember);
    }

    /**
     * Sets name Member for option for add new member.
     *
     * @param nameMember of type String.
     */
    private void setFullNameMember(final String nameMember) {
        DriverMethods.setText(fullNameMemberTxtBox, nameMember);
    }

    /**
     * Sets email Member for option for add new member.
     *
     * @param emailMember of type String.
     */
    private void setEmailMember(final String emailMember) {
        DriverMethods.setText(emailMemberTxtBox, emailMember);
    }

    /**
     * Sets for check box initial member.
     *
     * @param isProjectCreator of type boolean.
     * @return boolean
     */
    private boolean setInitialsMember(final boolean isProjectCreator) {
        if (isProjectCreator) {
            projectCreatorChkBox.click();
            return true;
        }
        return false;
    }

    /**
     * Clicks for add new member.
     */
    private void clickAddNewMemberBtn() {
        addNewMemberBtn.click();
    }

    /**
     * Selects account role combo box.
     *
     * @param role of type String.
     */
    private void selectAccountRoleCmb(final String role) {
        clickAccountRoleMember();
        Select selectElement = new Select(accountRoleMemberCmbBox);
        selectElement.selectByValue(role);
    }

    /**
     * clicks account role member.
     */
    private void clickAccountRoleMember() {
        accountRoleMemberCmbBox.click();
    }

    /**
     * Method for add new account member.
     *
     * @param nameMember of type string.
     * @param role of type string.
     */
    public void addAccountMember(final String nameMember, final String role) {
        clickNewMemberBtn();
        setNameMember(nameMember);
        selectAccountRoleCmb(role);
        clickAddMemberBtn();
    }

    /**
     * Method for save data of account member.
     *
     * @param nameMember of type String.
     * @param email of type String.
     * @param isProjectCreator of type boolean.
     */
    public void saveDatOfAccountMember(final String nameMember, final String email, final boolean isProjectCreator) {
        setFullNameMember(nameMember);
        setEmailMember(email);
        setInitialsMember(isProjectCreator);
        clickAddNewMemberBtn();
    }

    /**
     * Gets message of confirmation.
     *
     * @return text of type string.
     */
    public String messageConfirmation() {
        String text = messageConfirmation.getText();
        text = text.substring(0, text.length() - 2);
        return text;
    }

    /**
     * Gets name member in the table.
     *
     * @param nameMember of type String.
     * @return name member.
     */
    public String getNameMember(final String nameMember) {
        return driver.findElement(By.xpath(String.format(NAME_MEMBER, nameMember))).getText();
    }

    /**
     * Gets email member in the table.
     *
     * @param emailMember of type String.
     * @return email member.
     */
    public String getEmailMember(final String emailMember) {
        return driver.findElement(By.xpath(String.format(EMAIL_MEMBER, emailMember))).getText();
    }

    /**
     * Gets data member in the list.
     *
     * @param nameMember of type String.
     * @param emailMember of type String.
     * @return the member's details.
     */
    public String getDataMemberInTheList(final String nameMember, final String emailMember) {
        return getNameMember(nameMember).concat("|")
                .concat("|").concat(getEmailMember(emailMember));
    }
}
