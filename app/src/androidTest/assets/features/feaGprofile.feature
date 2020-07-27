Feature: Update profile in the system

  @profile-feature
 Scenario Outline: Update profile of user
    Given I am in home screen
    When I click on profile
    And I erase and add new phone number <phone>
    And I click on update button
    Then I should receive updated message

    Examples:
      | phone     |
      | 9851726453 |