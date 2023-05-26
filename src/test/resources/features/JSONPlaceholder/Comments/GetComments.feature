Feature: Get Comments
  @Testing @PositiveCase
  Scenario: Get List Comments
    Given Get list comments
    When Send get list comments
    Then Status code should be 200 OK
    And Response body field id, postId, email, name, and body should be exist

  @Testing @PositiveCase
  Scenario Outline: Get single comments with valid parameter
    Given Get comments with valid parameter ID <id>
    When Send get comments
    Then Status code should be 200 OK
    And Response body ID should be <id>
    And Validate get comments JSON Schema
  Examples:
    | id  |
    | 100 |

  @Testing @NegativeCase
  Scenario Outline: Get single comments with invalid parameter id
    Given Get comments with with invalid parameter ID "<id>"
    When Send get comments
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | a  |
      | @  |

  @Testing @NegativeCase
  Scenario Outline: Get single post with exceed parameter id
    Given Get comments with exceed parameter ID <id>
    When Send get comments
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | 501 |