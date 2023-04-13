Feature: API_US124_AddNewIndividualSession As a user, I should be able to add new individual session.

  Scenario: TC_001 As a user, I should be able to add new individual session. Positive
    Given user connects to the "/settings/meeting/category/add" api with body, POST
      | title    | price | showPrice | duration | blockBefore | blockAfter | paymentRequired | bookable | description      |
      | John Doe | 500   | 1         | 120      | 10          | 10         | 0               | 0        | John Doe meeting |

    Then user verifies the status code of the response is "200"
    Then user verifies the api response has mandatory fields, only one json
      | success  |
      | category |
    Then user verifies some values of the api response are true, only one json
      | success | category.title |
      | true    | John Doe       |

 # aynı title da session oluşturamasın
  Scenario: TC_002 As a user, I should not be able to add new individual session. Negative 1
    Given user connects to the "/settings/meeting/category/add" api with body, POST
      | title    | price | showPrice | duration | blockBefore | blockAfter | paymentRequired | bookable | description      |
      | John Doe | 500   | 1         | 120      | 10          | 10         | 0               | 0        | John Doe meeting |

    Then user verifies the status code of the response is "200"
    Then user verifies the api response has mandatory fields, only one json
      | success  |
      | category |
    Then user verifies some values of the api response are true, only one json
      | success | category.title |
      | false   | John Doe       |

# hem scenario autline hem datatable --sanat eseri
  Scenario Outline: TC_003 As a user, I should not be able to add new individual session with missing mandatory fields. Negative 2
    Given user connects to the "/settings/meeting/category/add" api with body missing fields "<field>", POST
      | title    | price | showPrice | duration | blockBefore | blockAfter | paymentRequired | bookable | description      |
      | John Doe | 500   | 1         | 120      | 10          | 10         | 0               | 0        | John Doe meeting |
    Then user verifies the status code of the response is "200"
    Then user verifies the api response has mandatory fields, only one json
      | success |
      | descr   |
    Then user verifies some values of the api response are true, only one json
      | success |
      | false   |
    Examples:
      | field    |
      | title    |
      | duration |



    #{
    #    "success": false,
    #    "descr": "Title is required"
    #}