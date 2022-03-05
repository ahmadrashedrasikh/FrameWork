Feature: Login validation


  @login
  Scenario: Valid admin login
    When user enters admin username and password
    And user clicks on login button
    Then admin user is successfully logged in

  @Regression
  Scenario: Invalid ess login
    When user enters invalid username and invalid password
    And user clicks on login button
    Then user see invalid credential message on login page

  @invalidLogin
  Scenario: Valid username and invalid password
    When user enters valid username and invalid password
    And user clicks on login button
    Then user see invalid credential message on login page
