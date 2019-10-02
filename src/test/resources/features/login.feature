Feature: Login with a valid create parameters

  Scenario: Login
    Given I go to the Login Page
    When I fill the field with credentials from user "Regular User1"
    Then I verify the user name will be shown on the top bar
