
Feature: As a user, I should be able to remove files from favorites and upload a file directly

Scenario Outline: verify users to remove files to Favorites
Given "<user>" on the dashboard page
When the user clicks the "Files" module
When the users click action-icon from any file on the page to remove
And  user choose the "Remove from favorites" option
And user click the "Favorites" sub-module on the left side
Then Verify that the file is removed from the Favorites sub-module’s table

  Examples: usernames:
    |user|
    |User10  |
    |User40  |
    |User70  |
    |User100 |

  @us_6
Scenario: verify users to upload a file from Files
Given "user70" on the dashboard page
When the user clicks the "Files" module
When the user clicks the add icon on the top
And users uploads file with the "upload file" option
Then verify "the file" is displayed on the page

