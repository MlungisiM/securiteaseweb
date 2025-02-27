Feature: As a BBC editor I want to report on the top 3 finishers of the 2023 Las Vegas Grand Prix
so that readers get a clear and accurate summary of the race results.

Scenario: As a BBC editor
Given I navigate to the BBC Formula 1 results page
When I extract the top three race winners
Then the race winners should be Max Verstappen, George Russell, and Sergio Perez

