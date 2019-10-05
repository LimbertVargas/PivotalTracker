#Feature: Manage Account
#  Background:
#    Given I go to the Login Page
#    When I fill the field with credentials from user "Regular User1"
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
