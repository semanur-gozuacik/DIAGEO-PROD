Feature: Import Management Test Cases
  Background:
    When   The User opens the browser with the given url
    And    The User inputs a valid username "validUsername"
    And    The User inputs a valid password "validPassword"
    And    The User clicks the Submit button
    Given The user on the settings ımport page
    And   The User gets the current URL and stores it in "Import"
    And The user accepts the popup OK

  Scenario: Import pages tables verification
    Then The User verifies import page table is displayed

  Scenario: Reset Button Control
    And the user clicks on Reset button


  Scenario: Refresh Button Control
    And the user clicks on Refresh button

  Scenario: Name Filter Control
    And The user clicks name button
    And The user "Account (2)-2575.xlsx" code field
    And The user verifies name filter

  Scenario Outline:Import Page-Select status
    When  The user selects "<select status>" into select status
    Then  The user should see  "<select status>"  import select status
    Examples:
      | select status|
      |Completed|
      |Progress|
      |Uploaded|
      |Failed|

  Scenario: User Filter Control
    And The user clicks user button
    And The user "Efectura" user field
    And The user verifies user filter

  Scenario: Username Filter Control
    And The user clicks username button
    And The user "Efectura" username field
    And The user verifies username filter import