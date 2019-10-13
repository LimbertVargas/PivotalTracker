Feature: Manage stories

  Background:
    Given I had created a project with the following data
      | name | ProjectTestDemo |
    Given I Login of pivotal tracker with the crendentials from user "Regular User1"

  @DeleteProjectAPI
  Scenario: complete flow of a story of Pivotal Tracker
    When I go to the Story page
    And I create a story on Backlog with following characteristics
      | Story name | Metadata |
      | Story Type | feature  |
      | Points     | 3        |
      | Labels     | test     |
    And I finish and deliver the story
    Then I should see the story on Accepted Stories on Current Iteration panel
