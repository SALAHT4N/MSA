Feature:Tic Tac Toe
  Scenario: X wins
    Given  X has 3 on a row
    When X play 3 on a row
    Then X wins true