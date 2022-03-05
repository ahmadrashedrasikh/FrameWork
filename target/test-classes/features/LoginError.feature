Feature: LoginPage Error Validation

  @loginErrorValidation
  Scenario: Login Error Validation
    When user login with invalid credentials for verifications

      | username | password    | errorMessage        |
      | Admin    | Hum@hrm     | Invalid credentials |
      | Admin1   | Hum@nhrm123 | Invalid credentials |
#      |          | Hum@nhrm123 | Username cannot be empty |
#      | Admin    |             | Password cannot be empty | Data table doesn't accept null values
  @loginErrorValidation2
  Scenario Outline: Login Error Validation
    When user login with invalid "<username>" and "<password>" for error verification "<errorMessage>"
    Examples:
      | username | password    | errorMessage             |
      | Admin    | Hum@hrm     | Invalid credentials       |
      | Admin1   | Hum@nhrm123 | Invalid credentials      |
      |          | Hum@nhrm123 | Username cannot be empty |
      | Admin    |             | Password cannot be empty  |

