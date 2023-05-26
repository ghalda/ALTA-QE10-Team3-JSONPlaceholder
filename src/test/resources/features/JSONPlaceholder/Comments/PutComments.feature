Feature: Put Comments
  @Testing @PositiveCase
  Scenario Outline: Update comments with valid request body and parameter id
    Given Put update comments with valid request body and parameter id <id>
    When Send put update comments
    Then Status code should be 200 OK
    And Response body id was <id>, post Id was <postId>, name was "<name>", email was "<email>", and body was "<body>"
    And Validate put comments JSON Schema
    Examples:
      | id | postId |  | name   |  | email            | body          |
      | 50 | 1      |  | ghalda |  | ghalda@gmail.com | body comments |

  @Testing @NegativeCase
  Scenario Outline:Update comments with valid request body and invalid parameter id
    Given Put update post with valid request body and invalid parameter id "<id>"
    When Send put update comments
    Then Status code should be 400 Bad Request
    Examples:
      | id  |
      | b   |
      | !!@ |

  @Testing @NegativeCase
  Scenario Outline:Update comments with valid request body and exceed parameter id
    Given Put update comments with valid request body and exceed parameter id <id>
    When Send put update comments
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | 503 |

  @Testing @NegativeCase
  Scenario Outline:Update comments with valid parameter id and without request body
    Given Put update comments with valid parameter id <id> and without request body
    When Send put update comments
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | 1  |

  @Testing @NegativeCase
  Scenario Outline:Update comments with invalid request body and invalid parameter id
    Given Put update comments with invalid request body and invalid parameter id "<id>"
    When Send put update comments
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | b  |
      | $  |