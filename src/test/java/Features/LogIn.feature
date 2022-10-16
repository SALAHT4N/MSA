Feature: Testing the login feature

  Scenario Outline: Check login is successful with valid credentials

    Given user is on login page
    When user enters <username> ans <password>
    And clicks on login button
    Then  user is navigate to  the home page

    Examples:
      | username | password |
      | amjad    | hello    |
      | kayed    | hi       |
