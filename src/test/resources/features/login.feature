Feature: Login

  Scenario: User can login with valid credentials
    Given User open login page
    When User login "Email" and "Password" as "validUser"
    Then User can navigate to Dashboard page