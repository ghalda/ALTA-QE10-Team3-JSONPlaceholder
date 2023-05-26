Feature: Get Single Albums
  @Testing
  Scenario Outline: Get resource albums with valid parameter id
    Given Get albums with valid parameter ID <id>
    When Send get albums
    Then Status code should be 200 OK
    And Response body ID should be <id>
    And Validate get albums JSON Schema
  Examples:
    | id |
    | 1  |
    | 2  |
    | 3  |

  @Testing
  Scenario Outline: Get resources albums with invalid parameter id
    Given Get albums with invalid parameter ID "<id>"
    When Send get albums
    Then Status code should be 400 Bad Request
  Examples:
    | id      |
    | xxyyzz  |
    | @#ops!! |

  @Testing
  Scenario Outline: Get resources albums with exceed parameter id
    Given Get albums with exceed parameter ID <id>
    When Send get albums
    Then Status code should be 404 Not Found
  Examples:
    | id  |
    | 101 |
    | 210 |
    | 300 |