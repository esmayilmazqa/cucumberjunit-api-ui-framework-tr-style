Feature: As a user, I should be able to update location.

  Background: User should be able to create a new location.
    Given user connects to the "/settings/location/add" api with body, POST
      | addressTitle | address | city | state | zipCode | country | timeZone                |
      | DemoAdres1   | a       | b    | c     | d       | USA     | Greenwich Standard Time |
    Given user connects to the "/dashboard/getUser" api without body to get data
      | locationInfos[0].id |

  Scenario: TC_001 Positive
    Given user connects to the "/settings/location/update" api with body,POST; changing "id" field
      | id         | addressTitle | address | city | state | zipCode | country | timeZone              |
      | locationId | a            | b       | c    | d     | 00      | German  | Pacific Standard Time |
    Then user verifies some values of the api response are true, only one json
      | success |
      | true    |
    Then user connects to the "/settings/location/delete" api with body,POST; changing "id" field
      | id         |
      | locationId |
    Then user verifies some values of the api response are true, only one json
      | success |
      | true    |

# Update islemi için öncesinde bir AddLocation olayı olmalı ki o eklenen location üzerinden islem yapabileleim.
# Add location API yi calistiginde success:true veriyor ama sonrasında getUser API ilgili location ın id sini locationInfos
# kismina aliyor. Biz de update location API ında getUser API ından gelen locationInfos[x].id sini kullaniyoruz.

# son 2 then ise delete api ile oluşturulan location siliniyor ve silindiği dogrulanıyor.