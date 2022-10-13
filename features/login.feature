Feature: Login
  Background: initial state
    Given the database has the following users
      | salahtan | software |
      | mhammad  | ahmad    |

  Scenario: Valid username and password
    Actor: User
    Given I press login
    When I enter "salahtan" and "software"
    Then login is successful.
  Scenario Outline: One of the inputs is invalid
    Given I press login
    When I enter "<username>" and "<password>"
    Then login is unsuccessful

    Examples:
      | username | password |
      | salahtan | dsfdsgfd |
      | salah    | software |
      | amjad    | not here |
