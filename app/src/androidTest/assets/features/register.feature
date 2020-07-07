Feature: registering into the system

  Scenario: register with valid data
    Given A user is at a "Register" screen
    When I input a firstname, rajesh
    And I input a lastname, hamal
    And I input an address, ktm
    And I input a username, rajesh123
    And I input an email, hamal123@gmail.com
    And I input a phone, 9860161111
    And I input a gender, male
    And I input a password, hamal
    And I press signup button
    Then I should receive message register success

  Scenario: register with invalid data
    Given A user is at a "Register" screen
    When I input a firstname, rajesh
    And I input a lastname, hamal
    And I input an address, ktm
    And I input a username,
    And I input an email, hamal123@gmail.com
    And I input a phone, 9860161111
    And I input a gender, male
    And I input a password, hamal
    And I press signup button
    Then I should receive message that the field is empty