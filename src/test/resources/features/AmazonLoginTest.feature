Feature: User should be login in Amazon website
  @dene
  Scenario: User hits the url Amazon website and tests login page
    Given User hits the Amazon URL
    And User clicks on the Login button
    And User types its username in username textbox
    And User types its password in password textbox
    When User clicks on Submit buttonn
    Then User verifies if success message appears
