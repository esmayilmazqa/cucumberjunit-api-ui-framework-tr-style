#US_121	As a user, I should be able to get coupon list.	Coupon
#		User needs to be logged in to get response.
#		https://test.hypnotes.net/api/promoCode/getCoupons
#		Details on the swagger document.

Feature:  US_121 As a user, I should be able to get coupon list. GET - Coupon

  @sunday
  Scenario: TC_001 As a user, I should be able to get coupon list.Positive
    Given user connects to the "/promoCode/getCoupons" api without body
    Then user verifies the status code of the response is "200"
    Then user verifies the api response has mandatory fields in array
      | id            |
      | code          |
      | startsAt      |
      | endsAt        |
      | numberOfUsers |
      | categories    |
      | discount      |
      | discountType  |

