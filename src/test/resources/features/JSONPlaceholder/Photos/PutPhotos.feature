Feature: Put Update Photos
  @Testing
  Scenario Outline: Put update resources photos with valid request body json and parameter id
    Given Put update photos with valid json and parameter ID <id>
    When Send put update photos
    Then Status code should be 200 OK
    And Response body update ID should be <id>, albumId should be 100, title should be "flower", url should be "https://via.placeholder.com/600/771796" and thumbnailUrl should be "https://via.placeholder.com/150/771796"
    And Validate put update photos JSON Schema
  Examples:
    | id |
    | 1  |
    | 2  |
    | 3  |

  @Testing
  Scenario Outline: Put update resources photos with invalid request body json and parameter id
    Given Put update photos with invalid json and invalid parameter ID "<id>"
    When Send put update photos
    Then Status code should be 400 Bad Request
  Examples:
    | id      |
    | xxyyzz  |
    | @#ops!! |