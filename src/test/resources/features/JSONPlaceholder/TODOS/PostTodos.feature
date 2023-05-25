Feature: Post Create Todos
@Testing
Scenario: Post create todos with valid reqbody
Given Post Create todos with valid reqbody
When Send Post Create Todos
Then Status code should be 201 Created
And Response body for userId 1 and  title should be "todos1"
And Validate Post Create Todos JSON Schema
@Testing
Scenario: Post create todos with invalid reqbody title
Given Post Create todos with invalid reqbody title
When Send Post Create Todos
Then Status code should be 400 Bad Request
@Testing
Scenario: Post create todos with invalid reqbody userId
Given Post create todos with invalid reqbody userId
When Send Post Create Todos with invalid reqbody userId
Then  Status code should be 400 Bad Request