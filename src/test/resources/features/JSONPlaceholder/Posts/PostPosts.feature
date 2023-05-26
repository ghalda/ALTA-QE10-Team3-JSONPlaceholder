Feature: Post New Posts
  @Testing @PositiveCase
  Scenario Outline: Post create posts with valid body json
    Given Post create posts with valid body json
    When Send post create posts
    Then Status code should be 201 Created
    And Response body id exist, title was "<title>", body was "<body>" and User Id was <userId>
    And Validate post create posts JSON Schema
  Examples:
    | title      | body      | userId |
    | title post | body post | 1      |

  @Testing @NegativeCase
  Scenario: Create new post with invalid request body title
    Given Post create posts with invalid request body title
    When Send post create posts
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new post with invalid request body post body
    Given Post create posts with invalid request body post body
    When Send post create posts
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new post with invalid request body userId
    Given Post create posts with invalid request body userId
    When Send post create posts
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new post without request body title
    Given Post create posts without request body title
    When Send post create posts
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new post without request body posts body
    Given Post create posts without request body posts body
    When Send post create posts
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new post without request body userId
    Given Post create posts without request body userId
    When Send post create posts
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new post without request body
    Given Post create posts without request body
    When Send post create posts
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new post with empty request body title
    Given Post create posts with empty request body title
    When Send post create posts
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new post with empty request body posts body
    Given Post create posts with empty request body posts body
    When Send post create posts
    Then Status code should be 400 Bad Request

  @Testing @NegativeCase
  Scenario: Create new post with empty request body userId
    Given Post create posts with empty request body userId
    When Send post create posts
    Then Status code should be 400 Bad Request