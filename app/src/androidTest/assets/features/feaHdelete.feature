Feature: delete wishlist service in the system

  @delete-feature
  Scenario: User can delete wishlist
    Given I am in service screen
    When I browse to wishlist screen
    And I click on delete button
    Then I can view delete success message