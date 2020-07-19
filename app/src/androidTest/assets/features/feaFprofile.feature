Feature: update profile in the system

  @profile-feature
  Scenario Outline: update profile with valid data
    Given I am at profile screen
    When I change address <address>
    And I change phone number <phone>
    And I click update button
    Then I should receive updated message

    Examples:
      | address | phone     |
      | ktm     | 984163747 |