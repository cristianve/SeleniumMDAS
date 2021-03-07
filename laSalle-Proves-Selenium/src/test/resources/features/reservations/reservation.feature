Feature: Get available flight

  Narrative:
  In order find available flights
  As a client of https://www.vueling.com/es
  I want to be able to search flights

  Scenario: Search for available flights
    Given I'm main page
    When I try to find a fly
      | Origin   | Destination | Outbound   | passengers |
      | Barcelona  | Londres    | NEXT_WEEK  | 1          |
    Then I get available flight
