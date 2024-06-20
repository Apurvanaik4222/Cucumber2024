Feature:Search and Place order for Products

  @searchProduct
  Scenario Outline: Search experience for product search in both home and offers page

    Given User is on GreenCart Landing Page
    When user searched with shortname <name> and extracted actual name of product
    Then user searched for <name> shortname in offers page
    And validate product name in offer page matches with Landing Page

    Examples:
      | name |
      | Tom  |
      | beat |