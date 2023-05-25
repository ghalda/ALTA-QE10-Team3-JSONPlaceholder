Feature: Put Update Todos
  @Testing
  Scenario Outline: Put Update Todos with valid id & valid reqbody
    Given Put Update Todos with valid id <id> & valid reqbody
    When Send Put Update Todos
    Then Status code should be 200 OK
    And Response body title should be user id 1 and title "todos1"
    And Validate  Update Todos  Todos JSON Schema
    Examples:
      | id |
      | 1  |
  @Testing
  Scenario Outline: Put Update Todos with invalid id & valid reqbody
    Given Put Update Todos with invalid id "<id>" & valid reqbody
    When Send Put Update Todos with invalid id & valid reqbody
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | @  |

  @Testing
  Scenario Outline: Put Update Todos with invalid reqbody title and valid id
    Given Put Update Todos with invalid reqbody title and valid id <id>
    When Send Put Update Todos with invalid reqbody title and valid id
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | 1  |
  @Testing
  Scenario Outline: Put update Todos with exceed parameter ID
    Given Put update Todos with exceed parameter ID <id>
    When Send put update todos exceed parameter ID
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | 201 |