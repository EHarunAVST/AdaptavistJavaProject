Feature: Herokuapp iframe switching

  Scenario: Select bold from toolbar
    Given I navigate to herokuapp 'iframe' website
    And I click 'bold' on toolbar
    And result will show 'bold' was selected

  Scenario: Switching into iframe to write a text
    Given I navigate to herokuapp 'iframe' website
    When I write 'testing' in the text iframe
    Then result will show 'paragraph' was selected
    And verify 'testing' are written in iframe
