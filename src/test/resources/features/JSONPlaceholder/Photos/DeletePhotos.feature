Feature: Delete Single Photos
  @Testing
  Scenario Outline: Delete resources photos with valid parameter id
    Given Delete photos with valid parameter ID <id>
    When Send delete photos
    Then Status code should be 200 OK
  Examples:
    | id |
    | 1  |
    | 2  |
    | 3  |

  @Testing
  Scenario Outline: Delete resources photos with exceed parameter id
    Given Delete photos with exceed parameter ID <id>
    When Send delete photos
    Then Status code should be 404 Not Found
  Examples:
    | id   |
    | 5001 |
    | 6200 |
    | 7000 |

  @Testing
  Scenario Outline: Delete resources albums with invalid parameter id
    Given Delete photos with invalid parameter ID "<id>"
    When Send delete photos
    Then Status code should be 400 Bad Request
  Examples:
    | id      |
    | xxyyzz  |
    | @#ops!! |