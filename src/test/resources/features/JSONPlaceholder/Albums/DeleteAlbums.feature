Feature: Delete Single Albums

  @Testing
  Scenario Outline: Delete resources albums with valid parameter id
    Given Delete albums with valid parameter ID <id>
    When Send delete albums
    Then Status code should be 200 OK
  Examples:
    | id |
    | 1  |
    | 2  |
    | 3  |

  @Testing
  Scenario Outline: Delete resources albums with exceed parameter id
    Given Delete albums with exceed parameter ID <id>
    When Send delete albums
    Then Status code should be 404 Not Found
  Examples:
    | id  |
    | 101 |
    | 210 |
    | 300 |

  @Testing
  Scenario Outline: Delete resources albums with invalid parameter id
      Given Delete albums with invalid parameter ID "<id>"
      When Send delete albums
      Then Status code should be 400 Bad Request
  Examples:
    | id      |
    | xxyyzz  |
    | @#ops!! |