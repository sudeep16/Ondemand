Feature: hire service in the system

  @hire-feature
  Scenario Outline: User can hire a service
    Given I am on hire service screen
    When I select a card
    And I click on hire button
    And I enter payment method
    And I enter location <location>
    And I pick a date
    And I enter time
    And I click on confirm button
    Then I should get notification

    Examples:
      | location |
      | bagbazar |