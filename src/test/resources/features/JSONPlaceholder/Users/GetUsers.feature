Feature: Get Single Users
  @Testing
  Scenario Outline: Get single users
    Given Get single users with valid parameter ID <id>
    When Send get single users
    Then Status code should be 200 OK
    And Response body ID should be <id>
    And Validate get users JSON Schema
    Examples:
      | id |
      | 1 |
      | 2 |

  @Testing
  Scenario Outline: Get single users with invalid parameter id
    Given Get single users with invalid parameter ID "<id>"
    When Send get single users
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | @  |
