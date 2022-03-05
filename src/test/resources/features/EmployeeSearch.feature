@searchEmployee
Feature: Search employee


  Scenario: Search employee by id

    And user is logged in with valid credentials
    And user navigate to employee list page
    When user enters valid employee ID
    And click on search button
    Then user see employee information is displayed


  Scenario: Search employee by name
    And user is logged in with valid credentials
    And user navigate to employee list page
    When user enters valid employee name
    And click on search button
    Then user see employee information is displayed


  Scenario:
    When user wants to print list of maps
      | firstName | middleName | lastName  |
      | Jessica   | Claire     | Bella     |
      | Elena     | Zoe        | Scarlette |
      | Savannah  | Riley      | Avery     |
      | Brooklyn  | Hannah     | Hazel     |


  Scenario:
    When user would like to print list of objects

      | firstName1 | middleName1 | lastName1  |
      | Jessica1   | Claire1     | Bella1     |
      | Elena1     | Zoe1        | Scarlette1 |
      | Savannah1  | Riley1      | Avery1     |
      | Brooklyn1  | Hannah1     | Hazel1     |