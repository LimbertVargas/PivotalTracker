Feature: Login with a valid create parameters
  Scenario: Login
    Given I visit the "login" page of Pivotal Tracker
    When I fill the field "username or email"
      And I fill the field "password"
    Then To verify the user the "username" will be shown