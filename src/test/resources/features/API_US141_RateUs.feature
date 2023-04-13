Feature: API_US_141 As a user, I should be able to create rate us info.

  Scenario: TC_001 I should be able to create rate us info with full data. Positive
    Given user connects to the "/dashboard/rateUs" api with body, POST
      | rate | feedback | userEmail     | fullname |
      | 5    | good     | exe@gmail.com | Ali Veli |
    
    Then user verifies the status code of the response is "200"

