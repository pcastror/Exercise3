Feature: Found a recipe with some ingredients

  Scenario: find cinnamon roll recipe with sugar and cinnamon on the list of ingredient

    Given user is on google
    When The user search the Tottus stores
    And find Nataniel Cox and click on Web site
    And Tottus is open click on Recipe
    And Select a High difficult
    And Find a cinnamon rolls and click it
    Then recipe should be contain cinnamon and sugar ingredients