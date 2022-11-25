@regression
Feature: As a user, I should be able to add a folder
  @us_7
  Scenario: Verify users can add the folder
    Given "user70" on the dashboard page
    When the user clicks the "Files" module
    When the user clicks the add icon on the top
    And user click "new folder"
    And user write a folder name
    When the user click submit icon
    Then Verify the folder is displayed on the page

  @us_7
  Scenario:  Verify users can upload a file inside a folder
    Given "user70" on the dashboard page
    When the user clicks the "Files" module
    And user choose a folder from the page
    When the user clicks the add icon on the top
    And users uploads file with the "upload file" option
    Then verify "the file" is displayed on the page