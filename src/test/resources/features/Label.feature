#Feature: Manage Account
#  Background:
#    Given I go to the Login Page
#    When I fill the field with credentials from user "Regular User1"
#
#  @CreateStory @deleteAccount
#  Scenario: Create a new account in Pivotal Tracker
#  When I go to the Account Page
#    And I create a new account "New Account"
#  Then I should see the new Account Page
#  When I go to the Account Page of Pivotal Tracker
#  Then I should see the new account in list of Accounts page
#  When I go to the Dashboard Page
#  Then I should see the new account in the Project Creation popup
#
#  @CreateStory
#  Scenario: Delete a story and recover those in Pivotal Tracker
#    When I go to the Project Page
#      And I delete a Story in "Icebox" Panel
#    Then I shouldn't see the story deleted
#    When I go to the Recover Stories Page
#      And I selected the story deleted
#    Then a message appear indicating the story was Recovered successfully
#      And I shouldn't see the story in Recover Stories
#    When I go to the Project Page
#    Then I should see the Story recovered in "Icebox" Panel
#
#  @CreateStory
#  Scenario: Show Stories with same label
#    When I go to the Project Page
#    And I delete a Story in "Icebox" Panel
#
#
#  Scenario Outline: Search job by keyword with maximum and minimum characters in trabajopolis
#    When A user unregistered navigate in search page
#      And The user searches with <keyword>
#    Then The user sees the result of the search in result search page
#    Examples:
#      | keyword                                        |
#      | tres tristes tigres trigo trigaban en un trigal|
#      | Cx                                             |
#
#  Scenario Outline: Search job without characters in trabajopolis
#    When A user unregistered navigate in search page
#      And The user searches with <keyword>
#    Then a message indicates that something must be typed in the search
#      And The user does not see the search result on the search results page
#    Examples:
#      | keyword|
#      | null   |
#      |        |
