Feature: Delete todos
  @Testing
  Scenario Outline: Delete todos with valid id
    Given Delete Todos with valid id <id>
    When Send Delete Todos
    Then Status code should be 200 OK
    Examples:
      | id |
      | 1  |
  @Testing
  Scenario Outline: Delete Todos with invalid id
    Given Delete Todos with invalid id "<id>"
    When Send Delete Todos with invalid id
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | @  |

  @Testing
  Scenario Outline: Delete Todos with exceed parameter id
    Given Delete Todos with exceed parameter id <id>
    When Send Delete Todos exceed parameter id
    Then Status code should be 404 Not Found
    Examples:
      | id |
      | 500|








