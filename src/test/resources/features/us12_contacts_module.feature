@regression
Feature: As a user, I should be able to access to Contacts module.

  @us_12
  Scenario:  verify user access to Talks module
    Given "user10" on the dashboard page
    When the user clicks the "Contacts" module
    Then verify the page title is "Contacts - Trycloud"