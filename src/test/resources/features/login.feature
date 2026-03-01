Feature: Login

  Scenario: User can login with valid credentials
    Given User open login page
    When User login "user-name" and "password" as "validUser"
    Then User can navigate to Dashboard page