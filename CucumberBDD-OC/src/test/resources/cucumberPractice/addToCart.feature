Feature: Add to cart

  As a customer of AskOmDch app,                      ==> Represents Actor
  I should be able to add product(s) to the cart,     ==> Represents ACTION that ACTOR need to perform
  So that I can purchase them                         ==> Represents OUTCOME of the ACTION done by the ACTOR

  Rule: Add from Store

    @smoke
    Scenario Outline: Add one quantity from Store
      Given I'm on the Store Page
      When I add a "<product_name>" to the cart
      Then I should see 1 "<product_name>" in the cart

      @stage
      Examples:
        | product_name |
        | Blue Shoes   |

      @prod
      Examples:
        | product_name    |
        | Anchor Bracelet |

    Scenario: Add the product already in the cart
      Given I'm on the Store Page
      And I have 1 "Blue Shoes" in the cart
      When I add it again
      Then I should see 2 "Blue Shoes" in the cart

  Rule: Add from Product page

    Scenario Outline: Add the product to the cart
      Given I'm browsing "<product_name>"
      When I add <quantity> quantity to the cart
      Then I should see <quantity> "<product_name>" in the cart
      Examples:
        | product_name    | quantity |
        | Blue Shoes      | 1        |
        | Anchor Bracelet | 2        |

    Scenario: Add the product already in the cart
      Given I'm browsing "Blue Shoes"
      And I have 1 "Blue Shoes" in the cart
      When I add 1 quantity to the cart
      Then I should see 2 "Blue Shoes" in the cart

    Scenario: Show an error when try to add zero quantity
      Given I'm browsing "Blue Shoes"
      When I add 0 quantity
      Then I should see an error

    Scenario Outline: Change the product quantity using arrows
      Given I'm browsing "Blue Shoes"
      And the selected quantity is <currentQuantity>
      When I use <direction> arrow to change the quantity
      Then the selected quantity changes to <newQuantity>
      Examples:
        | direction | currentQuantity | newQuantity |
        | up        | 1               | 2           |
        | down      | 2               | 1           |
        | down      | 1               | 1           |

    Scenario: Show a Banner when I add to cart
      Given I'm browsing "Blue Shoes"
      When I add 1 quantity


