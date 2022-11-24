Feature:  As a user, I should be able to update settings.


Scenario: Verify users update settings
    Given "user40" on the dashboard page
    When the user clicks the "Files" module
And user clicks Settings on the left bottom corner
Then the user should be able to click any buttons


  @us_10
Scenario: Verify users to see the app storage usage
  Given "user99" on the dashboard page
When the user clicks the "Files" module
And user checks the current storage usage
    When the user clicks the add icon on the top
  And users uploads file with the "upload file" option
And user refresh the page
Then the user should be able to see storage usage is increased