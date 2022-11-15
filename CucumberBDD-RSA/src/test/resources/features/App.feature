Feature: basic feature test template
  @Example
  Scenario: testing the print
    Given user is on landing page
    When user enters the "username" and "password"
    And user clicks on the login button
    Then landing page is opened