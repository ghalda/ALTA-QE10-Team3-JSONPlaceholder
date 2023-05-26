Feature: Get Single Todos
  @Testing
  Scenario Outline: Get single todos
    Given Get single todos with valid parameter ID <id>
    When Send get single todos
    Then Status code should be 200 OK
    And Response body ID should be <id>
    And Validate get single todos JSON Schema
    Examples:
      | id |
      | 1 |
      | 2 |

  @Testing
  Scenario Outline: Get single todos with invalid parameter id
    Given Get single todos with invalid parameter ID "<id>"
    When Send get single todos with invalid parameter id
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | @  |