Feature: Invite

  Scenario: Invite people as viewer to project from mail
    Given: I login as "Regular User 1"
    When: I go to the members Page of Pivotal Tracker
      And I open the invite people option
      And the user insert the invited list mails
        | userdemo1@gmail.com |
        | userdemo2@gmail.com |
        | userdemo3@gmail.com |
      And the user sets the invitation type as viewer
    Then the mails list should be displayed with Invitation pending
    Then the mails list should be displayed with Viewer

