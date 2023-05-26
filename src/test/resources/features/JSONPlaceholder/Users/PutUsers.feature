Feature: Put Users
  @Testing
  Scenario Outline: Put Update users with Valid parameter id and Valid bodyjson
    Given Put Update users with valid id <id> and valid bodyjson
    When Send Put Update users
    Then Status code should be 200 OK
    And Response body id exist, name was "Derin Malsa", username was "derinmalsa" and User Id was 1
    And Validate users update JSON Schema
    Examples:
      | id |
      | 1  |
  @Testing
  Scenario Outline: Put Update users with invalid parameter id and valid reqbody
    Given Put Update users with invalid parameter id "<id>" & valid reqbody
    When Send Put Update users
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | @  |

  @Testing
  Scenario Outline: Put Update users with valid parameter id and without request body
    Given Put Update users with valid parameter id <id> and without request body
    When Send Put Update users
    Then Status code should be 400 Bad Request
    Examples:
    |id |
    |1  |
    @Testing
    Scenario Outline: Put update users with exceed parameter id
      Given Put update users with exceed parameter ID <id>
      When Send Put Update users
      Then Status code should be 404 Not Found
        Examples:
        |id |
        |11 |
