Feature: registering into the system

  @register-feature
  Scenario Outline: register with valid data
    Given I am at register screen
    When I input a firstName <firstName>
    And I input a lastName <lastName>
    And I input an address <address>
    And I input a username <username>
    And I input an email <email>
    And I input a phone <phone>
    And I input a gender <gender>
    And I input a password <password>
    And I input a confirm password <confirmPassword>
    And I click signup button
    Then I should receive message success

    Examples:
      | firstName | lastName | address | username | email         | phone  | gender | password | confirmPassword |
      | Bddtest   | test     | ktm     | bddd1234 | bdd@gamil.com | 892387 | Male   | password | password        |