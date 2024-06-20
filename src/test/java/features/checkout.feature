Feature: Place order for Products

  @PlaceOrder
  Scenario Outline: Search experience for product search in both home and offers page

    Given User is on GreenCart Landing Page
    When user searched with shortname <name> and extracted actual name of product
    And  Added "3" items of selected product of the cart
    Then User proceeds to checkout and validate the <name> items in the checkout
    And verify user has the ability to enter promo code and place the order



    Examples:
    |name   |
    | Tom   |