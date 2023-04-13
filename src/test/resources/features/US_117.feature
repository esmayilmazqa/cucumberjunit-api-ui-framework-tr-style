Feature: As a user, I should be able to perform various actions on the Settings(Refund Rescheduling Settings) page.

  Background: User as a Therapist navigates to calendar-settings page
    Given the user navigates to "/"
    When the user click on login button on the homepage
    And the user types "therapistEmail" to Email Input on login page
    And the user types "therapistPassword" to Password Input on login page
    And the user clicks on Login button on login page
    Then the user verifies if the relevant page opens "/dashboard/calendar"
    When the user accepts the cookie
    When the user clicks on "Settings" button on Scheduling menu

    Given the user verifies if the relevant page opens "/dashboard/settings"
    When the user clicks on the "Refund Rescheduling Settings" button


  Scenario: TC_001 The user should be able to control various elements are visible
    Then the user verifies if "Refund" is visible
    Then the user verifies if "Rescheduling" is visible
    Then the user verifies Cancel an Appointment button is visible
    When the user clicks on Logout button

  Scenario: TC_002 The user should be able to controls various elements are functional
    When the user clicks on Cancel an Appointment button
    Then the user verifies if Cancellation dropdowns are visible
    Then the user verifies if Default value of dropdowns are correct
    Then the user verifies if Up down buttons of Cancellation dropdowns are functional
    Then the user verifies if necessary symbol is display
    When the user clicks on Save button on Refund Section
    Then the user verifies if "Settings saved." message is display


#The numbers in the Cancellation Hours Limit dropdown menu should be changed with the help of the button
#Numbers and slices (%,$) in the Cancellation Hours Limit dropdown menu should be able to change with the help of the button
#After the necessary operations, the Save button should be able to click
#When the user click to Save button , the Settings Saved message should appear