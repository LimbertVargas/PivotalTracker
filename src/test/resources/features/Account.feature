Feature: Manage Account
  Background:
    Given I go to the Login Page of Pivotal Tracker
    When I fill the field with credentials from user "Regular User1"

  @deleteAccount
  Scenario: Create a new account in Pivotal Tracker
    When I go to the Account Page of Pivotal Tracker
      And I create a new account "New Account" in Pivotal Tracker
    Then I should see the new Account Page
    When I go to the Account Page of Pivotal Tracker
    Then I should see the new account in list of Accounts page
