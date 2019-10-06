Feature: Import export project

  Scenario: import story from CSV file  of Pivotal Tracker
    When I go to the Import Project Page
    And I load the CSV File with stories
    Then a message is shown indicated that the stories was created successfully
    When I go to the Story Page
    Then I should see the stories created

  Scenario: Export a story with a CSV file  of Pivotal Tracker
    When I go to the Export Project Page
    And I export the stories in a CSV File
    Then I should see the file in the folder download