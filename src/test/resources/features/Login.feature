Feature: Login with a valid create parameters

  @logOut
  Scenario: Login of Pivotal Tracker
    Given I go to the Login Page
    When I fill the field with credentials from user "Regular User1"
    Then I verify the user name will be shown on the top bar
