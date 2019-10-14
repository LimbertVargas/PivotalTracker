Feature: Manage Dashboard
Background:
  Given I go to the Login Page
  When I fill the field with credentials from user "Regular User1"
  Then I verify the user name will be shown on the top bar

  @Limbert
  Scenario: Create workspace
    When I go to the Dashboard Page
      And I go to the Workspace Tab inside Dashboard page
      And I create a new workspace "Workspace4"
    Then I should see the workspace in Workspace Page
    When I go to the Dashboard Page
      And I go to the Workspace Tab inside Dashboard page
    Then I should see the workspace in Dashboard Page
