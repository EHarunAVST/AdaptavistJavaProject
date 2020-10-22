Feature: Herokuapp javascript alert

  Scenario: Clicking JS alert button
    Given I navigate to herokuapp alert website
    When I click JS 'alert' button
    And I click 'ok' button on 'JSAlert' warning popout
    Then Result display 'You successfuly clicked an alert'

  Scenario: Clicking OK button on JS confirm alert
    Given I navigate to herokuapp alert website
    When I click JS 'confirm' button
    And I click 'ok' button on 'JSConfirm' warning popout
    Then Result display 'You clicked: Ok'

  Scenario: Clicking CANCEL button on JS confirm alert
    Given I navigate to herokuapp 'alert' website
    When I click JS 'confirm' button
    And I click 'cancel' button on 'JSConfirm' warning popout
    Then Result display 'You clicked: Cancel'

  Scenario: Clicking CANCEL button with empty value on JS prompt alert
    Given I navigate to herokuapp 'alert' website
    When I click JS 'prompt' button
    And I click 'cancel' button on 'JSPrompt' warning popout
    Then Result display 'You entered: null'

  Scenario: Clicking OK button with empty value on JS prompt alert
    Given I navigate to herokuapp 'alert' website
    When I click JS 'prompt' button
    And I click 'ok' button on 'JSPrompt' warning popout
    Then Result display 'You entered:'

  Scenario: Clicking OK button with empty value on JS prompt alert
    Given I navigate to herokuapp 'alert' website
    When I click JS 'prompt' button
    And I insert 'testing' as input value
    And I click 'ok' button on 'JSPrompt' warning popout
    Then Result display 'You entered: testing'