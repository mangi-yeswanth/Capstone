Feature: Invalid Login Functionality

  Scenario Outline: User tries to login with invalid credentials
    Given User is on the login page
    When User enters invalid email "<email>" and password "<password>"
    And clicks on the login button
    Then Error message "Your email or password is incorrect!" should be displayed

    Examples:
      | email               | password     |
      | wronguser@gmail.com | wrong@543211 |
      | fakeuser@mail.com   | test1234     |
      | invalid@mail.com    | password@99  |
