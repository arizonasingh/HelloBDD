Feature: Google Search
  View Google search results are populating

  Scenario: Google single search results
    Given user is on Google home page
    When user types in "cucumber bdd" in the search box
    And user clicks on Search button
    Then user should see "cucumber bdd" in the results

  Scenario Outline: Google multi search results
    Given user is on Google home page
    When user types in "<search>" in the search box
    And user clicks on Search button
    Then user should see "<search>" in the results
    Examples:
      | search   |
      | shrek    |
      | godzilla |
      | wall-e   |