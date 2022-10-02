Feature: login
  Scenario: login unseccessful
    Given I have the following users in the database
      | salahtan | salah |
      | mhammad  | ahmad |
      | 5ara     | 5ara  |
    When I enter "salah" and  "salah"
    Then Login is invalid