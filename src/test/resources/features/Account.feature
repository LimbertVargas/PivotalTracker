Feature: Manage Account
  Background:
    Given I go the Login Page of Pivotal Tracker
    When I fill the field with credentials from user "Regular User1"

@deleteAccount
  Scenario: Create a new account in Pivotal Tracker
    Given I go the Account Page of Pivotal Tracker
    When I create a new account "New Account" in Pivotal Tracker
    Then I should see the new Account Page
    When I navigate to Account page
    Then I should see the new account in the Accounts page
    When I navigate to Dashboard page
    Then I should see the new account in the Project Creation popup

  @deleteAccount
  Scenario: Configure the account name of an account created
    Given I go the Account Page of Pivotal Tracker
    When I create a new account "New Account" in Pivotal Tracker
    And I update the account Name with "Change Name"
    Then I should see the new account page
    When I navigate to Account page
    Then I should see the new account in the Accounts page

    @deleteAccount
  Scenario Outline: Add member to the account of Pivotal Tracker with permission of Project Creator
    Given I go the Account Page of Pivotal Tracker
    When I create a new account "New Account" in Pivotal Tracker
      And I add a Member "<nameMember>", "<memberEmail>" to the account and assign a Account Role "<role>" with permission of project creator
    Then I should see message of confirmation "Updated member '<nameMember>'" in the Membership Page of Account
      And I should see the member that was added in the table of the Membership Page of Account
    Examples:
      |nameMember |memberEmail	           |role   |
      |User1      |usuario.test1@gmail.com |Member |
      |User2      |usuario.test2@gmail.com |Admin  |
      |User3      |usuario.test2@gmail.com |Owner  |