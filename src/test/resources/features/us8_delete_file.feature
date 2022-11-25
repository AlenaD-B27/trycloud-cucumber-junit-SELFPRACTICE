@regression
Feature: As a user, I should be able to delete a file/folder.
@us_8
  Scenario: Verify users delete a file/folder
    Given "user40" on the dashboard page
    When the user clicks the "Files" module
    When the user clicks action-icon  from any file on the page to delete
    And user choose the "Delete file" option
    And  user click the "Deleted files" sub-module on the left side
    Then verify "the file" is displayed on the page