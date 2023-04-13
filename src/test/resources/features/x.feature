Feature: US_001 The student should be able to know that how to handle general code

  Background: User as a Therapist navigates to calendar-settings page
    Given the user navigates to "/"
    When the user click on login button on the homepage
    And the user types "therapistEmail" to Email Input on login page
    And the user types "therapistPassword" to Password Input on login page
    And the user clicks on Login button on login page
    Then the user verifies if the relevant page opens "/dashboard/calendar"
    When the user accepts the cookie
    When the user clicks on "Clients" button on Scheduling menu

  Scenario: TC_001 The student as a user should be able to know that how to handle clients in hypnotes
    Given the user is on clients page
    When the user collects all of clients in the page
    Then the user verifies that knows scope limiting concept