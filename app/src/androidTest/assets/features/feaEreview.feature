Feature: review service in the system

  @review-feature
  Scenario Outline: User can review a service
    Given I am on feedback service screen
    When I enter rating
    And I enter feedback <feedback>
    And I click on submit button
    Then I should get message

    Examples:
      | feedback  |
      | Good      |