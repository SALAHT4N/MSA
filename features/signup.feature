Feature: Sign Up
  Scenario: Choose provider or customer role
    Given user tries to signup
    When user selects "<role>"
    And user presses next
    Then user goes to next step
  Scenario Outline: user fills required data
    Given user is a "<role>"
    When user enters "<first_name>" and "<middle_name>" and "<last_name>" and "<password>" and "<confirm_password>" and "<birth_date>" and "<gender>" and "<email>" and "<phone_number>" and "<bank_name>" and "<bank_account_number>"
    Then signup occures "<signup_state>"

    Examples:
      | role     | first_name  | middle_name | last_name | password | confirm_password | birth_date | gender | email | phone_number | bank_name | bank_account_number |
      | customer | salah aldin | ismail      | tanbour   | tansalah | tansalah         |            |        |       |              |           |                     |
      |          |             |             |           |          |                  |            |        |       |              |           |                     |
      |          |             |             |           |          |                  |            |        |       |              |           |                     |
      |          |             |             |           |          |                  |            |        |       |              |           |                     |
      |          |             |             |           |          |                  |            |        |       |              |           |                     |
      |          |             |             |           |          |                  |            |        |       |              |           |                     |
      |          |             |             |           |          |                  |            |        |       |              |           |                     |