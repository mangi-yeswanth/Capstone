Feature: User Login

  Scenario Outline: Login with multiple valid credentials
    Given User is on Home Page
    When User navigates to Login Page
    And User enters email "<email>" and password "<password>"
    And User clicks the login button
    Then User should be logged in successfully

    Examples:
      | email                   | password      |
      | yeswanthmangi@gmail.com | Yesh@66543211 |
      | testeruser1@gmail.com   | Test@1234     |
      | testeruser2@gmail.com   | Pass@5678     |
