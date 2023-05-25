Feature: Post Create Photos
  @Testing
  Scenario: Post create resources photos with valid request body json
    Given Post create photos with valid body json
    When Send post create photos
    Then Status code should be 201 Created
    And Response body for albumId should be 7, title should be "sun", url should be "https://via.placeholder.com/600/92c952" and thumbnailUrl should be "https://via.placeholder.com/150/92c952"
    And Validate post create photos JSON Schema

  @Testing
  Scenario: Post create resources photos with invalid request body json
    Given Post create photos with invalid body json
    When Send post create photos
    Then Status code should be 400 Bad Request