Feature: US_086 As a user, I should be able to perform various actions to create an appointment with the Register Services - Register Clients options

  Background: User as a Therapist navigates to calendar-settings page
    Given the user navigates to "/"
    When the user click on login button on the homepage
    And the user types "therapistEmail" to Email Input on login page
    And the user types "therapistPassword" to Password Input on login page
    And the user clicks on Login button on login page


  Scenario: TC_001
    Given the user is on "/dashboard/calendar" page
    When the user accepts the cookie
    Then the user verifies if cell of the current day is in different color
    When the user select today date
    Then the user verifies Book an appoinment section appears
    Then the user verifies if Select Service Type is Registered Services

    When the user clicks on Service dropdown on Registered Services
    Then the user verifies if all items of dropdowm are there and selectable

    When the user clicks on Location dropdown on Registered Services
    Then the user verifies if all items of dropdowm are there and selectable





