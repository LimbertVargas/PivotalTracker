Feature: Manage Account
  Background:
    Given I go to the Login Page
    When I fill the field with credentials from user "Regular User1"

  @deleteAccount
  Scenario: Create a new account in Pivotal Tracker
    When I go to the Account Page
      And I create a new account "New Account"
    Then I should see the new Account Page
    When I go to the Account Page of Pivotal Tracker
    Then I should see the new account in list of Accounts page
    When I go to the Dashboard Page
    Then I should see the new account in the Project Creation Popup

  @deleteAccount
  Scenario: Configure the account name of an account created
    When I go to the Account Page
      And I create a new account "Test Account"
    Then I should see the new Account Page
    When I go to the Settings tab inside Account page
      And I update the account Name with "Other Name"
    Then I should see the new name in account settings page
    When I go to the Account Page
    Then I should see the new account in list of Accounts page
#
#  @deleteAccount
#  Scenario Outline: Add member to the account of Pivotal Tracker with permission of Project Creator
#    When I go to the Account Page
#    And I create a new account "New Account"
#    And I add a Member "<nameMember>", "<memberEmail>" to the account and assign "<role>" with permission of project creator
#    Then I should see message of confirmation "Updated member '<nameMember>'" in the Member Page of Account
#    And I should see the member that was added in the table of the Member Page of Account
#    Examples:
#      |nameMember |memberEmail	           |role   |
#      |User1      |usuario.test1@gmail.com |Member |
#      |User2      |usuario.test2@gmail.com |Admin  |
#      |User3      |usuario.test2@gmail.com |Owner  |
