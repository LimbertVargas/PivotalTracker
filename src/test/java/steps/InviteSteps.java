/*
 * @(#) InviteSteps.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pivotaltracker.PageTransporter;
import pivotaltracker.entities.Context;
import pivotaltracker.entities.Invitation;
import pivotaltracker.ui.Permalink;
import pivotaltracker.ui.pages.InvitePopup;
import pivotaltracker.ui.pages.MembersPage;

import java.util.Map;

/**
 * InviteSteps class.
 *
 * @author Andres Burgos
 * @version 1.0
 */
public class InviteSteps {

    private Context context;
    private MembersPage membersPage;
    private InvitePopup invitePopup;
    private final int ID = 2402093; // This hardcode will be replaced with John's ProjectAPI with context manage.

    /**
     * Goes to the members page.
     */
    @When("I go to the invite Page of the project.")
    public void iGoToTheInvitePageOfTheProject() {
        PageTransporter.navigatePageById("/projects", ID, Permalink.MEMBERSHIPS_PAGE);
    }

    /**
     * Fill the invite form with the parameter mail.
     * @param mail - invited mail.
     */
    @When("the user insert the invited mail \"(.*)\"$")
    public void theUserInsertTheInvitedListMails(final String mail) {
        membersPage = new MembersPage();
        membersPage.clickInviteButton();
        invitePopup = new InvitePopup();
        invitePopup.fillInviteForm(mail);
    }

    /**
     * Set the role for invited.
     */
    @When("the user sets the invitations type as member")
    public void theUserSetsTheInvitationsTypeAsViewer() {
        invitePopup.clickInviteButton();
    }

    /**
     * Verifies that the invitation was registered and its pending.
     */
    @Then("the mail should be displayed with Invitation pending status")
    public void theMailsListShouldBeDisplayedWithInvitationPending() {
        Assert.assertEquals(membersPage.getInvitedStatus().getText(), Invitation.PENDING_STATUS);
    }

    /**
     * Verifies that the invitation has the Member tag type invitation.
     */
    @Then("the mail should be displayed with Member tag")
    public void theMailsListShouldBeDisplayedWithViewerTag() {
        Assert.assertEquals(membersPage.getInvitedRole().getText(), Invitation.MEMBER);
    }
}
