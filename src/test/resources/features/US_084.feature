@hadi
Feature: US_084 As a user, I should be able to perform various actions in the Scheduling(Settings) Page

  Background: User as a Therapist navigates to calendar-settings page
    Given the user navigates to "/"
    When the user click on login button on the homepage
    And the user types "therapistEmail" to Email Input on login page
    And the user types "therapistPassword" to Password Input on login page
    And the user clicks on Login button on login page
    Then the user verifies if the relevant page opens "/dashboard/calendar"
    When the user accepts the cookie
    When the user clicks on "Scheduling" button on Scheduling menu
    # Settings button locator : //a[contains(@href,'/calendar/settings')]
    And the user clicks on "Settings" button on Scheduling menu
    Then the user verifies if the relevant page opens "/dashboard/calendar/settings"

@aaaaa
  Scenario: TC_001 The user should be able to seen various controls on Scheduling Setting Section

    Then the user verifies Flexible Time Button is clickable
    Then the user verifies if Customize your url button is clickable
    Then the user verifies if Add Block Time, Save, Off Day buttons are clickable


  Scenario: TC_002 The user should be able to add, update and delete block time in Add Block Time section

    And the user clicks on Add Block Time button
    Then the user verifies if Day title, Add button and start-end times controls are visible
    When the user selects the start and end time
    And the user clicks on Add button on Add Block Time popup section
    Then the user verifies if Blocked Times section display under the section
    Then the user verifies if Update and Delete buttons are there
    When the user clicks on Update button
    Then the user verifies if the new Update button exists in new popup section
    When the user clicks on Delete button
    Then the user verifies if "Block Time is deleted"  message display

  @s3
  Scenario: TC_003 Controls other section
    When the user clicks on Off Day button
  # burada color change olayından ziyade disable olup olmadığı durumu var:
    Then the user verifies if the color of time section changes
    Then the user verifies if Off Day option is selected
    When the user clicks on Customize your url
    Then the user verifies Upgrade Now popup is visible
    Then the user verifies "Show All Subscription Plans" button is clickable on popup
    Then the user verifies "Cancel" button is clickable on popup
    And the user clicks on "Cancel" button on popup
    Then the user verifies Upgrade Now popup ıs unvisible
    When the user clicks on Customize your url
    Then the user verifies Upgrade Now popup is visible
    And the user clicks on "Show All Subscription Plans" button on popup
    Then the user verifies if Subscription page appears



  # Bu user story abonelik olmaması durumuna gore calıstıgından voice ile alakalı user storylerden
  # dolayı çakılacaktır.
















