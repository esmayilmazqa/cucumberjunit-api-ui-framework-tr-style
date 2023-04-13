#Correct infos need to be seen in the correct columns.
Feature: As a user, I should be able to see clients in client_info table
  Scenario: TC_001 User should be seen clients in client_info table
    Given user connects to the database
    Then user verifies the "client_info" table has the columns
      | user_id        |
      | client_id      |
      | email          |
      | adress         |
      | personel_note  |
      | state          |
      | city           |
      | zip_code       |
      | country        |
      | time_zone      |
      | name           |
      | surname        |
      | phone          |
      | occupation     |
      | suggestibility |
      | sexuality      |
      | middle_name    |
      | gender         |
      # not null
    Then user verifies that if the each client exists

