Feature: test site
  Scenario: test several features on the site
    Given open the page
    When click the Women category
    And click the Tops checkbox
    Then I see count of Tops

    When I click Tops checkbox
    And click Dresses checkbox
    Then I see count of Dresses

    When I make first order
    And I make second order
    And I make third order
    Then I see orders in the cart

    When I delete one order
    Then I can find deleted order in search