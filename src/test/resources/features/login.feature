Feature: Login with a valid create parameters

  Scenario: Login
    Given I visit the Login Page of Pivotal Tracker
    When I fill the field with credentials from user "Regular User1"
    Then I verify the user name will be shown on the top bar
