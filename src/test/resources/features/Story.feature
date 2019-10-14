Feature: Manage stories

  Background:
    Given I had created a project with the following data
      | name | ProjectTestDemo |
    Given I Login of pivotal tracker with the crendentials from user "Regular User1"

  @DeleteProjectAPI @John
  Scenario: complete flow of a story of Pivotal Tracker
    When I go to the Story page
    And I create a story on Backlog with following characteristics
      | Story name | Metadata |
      | Story Type | feature  |
      | Points     | 3        |
      | Labels     | test     |
    Then I should see the story on backlog panel
    When I start the story
    Then I should see that the story can be finished
    When I finish the story
    Then I should see that the story can be deliver
    When I deliver the story
    Then I should see that the story can be accept o reject
    When I accept the sory
    Then I should see the story was Accepted
