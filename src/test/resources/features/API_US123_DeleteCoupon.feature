Feature: API_US123_DeleteCoupon As a user, I should be able to delete a coupon.
  # var olan id li bir couponu silsin.
  Scenario: TC_001 As a user, I should be able to delete a coupon. Positive
    Given user connects to the "/promoCode/deleteCoupon" api with body, POST
      | couponId |
      | 172      |
    Then user verifies the status code of the response is "200"
    Then user verifies the api response has mandatory fields, only one json
      | success |
    Then user verifies some values of the api response are true, only one json
      | success |
      | true    |


