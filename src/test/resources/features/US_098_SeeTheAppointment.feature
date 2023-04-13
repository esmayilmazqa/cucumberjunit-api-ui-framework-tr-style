Feature: US_098 As a user, I should be able to see the appointment I created on Calendar.

  Background: User as a Therapist navigates to calendar-settings page
    Given the user navigates to "/"
    When the user click on login button on the homepage
    And the user types "therapistEmail" to Email Input on login page
    And the user types "therapistPassword" to Password Input on login page
    And the user clicks on Login button on login page
    And the user accepts the cookie

  Scenario: TC_001
    Given the user is on "/dashboard/calendar" page
    When the user clicks on any appointment on the calendar
    Then the user verifies if Meet Info field appears
    Then the user verifies if "Google" button is clickable
    When the user clicks on "Google" button to see on Calendar
    Then the user verifies if "Google" calendar page opens
    Then the user verifies if "Outlook" button is clickable
    When the user clicks on "Outlook" button to see on Calendar
    Then the user verifies if "Outlook" calendar page opens
    Then the user verifies Mark as options are functional
    Then the user verifies if the info of Meeting is correct
    Then the user verifies if "Go to Meeting" button is clickable
    When the user clicks on Meeting Url button
    Then the user verifies if Meeting screen opens












