
  Feature: Search with using tags only
    Scenario Outline: Searching with using tags
      Given i entered the home page
      When i search for "<tags>", and located in "<street>", "<city>", "<country>"
      Then the output will be "<id>"

      Examples:
        | street | city | country   | tags   | id  |  |
        |        |      | palestine |        | 1   |  |
        | asira  |      |           |        | 1,2 |  |
        |        |      |           | lips   | 2   |  |
        |        |      |           | barber | 1   |  |
        |        |      |           |        | 1,2 |  |


