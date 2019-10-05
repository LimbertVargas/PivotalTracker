Feature: Invite members to project.

  Background: Login as Regular User
    Given I go to the Login Page of Pivotal Tracker
    When I fill the field with credentials from user "Regular User1"


  @CreateProjectAPI
  Scenario: Invite people as viewer to project from mail.
    When I go to the invite Page of the project.
      And the user insert the invited list mails
