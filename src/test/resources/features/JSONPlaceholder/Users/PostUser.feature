Feature: Post User
  @Testing
  Scenario: Post Create users with Valid bodyjson
    Given Post Create users with valid bodyjson
    When Send Post Create users
    Then Status code should be 201 Created
    And Response body id exist, name was "Leanne Graham", username was "Bret" and User Id was 11
    And Validate Post Create users JSON Schema
  @Testing
  Scenario: Post Create users with invalid Reqbody name
    Given Post Create users with invalid reqbody name
    When Send Post Create users
    Then Status code should be 400 Bad Request
  @Testing
  Scenario: Post Create users with invalid Reqbody username
    Given Post Create users with invalid reqbody username
    When Send Post Create users
    Then Status code should be 400 Bad Request
