@BookStore
Feature: Testing BookStore webpage
    To buy any book
    I need to navigate correctly into the Book page
    And register

Background: I am on the Book Store web without logging in.
    Given I navigate to demoqa.com 

Scenario: Users can log in to Book Store page
    When the user press login button and enter credentials
    Then the user is logged in correctly

Scenario: Non registered users can register to Book Store page
    Given the user navigates to www.amazon.com
    When the user searches for <Product>
    And navigates to page number 2
    And selects the third item
    Then the user is able to add it to the cart