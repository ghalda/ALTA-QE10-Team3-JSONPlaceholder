Feature: Get Posts
  @Testing @PositiveCase
  Scenario: Get List Posts
    Given Get list posts
    When Send get list posts
    Then Status code should be 200 OK
    And Response body field id, userId, title, body should be exist

  @Testing @PositiveCase
  Scenario Outline: Get single post with valid parameter
    Given Get single posts with valid parameter id <id>
    When Send get posts
    Then Status code should be 200 OK
    And Response body posts ID should be <id>
    And Validate get posts JSON Schema
  Examples:
    | id |
    | 1  |

  @Testing @NegativeCase
  Scenario Outline: Get single post with invalid parameter id
    Given Get single posts with invalid parameter id "<id>"
    When Send get posts
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | a  |
      | @  |

  @Testing @NegativeCase
  Scenario Outline: Get single post with exceed parameter id
    Given Get single posts with exceed parameter id <id>
    When Send get posts
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | 101 |