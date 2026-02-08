Feature: Login

  Scenario: Login successful
    Given User open login page
    When User login with "dnhu12@gmail.com" and "dnhu12@gmail.com"
    Then User can navigate to Dashboard page