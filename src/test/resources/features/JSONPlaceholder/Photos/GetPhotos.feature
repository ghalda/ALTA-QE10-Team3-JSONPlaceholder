Feature: Get Single Photos
  @Testing
  Scenario Outline: Get resource photos with valid parameter id
    Given Get photos with valid parameter ID <id>
    When Send get photos
    Then Status code should be 200 OK
    And Response body ID should be <id>
    And Validate get photos JSON Schema
  Examples:
    | id |
    | 1  |
    | 2  |
    | 3  |

  @Testing
  Scenario Outline: Get resource photos with invalid parameter id
    Given Get photos with invalid parameter ID "<id>"
    When Send get photos
    Then Status code should be 400 Bad Request
  Examples:
    | id      |
    | xxyyzz  |
    | @#ops!! |

  @Testing
  Scenario Outline: Get resource photos with exceed parameter id
    Given Get photos with exceed parameter ID <id>
    When Send get photos
    Then Status code should be 404 Not Found
  Examples:
    | id   |
    | 5001 |
    | 6200 |
    | 7000 |