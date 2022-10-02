Feature: Login
  Scenario: Valid username and password
    Actor: User
    Given I press login
    When I enter "salahtan" and "software"
    Then login is successful.
  Scenario Outline: One of the inputs is invalid
    Given I press login
    When I enter <"username"> and <"password">
    Then login is unsuccessful

    Examples:
      | username | password |
      | true     | false    |
      | false    | true     |
      | false    | false    |
