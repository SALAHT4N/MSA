
Feature: Login
  Scenario Outline: One of the inputs is invalid
    Given I enter login page
    When I enter "<email>" and "<password>"
    Then login is "<output>" and user level is "<level>"

    Examples:
      | email              |  | password | output | level |  |
      | salahtan@gmail.com |  | 123456   | true   | 0     |  |
      | salahtan@gmail.com |  | 123456   | true   | 0     |  |
      | amjad@gmail.com    |  | nothere1 | false  | -1    |  |
      | mhmd@gmail.com     |  | password | false  | -1    |  |