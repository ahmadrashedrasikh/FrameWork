Feature: Employees Personal Details Modification

  @modifyEmployee
  Scenario: Modify employee personal details
    Given user is navigated to HRMS
    When user clicks on PIM option
    And user enter employee full name "Donald J Trump"
    And user modify the employee personal details by clicking on his or her name
    Then user clicks on edit button and can modify the employee's following personal details

      | firstName  | middleName  | lastName | employeeID | otherID  | driverLicenseNumber | licenseExpDate | SSN_NUMBER  | SIN_Number | gender | maritalStatus | nationality | dateOfBirth | nickName | smoker | militaryService |

      | Donald     | Janie       | Trumpy   | 9999999    | 5555555  | 3333333             | 1987-02-10     | 85555555    | 9999999    | Male   | Single        | Irish       | 1988-07-05  | Zero     | Yes    | Yes             |
      | Roberto111 | TOMMY1      | Johnny1  | 2587945141 | 77777771 | 875542581           | 2021-02-05     | 85274158541 | 2587452541 | Female | Married       | American    | 1988-03-05  | Ramish   | No     | No              |
      | William    | Shakespeare | Johnny   | 258794514  | 7777777  | 87554258            | 2021-02-05     | 8527415854  | 258745254  | Male   | Married       | Australian  | 1999-03-05  | Ramish   | Yes    | Yes             |
      | Elena      | Sophia      | Johnny   | 258794514  | 7777777  | 87554258            | 2021-02-05     | 8527415854  | 258745254  | Girl   | Married       | Homestan    | 1988-03-05  | Ramish   | No     | NO              |







