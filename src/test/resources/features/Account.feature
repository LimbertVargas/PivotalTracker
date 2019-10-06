Feature: Manage Account
  Background:
    Given I go to the Login Page
    When I fill the field with credentials from user "Regular User1"
    Then I verify the user name will be shown on the top bar

  @deleteAccount @logOut
  Scenario: Create a new account in Pivotal Tracker
    When I go to the Account Page
      And I create a new account "New Account1"
    Then I should see the new account in Account Plans Page
    When I go to the Account Page
    Then I should see the new account in list of Accounts page
    When I go to the Dashboard Page
    Then I should see the new account in the Project Creation Popup

  @deleteAccount @logOut
  Scenario: Configure the account name of an account created
    When I go to the Account Page
      And I create a new account "Test Account2"
    Then I should see the new account in Account Plans Page
    When I go to the Settings tab inside Account page
      And I update the account Name with "Other Name"
    Then I should see the new name in account settings page
    When I go to the Account Page
    Then I should see the new account in list of Accounts page
    When I go to the Dashboard Page
    Then I should see the new account in the Project Creation Popup

  @deleteAccount @logOut
  Scenario Outline: Add member to the account of Pivotal Tracker with permission of Project Creator
    When I go to the Account Page
      And I create a new account "New Account3"
    Then I should see the new account in Account Plans Page
    When I go to the Members tab inside Account page
      And I add a Member "<nameMember>", "<memberEmail>" to the account and assign "<role>" with permission of project creator
    Then I should see message of confirmation "Invitation to <nameMember> sent" in the Member Page of Account
      And I should see the member that was added in the table of the Member Page of Account
    Examples:
      |nameMember   |memberEmail	         |role   |
      |user member  |user.test1@hotmail.com  |Member |
      |owner member |owner.test2@gmail.com   |Admin  |
      |admin member |admin.test3@outlook.com |Owner  |
