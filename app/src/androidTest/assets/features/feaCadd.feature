Feature: Add service to the system

  @add-feature
  Scenario Outline: User provide details in form
    Given I am on home screen
    When I click on add service
    And I select category
    And I enter description <description>
    And I enter starting time
    And I enter closing time
    And I enter starting day <start_day>
    And I enter ending day <end_day>
    And I enter price <price>
    And I click on post button
    Then I should redirect to dashboard

    Examples:
      | description | start_day | end_day | price |
      | hello       | sun       | fri     | $50   |
