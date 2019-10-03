Feature: Drag and Drop panel.
Background:
Given:Login to PivotalTracker as "Regular User1"

Scenario: Perform drag and drop to panel "Icebox".
Given I go to the "Project" pages on "stories" tab.
When I drag and drop the panel "Icebox" panel to the first position panel.
Then I should see the panel "Icebox" on the first position.



Background:
  Given:Login to PivotalTracker as "Regular User1"
Scenario: Invite member to the project from name or mail

  Given I go to the "Project" pages on "members" tab.
  When
  Then I should see the panel "Icebox" on the first position.