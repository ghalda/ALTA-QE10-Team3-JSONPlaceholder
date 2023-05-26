Feature: Delete Posts
  @Testing @PositiveCase
  Scenario Outline: Delete post with valid parameter ID
    Given Delete posts with valid parameter ID <id>
    When Send delete posts
    Then Status code should be 200 OK
    Examples:
      | id  |
      | 100 |

  @Testing @NegativeCase
  Scenario Outline: Delete post with invalid parameter ID
    Given Delete posts with invalid parameter ID "<id>"
    When Send delete posts
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | a  |
      | @  |

  @Testing @NegativeCase
  Scenario Outline: Delete post with exceed parameter ID
    Given Delete posts with exceed parameter ID <id>
    When Send delete posts
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | 200 |

  @Testing @NegativeCase
  Scenario Outline: Delete post with empty parameter ID
    Given Delete posts with empty parameter ID "<id>"
    When Send delete posts
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      |    |