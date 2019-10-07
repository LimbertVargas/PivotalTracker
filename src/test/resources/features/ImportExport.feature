Feature: Import export project

  Background:
    Given I go to the Login Page
    When I fill the field with credentials from user "Regular User1"

  @CreateProjectAPI @CreateStoryAPI
  Scenario: import story from CSV file  of Pivotal Tracker
    When I go to the Import Project page
    And I load the CSV File with stories
    Then a message is shown indicated that the stories was Successfully created
    When I go to the Story page
    Then I should see the stories created

#  Scenario: Export a story with a CSV file  of Pivotal Tracker
#    When I go to the Export Project Page
#    And I export the stories in a CSV File
#    Then I should see the file in the folder download
