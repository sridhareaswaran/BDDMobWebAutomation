Feature: Image Search
  test duckduckgo image feature

  Scenario: Search for breaking bad images
    Given I am in duckduckgo homepage
    When I search for "breaking bad"
    And Click on Image button
    Then I should see image results
    And I should see "breaking bad" in page source