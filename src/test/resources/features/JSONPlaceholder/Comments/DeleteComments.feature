Feature: Delete Comments
  @Testing @PositiveCase
  Scenario Outline: Delete comments with valid parameter ID
    Given Delete comments with valid parameter ID <id>
    When Send delete comments
    Then Status code should be 200 OK
    Examples:
      | id  |
      | 300 |

  @Testing @NegativeCase
  Scenario Outline: Delete comments with invalid parameter ID
    Given Delete comments with invalid parameter ID "<id>"
    When Send delete comments
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | a  |
      | @  |

  @Testing @NegativeCase
  Scenario Outline: Delete comments with exceed parameter ID
    Given Delete comments with exceed parameter ID <id>
    When Send delete comments
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | 503 |

  @Testing @NegativeCase
  Scenario Outline: Delete comments with empty parameter ID
    Given Delete comments with empty parameter ID "<id>"
    When Send delete comments
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      |    |