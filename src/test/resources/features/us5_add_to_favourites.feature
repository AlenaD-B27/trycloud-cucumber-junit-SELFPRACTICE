@regression
Feature: As a user, I should be able to access to Files module - Favorites button

  @us_5
  Scenario Outline: Verify users to add files to Favorites

    Given "<user>" on the dashboard page
    When the user clicks the "Files" module
    When the user clicks action-icon  from any file on the page to add to favourites
    And user choose the "Add to favorites" option
    And user click the "Favorites" sub-module on the left side
    Then Verify the chosen file is listed on the table

    Examples: usernames:
      |user|
      |User10  |
      |User40  |
      |User70  |
      |User100 |
