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
import pivotaltracker.PageTransporter;
import pivotaltracker.entities.Context;
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
    private final int ID = 2402093;

    @When("I go to the invite Page of the project.")
    public void iGoToTheInvitePageOfTheProject() {
        PageTransporter.navigatePageById("/projects", ID, Permalink.MEMBERSHIPS_PAGE);
    }

    @When("the user insert the invited mail \"(.*)\"$")
    public void theUserInsertTheInvitedListMails(final String mail) {
        membersPage = new MembersPage();
        membersPage.clickInviteButton();
        invitePopup = new InvitePopup();
        invitePopup.fillInviteForm(mail);
    }

    @When("the user sets the invitations type as viewer")
    public void theUserSetsTheInvitationsTypeAsViewer() {
        invitePopup.
        invitePopup.clickInviteButton();
    }

    @Then("the mails list should be displayed with Invitation pending")
    public void theMailsListShouldBeDisplayedWithInvitationPending() {
    }

    @Then("the mails list should be displayed with Viewer tag")
    public void theMailsListShouldBeDisplayedWithViewerTag() {
    }
}
