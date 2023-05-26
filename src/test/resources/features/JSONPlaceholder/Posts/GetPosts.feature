Feature: Get Posts
  @Testing @PostiveCase
  Scenario: Get List Posts
    Given Get list posts
    When Send get list posts
    Then Status code should be 200 OK
    And Response body field id, userId, title, body should be exist

  @Testing @PostiveCase
  Scenario Outline: Get single post with valid parameter
    Given Get single posts with valid parameter id <id>
    When Send get posts
    Then Status code should be 200 OK
    And Response body field id, userId, title, body should be exist
  Examples:
    | id |
    | 1  |

  @Testing @NegativeCase
  Scenario Outline:
    Given Get posts with invalid parameter ID "<id>"
    When Send get posts
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | a  |
      | @  |

  @Testing @NegativeCase
  Scenario Outline:
    Given Get posts with exceed parameter ID <id>
    When Send get posts
    Then Status code should be 404 Not Found
  Examples:
      | id  |
      | 101 |