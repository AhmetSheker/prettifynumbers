Feature: Prettify the numbers

  Background:
    Given user is on the website home page

  Scenario: Testing us01 positive
    When user enters a number
    Then The number should be prettified
    And Close the application

  Scenario: Testing us01 negative
    When user enters a char other then a number
    Then warning should be appeared
    And Close the application