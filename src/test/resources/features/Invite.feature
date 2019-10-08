Feature: Invite members to project.

  Background: Login as Regular User
    Given I go to the Login Page
    When I fill the field with credentials from user "Regular User1"

  @deleteInvitation
  Scenario: Invite people as viewer to project from mail.
    When I go to the invite Page of the project.
      And the user insert the invited mail "userdemo1@gmail.com"
      And the user sets the invitations type as member
    Then the invited mail "userdemo1@gmail.com" should be displayed in the members list
    And the invited should be displayed with Invitation pending status
    And the invited should be displayed with Member tag
