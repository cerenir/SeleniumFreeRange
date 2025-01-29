@Amazon
Feature: Testing Amazon webpage
    To buy any product
    I need to navigate correctly into the page
    And add products to the cart

@Plans
Scenario: Users can add product to cart
    Given the user navigates to www.amazon.com
    When the user searches for <Product>
    And navigates to second page
    And selects the third item
    Then the user is able to add it to the cart

Examples:
        |Product    |
        |Playstation|
        |Airpods    |