Feature: Herokuapp user authorization

  Scenario: Login into herokuapp with valid credentials
    Given I navigate to herokuapp 'login' website
    When I insert 'valid' user credentials
    And I click login button
    Then I 'successful' logon into herokuapp account

  Scenario: Login into herokuapp with invalid credentials
    Given I navigate to herokuapp 'login' website
    When I insert 'invalid' user credentials
    And I click login button
    Then I 'fail' logon into herokuapp account