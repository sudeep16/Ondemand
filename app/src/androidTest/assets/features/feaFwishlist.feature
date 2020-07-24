Feature: wishlist service in the system

  @wishlist-feature
  Scenario: User can add a service to wishlist
    Given I am in a service screen
    When I now select a service card
    And I click on add to wishlist button
    And I go to wishlist screen
    Then I can view my wishlist

