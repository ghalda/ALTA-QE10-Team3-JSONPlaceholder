Feature: Post Create Albums
  @Testing
  Scenario: Post create resources albums with valid request body json
    Given Post create albums with valid body json
    When Send post create albums
    Then Status code should be 201 Created
    And Response body for userId should be 1 and title should be "gloomy"
    And Validate post create albums JSON Schema

  @Testing
  Scenario: Post create resources albums with invalid request body userId
    Given Post create albums with invalid request body userId
    When Send post create albums
    Then Status code should be 400 Bad Request

  @Testing
  Scenario: Post create resources albums with invalid request body title
    Given Post create albums with invalid request body title
    When Send post create albums
    Then Status code should be 400 Bad Request

  @Testing
  Scenario: Post create resources albums without using request body userId, only using valid request body title
    Given Post create albums only using valid body title without body userId
    When Send post create albums
    Then Status code should be 400 Bad Request