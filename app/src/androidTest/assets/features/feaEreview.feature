Feature: review service in the system

  @review-feature
  Scenario Outline: User can review a service
    Given I am in hire service screen
    When I select a service card
    And I click on feedback button
    When I enter rating
    And I enter feedback <feedback>
    And I click on submit button
    Then I should get message

    Examples:
      | feedback  |
      | Good      |