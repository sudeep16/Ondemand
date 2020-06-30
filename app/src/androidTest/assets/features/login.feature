Feature: Logging into the system

  Scenario: Login with valid data
    Given A user is at a "Login" screen
    When I input an username, test123
    And I input a password, test
    And I press login button
    Then I should receive message login success

  Scenario: Login with invalid data
    Given A user is at a "Login" screen
    When I input an username, root
    And I input a password, 123
    And I press login button
    Then I should receive message login failed