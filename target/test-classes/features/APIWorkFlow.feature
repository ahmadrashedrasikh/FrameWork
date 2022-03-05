Feature: Syntax HRM API workflow

  Background:
    Given a JWT token is generated

  @APIWorkflow
  Scenario: Creating an employee
    Given a request is prepared for creating an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 400
    And the created employee contains a key "Message" and a value "Employee Created"
    And the employee ID is "employee.employee_id" is stored as a global variable to be used for other calls

  @APIWorkflow
  Scenario: Retrieving created employee details
    Given a request is prepared to retrieve the created employee
    When a GET call is made to retrieve the created employee
    Then the status code for retrieving this employee is 400
    And the retrieved employee ID "employee.employee_id" should match global employee ID
    And the retrieved data at "employee" object matches the data used to create an employee with employee ID "Employee.employee_id"

      | emp_firstname | emp_emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title | emp_status |
      | Lauran        | Arabs                | Arabia       | 1988-02-19   |Male        |Engineer       |INACTIVE    |