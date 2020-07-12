Feature: registering into the system

  @register-feature
  Scenario Outline: register with empty data
    Given I am at register screen
    When I input a lastName <lastName>
    And I input an address <address>
    And I input a username <username>
    And I input an email <email>
    And I input a phone <phone>
    And I input a gender <gender>
    And I input a password <password>
    And I input a confirm password <confirmPassword>
    And I click signup button
    Then I should receive field required message

    Examples:
       | lastName | address | username | email         | phone  | gender | password | confirmPassword |
       | test     | ktm     | bddd1234 | bdd@gamil.com | 892387 | Male   | P@ssw0rd | P@ssw0rd        |

  @register-feature
  Scenario Outline: register with invalid email
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
    Then I should receive invalid email message

    Examples:
      | firstName | lastName | address | username | email | phone  | gender | password | confirmPassword |
      | Bddtest   | test     | ktm     | bddd1234 | bdd   | 892387 | Male   | P@ssw0rd | P@ssw0rd        |

  @register-feature
  Scenario Outline: register with invalid password
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
    Then I should receive invalid password message

    Examples:
      | firstName | lastName | address | username | email         | phone  | gender | password | confirmPassword |
      | Bddtest   | test     | ktm     | bddd1234 | bdd@gmail.com | 892387 | Male   | abc      | abc             |

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
      | Bddtest   | test     | ktm     | bddd1234 | bdd@gamil.com | 892387 | Male   | P@ssw0rd | P@ssw0rd        |