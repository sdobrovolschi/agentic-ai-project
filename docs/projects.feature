Feature: Projects lifecycle

  Scenario: Successfully create a new project
    Given no project with key "ECOM" exists
    When I request to create it
    Then it is created

  Scenario: Reject project creation when the key already exists
    Given a project with key "ECOM" already exists
    When I request to create it
    Then the request is rejected

  Scenario: Reject project creation with an invalid key format
    When I submit a project creation request
    Then the request is rejected

    Examples:
      | invalidKey    |
      | 1BC           |
      | ab             |
      | this-key-too-long |
      | lower           |

  Scenario: Retrieve an existing project by key
    Given a project with key "ECOM" and id "10005" already exists
    When I request it
    Then I get it

  Scenario: Fail to retrieve a project that does not exist
    Given no project with key "GHOST" id "10010" exists
    When I request it
    Then I don't get it

  Scenario: Successfully delete an existing project
    Given a project with key "ECOM" and id "10005" already exists
    When I request its deletion
    Then it is deleted
    And it is no longer available
