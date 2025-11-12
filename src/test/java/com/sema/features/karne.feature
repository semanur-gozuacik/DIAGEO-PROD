@dia_smoke_prod
Feature: Karne Scenarios

  Scenario: Karne Export Controls
    Given The user go to karne screen
    When The user click excel export button
    Then The user verify 'excel' file is downloaded
    When The user click pdf export button
    Then The user verify 'pdf' file is downloaded
    When The user click siralamalar tab
    When The user click excel button
    Then The user verify 'excel' file is downloaded