Feature: Login into the system

  @login-feature
  Scenario Outline: User provide an empty field
    Given I am on login screen
    When I enter username <username>
    And I click on the login button
    Then I receive a field required message

    Examples:
      | username |
      | bddd1234 |