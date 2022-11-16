Feature: Search and Place the order for Products
  Scenario Outline: Search Experience for product search in both home and Offers page

    Given user is on GreenKart Landing page
    When user searched with shortname <Name> and extracted actual name of product
    And user searched for shortname <Name> in offers page
    Then product name in offers page matches with Landing Page

    Examples:
      | Name |
      | Tom  |
      | Beet |