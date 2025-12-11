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

  Scenario: Reserve Karne Table Control
    Given The user go to reserve karne screen
    Then The user verify table has value


  Scenario: MY 360 Penetration
    When The user go to redirection link
    When The user click penetration tab
    Then The user take screenshot for penetration


