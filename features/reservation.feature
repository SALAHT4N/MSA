
  # The user can
  Feature: reservation

    Scenario Outline: reserve a specific service
      Given a "<user>" click reserve now
      Then all available appointments will shown up
      And pressed on book option of a specific "<service>" at specific "<time>"
      Then the "<expected_user>" will have an appointment at the "<reserved_time>" in the "<expected_service>"

      Examples:
        | user | service | time | expected_user | reserved_time | expected_service |
        | 1    | 1       | any  | 1             | any           |1                 |