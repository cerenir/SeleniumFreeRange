Feature: Mis pruebas
    To login to the page
    I need to log correctly into the page
    And select products.

@Plans
Scenario: Users can log in correctly into the page
    Given I navigate to practicetestautomation.com
    When I enter a correct credentials
    Then I can log in correctly