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

  @login-feature
  Scenario Outline: Login with valid data
    Given I am on login screen
    When I enter username <username>
    And I enter password <password>
    And I click on the login button
    Then I am redirected to dashboard

    Examples:
      | username | password |
      | bddd1234 | P@ssw0rd |