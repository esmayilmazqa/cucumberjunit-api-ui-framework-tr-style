Feature: As a user, I should be able to see coupon list in the coupons table.

  Scenario: TC_001
    Given user connects to the database
    Then user verifies the "coupons" table has the columns
      | code    |
      | user_id |
    Then user verifies the codes are unique for same user_id


#I should see codes in te code column.
#The codes should be unique for same user_id.