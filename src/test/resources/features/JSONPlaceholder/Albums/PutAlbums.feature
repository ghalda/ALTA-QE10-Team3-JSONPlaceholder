Feature: Put Update Albums
  @Testing
  Scenario Outline: Put update resources albums with valid request body json and parameter id
    Given Put update albums with valid json and parameter ID <id>
    When Send put update albums
    Then Status code should be 200 OK
    And Response body update id should be <id>, userId was 2 and title was "polyphia"
    And Validate put update albums JSON Schema
  Examples:
    | id |
    | 1  |
    | 2  |
    | 3  |

  @Testing
  Scenario Outline: Put update resources albums with invalid parameter id and valid request body json
    Given Put update albums with invalid parameter ID "<id>" and valid json
    When Send put update albums
    Then Status code should be 400 Bad Request
  Examples:
    | id      |
    | xxyyzz  |
    | @#ops!! |

  @Testing
  Scenario Outline: Put update resources albums with valid parameter id and invalid request body json
    Given Put update albums with valid parameter ID <id> and invalid json
    When Send put update albums
    Then Status code should be 400 Bad Request
  Examples:
    | id |
    | 1  |
    | 2  |
    | 3  |

  @Testing
  Scenario Outline: Put update resources albums with invalid parameter id and invalid request body json
    Given Put update albums with invalid parameter ID "<id>" and invalid json
    When Send put update albums
    Then Status code should be 400 Bad Request
  Examples:
    | id      |
    | xxyyzz  |
    | @#ops!! |

  @Testing
  Scenario Outline: Put update resources albums with exceed parameter id and valid request body json
    Given Put update albums with exceed parameter ID <id> and valid json
    When Send put update albums
    Then Status code should be 404 Not Found
  Examples:
    | id  |
    | 101 |
    | 210 |
    | 300 |