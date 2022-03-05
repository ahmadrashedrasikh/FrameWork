Feature: Add Employee

  Background:
    Given user is logged in with valid credentials
    And user clicks on PIM option
    And user clicks on add employee list option

  @Today
  Scenario: first scenario of adding employee

    And user adds first name, middle name and last name
    When user clicks on save button
    Then new employee is added successfully

  @Today
  Scenario: second scenario of adding employee

    And user adds first name, middle name and last name
    And user delete auto generated employee ID
    When user clicks on save button
    Then new employee is added successfully

  @Today
  Scenario: third scenario of add employee

    And user adds first name, middle name and last name
    And user thick create login credentials
    And user enter valid username, password,confirm password
    When user clicks on save button
    Then new employee is added successfully

  @Dynamic
  Scenario: add user dynamically

    And user adds first name "William", middle name "Roberto" and last name "RobertoWilliam"
    When user clicks on save button
    Then new employee is added successfully

  @scenario_outline_examples
  Scenario Outline: adding multiple object
    When user adds "<firstName>", "<middleName>",and "<lastName>"
    And user clicks on save button
    Then new employee is added successfully
    Examples:
      | firstName | middleName | lastName |
      | Henry     | Daniel     | Joseph   |
      | James     | John       | Robert   |
      | Robert    | Michael    | William  |
      | David     | Richard    | Charles  |

  @addingFromDataTable
  Scenario: adding and verify multiple employee data table
    When user add and verify multiple employees from datatable
      | firstname1 | middlename1 | lastname1  |
      | jessica1   | claire1     | bella1     |
      | elena1     | zoe1        | scarlette1 |
      | savannah1  | riley1      | aver1y     |
      | brooklyn1  | hannah1     | hazel1     |

  @excel
  Scenario: adding employees from excel
    When adding multiple employees from Employees "EmployeesData" sheet and verify them

  @db
  Scenario: Adding employee and validating in DB
    When user adds first name "LukeUPDATED10", middle name "LukeUPDATED8" and last name "LukeUPDATED78"
    And captures employee id
    And user clicks on save button
    And new employee is added successfully
    Then Query HRMS Database and get data
    And verify employee data is matched UI and DB






