Feature: Text Search
  test duckduckgo text feature

  Scenario: Text Search
    Given I am in duckduckgo homepage
    When I search for "Elon Musk"
    Then I should see text results
    And I should see "Elon Mush" in page source