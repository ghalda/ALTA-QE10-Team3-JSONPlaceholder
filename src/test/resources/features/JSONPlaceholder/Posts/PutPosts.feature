Feature: Put Posts
  @Testing @PositiveCase
  Scenario Outline: Update post with valid request body and parameter id
    Given Put update post with valid request body and parameter id <id>
    When Send put update posts
    Then Status code should be 200 OK
    And Response body id was <id>, title was "<title>", body was "<body>" and User Id was <userId>
    And Validate put posts JSON Schema
    Examples:
      | id  | title      | body      | userId |
      | 100 | title post | body post | 1      |

  @Testing @NegativeCase
  Scenario Outline:Update post with valid request body and invalid parameter id
    Given Put update post with valid request and invalid parameter id "<id>"
    When Send put update posts
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | a  |
      | @  |

  @Testing @NegativeCase
  Scenario Outline:Update post with valid request body and exceed parameter id
    Given Put update post with valid request and exceed parameter id <id>
    When Send put update posts
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | 101 |

  @Testing @NegativeCase
  Scenario Outline:Update post with valid parameter id and without request body
    Given Put update post with valid parameter id <id> and without request body
    When Send put update posts
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | 50 |

  @Testing @NegativeCase
  Scenario Outline:Update post with invalid request body and invalid parameter id
    Given Put update post with invalid request body and string parameter id "<id>"
    When Send put update posts
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | a  |
      | @  |