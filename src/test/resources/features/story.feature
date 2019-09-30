Feature: Manage stories

  @Login @CreateProject
  Scenario: complete flow of a story
    When I go the Story Page of Pivotal Tracker
    And I create a story on Backlog with following characteristics
      | Story name | Metadata |
      | Story Type | Feature  |
      | Points     | 3        |
      | Labels     | test     |
    And I finish and deliver the story
    Then I should see the story on Accepted Stories on Current Iteration panel
