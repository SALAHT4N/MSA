
  # The user can
  Feature: reservation

    Scenario Outline: reserve a specific service
      Given a "<user>" click reserve now
      Then all available appointments will shown up of the "<service>"
      And pressed on book option of a specific "<service>" at specific "<time>"
      Then the user will have an appointment at the "<reserved_time>" in the "<expected_service>"

      Examples:
        | user               | service | time                                    |  | reserved_time                           | expected_service |
        | salahtan@gmail.com | 1       | 2022-11-06T09:10:00~2022-11-06T10:10:00 |  | 2022-11-06T09:10:00~2022-11-06T10:10:00 | 1                |