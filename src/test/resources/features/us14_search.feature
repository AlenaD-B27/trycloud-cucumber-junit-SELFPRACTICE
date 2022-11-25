@regression
Feature:  As a user, I should be able to search any item/ users from the homepage.
  @us_14
  Scenario: Verify users can search any files/folder/users from the search box.
    Given "user10" on the dashboard page
    When the user clicks the magnifier icon on the right top
    And users search any existing file,folder or user name
    Then verify the app displays the expected search result option