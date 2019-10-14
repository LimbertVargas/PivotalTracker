Feature: Import export project

  Background:
    Given I Login of pivotal tracker with the crendentials from user "Regular User1"

  @DeleteProjectAPI @logOut @John
  Scenario: Import stories from CSV file on Pivotal Tracker
    Given I had created a project with the following data
      | name | ProjectTestDemo |
    When I go to the Import Project page
     And I load the CSV File "ProjectDemo.csv" with stories
    Then a message is shown saying that the stories were Successfully created
    When I go to the Story page
    Then I should see the stories created on the stories
