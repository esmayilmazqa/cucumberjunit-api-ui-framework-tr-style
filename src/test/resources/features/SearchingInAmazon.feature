Feature: US_Searching In Amazon
  @amazonarama
  Scenario: TC01_User searches a product in Amazon
    Given user lands on Amazon
    When user types iphone on search textbox
    # Below statement doesnt appropriate please write it again
    Then user prints the  result of products number to console