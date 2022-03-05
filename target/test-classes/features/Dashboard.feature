Feature: Dashboard tabs verification

  @dashboard1
  Scenario: Dashboard tabs

    When user enters admin username and password
    And user clicks on login button
    Then user print the dashboard tab list as below

  |Admin|PIM|Leave|Time|Recruitment|Performance| Dashboard| Directory|



