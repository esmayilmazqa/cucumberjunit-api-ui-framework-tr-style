Feature: API_US_122 As a user, I should be able to update a coupon.

  Scenario: TC_001 As a user, I should be able to update a coupon. Positive
    Given user connects to the "/promoCode/update" api with body, POST
      | couponId | promoCode | startedAt                     | enddedAt                      | usersLimit | discountType | discountRate | category |
      | 21        | RASTGELE2 | Thu, 23 Jun 2022 11:28:59 GMT | Sat, 25 Jun 2022 11:29:05 GMT | 50         | percentage   | 50           | 3        |
    Then user verifies the status code of the response is "200"
    Then user verifies the api response has mandatory fields, only one json
      | success   |
      | promoCode |
    Then user verifies some values of the api response are true, only one json
      | success | promoCode.id | promoCode.code |
      | true    | 184          | RASTGELE2      |

# olmayan bir id li coupon u update edelim
  Scenario: TC_002 As a user, I should be able to update a coupon. Negative 1
    Given user connects to the "/promoCode/update" api with body, POST
      | couponId | promoCode | startedAt                     | enddedAt                      | usersLimit | discountType | discountRate | category |
      | 200      | RASTGELE2 | Thu, 23 Jun 2022 11:28:59 GMT | Sat, 25 Jun 2022 11:29:05 GMT | 50         | percentage   | 50           | 3        |
    Then user verifies the status code of the response is "200"
    Then user verifies the api response has mandatory fields, only one json
      | success |
      | descr   |
    Then user verifies some values of the api response are true, only one json
      | success | descr             |
      | false   | Coupoun not found |
  # {
  #    "success": false,
  #    "descr": "Coupoun not found"
  #}

# farklı bir id ye var olan kupon ismi verme
  Scenario: TC_003 As a user, I should be able to update a coupon. Negative 2
    Given user connects to the "/promoCode/update" api with body, POST
      | couponId | promoCode | startedAt                     | enddedAt                      | usersLimit | discountType | discountRate | category |
      | 188       | RASTGELE2 | Thu, 23 Jun 2022 11:28:59 GMT | Sat, 25 Jun 2022 11:29:05 GMT | 50         | percentage   | 50           | 3        |
    Then user verifies the status code of the response is "200"
    Then user verifies the api response has mandatory fields, only one json
      | success |
      | descr   |

    # {
    #    "success": false,
    #    "descr": "Coupon Name : INTERN already in use!"
    #}











