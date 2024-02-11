Feature: rabotaby tests

  @regression
  Scenario: Search vacancy
    Given Open home page
    When I enter $"QA Automation" in search field
    And I click on search button
    Then I verify vacancy - "QA" in header
    Then Compare number of vacancies with 2
