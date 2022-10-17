
Feature: Login
  Scenario Outline: One of the inputs is invalid
    Given I press login
    When I enter "<username>" and "<password>"
    Then login is "<output>" and user level is "<level>"

    Examples:
      | username |  | password | output | level       |  |
      | salahtan |  | 123456   | true   | user        |  |
      | salah    |  | software | false  | custustomer |  |
      | amjad    |  | nothere1 | false  | customer    |  |
