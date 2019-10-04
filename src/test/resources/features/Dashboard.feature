Feature: Manage Project
Background:
  Given I go to the Login Page
  When I fill the field with credentials from user "Regular User1"

  Scenario: Create project
    When I go to the Dashboard Page
      And I Create a Project on Project tab with following data
        | Project Name | Project1             |
        | Account      | Test Mail's Projects |
    Then I should see the project in Project Page.
    When I go to the Dashboard Page
    Then I should see the project in Dashboard Page.

  Scenario: Create workspace
    When I go to the Dashboard Page
      And I create a new workspace "New Workspace"
    Then I should see the workspace in Workspace Page.
    When I go to the Dashboard Page
    Then I should see the workspace in Dashboard Page.

  Scenario: Add project in a workspace page of Pivotal Tracker
    When I go to the Workspace page
      And I Add Project in workspace
    Then I should see the project in Workspace page
    When I go to the Dashboard Page
    Then I should see the project in Workspace Tab