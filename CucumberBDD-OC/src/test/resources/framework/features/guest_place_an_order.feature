@severity=critical
@issue=123
@tmsLink=456

@regression
Feature: Place an order

  Asa guest customer of AskOmDch app,
  I should be able to provide the billing details,
  so that I can place the order

  @smoke
  Scenario: using default payment option
    Given I am a guest customer
    And my billing details are
      | firstname | lastname | country            | address_line1     | city  | state | zip   | email              |
      | demo      | user     | United States (US) | 6300 Spring Creek | Plano | Texas | 75024 | askomdch@gmail.com |
    And I have a product in the cart
    And I am on the checkout page
    When I provide billing details
    And I place an order
    Then the order should be placed successfully
