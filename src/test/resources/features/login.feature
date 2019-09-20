Feature: Login with a valid create parameters
  Scenario: Login
    Given I visit the "login" page of Pivotal Tracker
    When I fill the field with credentials from user "TESTLIMBERT"
    Then To verify the user the "username" will be shown