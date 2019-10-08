Feature: Import export project

  Background:
    Given I go to the Login Page
    When I fill the field with credentials from user "Regular User1"

  @CreateProjectAPI @DeleteProjectAPI @logOut
  Scenario: import story from CSV file  of Pivotal Tracker
    When I go to the Import Project page
    And I load the CSV File "test_20191006_1736.csv" with stories
    Then a message is shown indicated that the stories was Successfully created
    When I go to the Story page
    Then I should see the stories created of the file "test_20191006_1736.csv"

  @CreateProjectAPI @CreateStoryAPI @DeleteProjectAPI @logOut
  Scenario: Export a story with a CSV file  of Pivotal Tracker
    When I go to the Export Project page
    And I export the stories in a CSV File
    Then I should see the file in the folder download
