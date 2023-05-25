Feature: Delete users
  @Testing
  Scenario Outline: Delete users with valid id
    Given Delete Users with valid parameter id <id>
    When Send Delete users
    Then Status code should be 200 OK
    Examples:
    |id|
    |1|
    |2|

  @Testing
    Scenario Outline: Delete users with invalid id
      Given Delete Users with invalid parameter id <id>
      When Send Delete users
      Then Status code should be 400 Bad Request
        Examples:
        |id|
        |"@"|

  @Testing
    Scenario Outline: Delete users with exceed parameter id
      Given Delete users with exceed parameter id <id>
      When Send Delete users
      Then Status code should be 404 Not Found
        Examples:
        |id|
        |999|

