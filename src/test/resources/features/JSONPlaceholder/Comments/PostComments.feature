Feature: Post New Comments
  @Testing @PositiveCase
  Scenario Outline: Create new comments with valid request body
    Given Post create comments with valid body json
    When Send post create comments
    Then Status code should be 201 Created
    And Response body id exist, post Id was <postId>, name was "<name>", email was "<email>", and body was "<body>"
    And Validate post create comments JSON Schema
  Examples:
    | postId | name   |  | email            | body          |
    | 1      | ghalda |  | ghalda@gmail.com | body comments |

  @Testing @NegativeCase
  Scenario: Create new comments with invalid request body postId
    Given Post create comments with invalid request body postId
    When Send post create comments
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new comments with invalid request body comment body
    Given Post create comments with invalid request body comment body
    When Send post create comments
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new comments with invalid request name
    Given Post create comments with invalid request name
    When Send post create comments
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new comments with invalid type data request body email
    Given Post create comments with invalid type data request body email
    When Send post create comments
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new comments with invalid format request body email
    Given Post create comments with invalid format request body email
    When Send post create comments
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new comments without request body postId
    Given Post create comments without request body postId
    When Send post create comments
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new comments without request body name
    Given Post create comments without request body name
    When Send post create comments
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new comments without request body email
    Given Post create comments without request body email
    When Send post create comments
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new comments without request body comments body
    Given Post create comments without request body comments body
    When Send post create comments
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new comments without request body
    Given Post create comments without request body
    When Send post create comments
    Then Status code should be 400 Bad Request