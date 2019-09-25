Feature: Manage Project

  Scenario: Create project
    When I go to the Dashboard Page of Pivotal Tracker
      And I Create a (project) on Project tab with following data
        | Project Name | Project1             |
        | Account      | Test Mail's Projects |

    Then I should see the project in Project Page.
    When I go to the Dashboard Page of Pivotal Tracker
    Then I should see the project in Dashboard Page.

  Scenario: Create workspace
    When I go to the Dashboard Page of Pivotal Tracker
      And I Create a (workspace) on Workspaces tab with following data
        | Workspace Name | Workspace1 |

    Then I should see the workspace in Workspace Page.
    When I go to the Dashboard Page of Pivotal Tracker
    Then I should see the workspace in Dashboard Page.