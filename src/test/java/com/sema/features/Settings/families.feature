Feature: Families Management Test Cases
  Background:
    When   The User opens the browser with the given url
    And    The User inputs a valid username "validUsername"
    And    The User inputs a valid password "validPassword"
    And    The User clicks the Submit button
    Given The user on the settings families page
    And   The User gets the current URL and stores it in "Settings/Families"

    Scenario: Families pages tables verification
      Then The User verifies Families page table is displayed

  Scenario: Reset Button Control
    And The user enters "ACCOUNT_TEST" into Code field-Settings Families
    And the user clicks on Reset button
    And the user verify Reset button functionality-Settings Families


  Scenario Outline:Families Page-User selects different options for show entries
    When  The user selects "<entries>" into show entries families
    Then  The user should see  "<entries>" entrie in everypage families
    Examples:
      | entries|
      |10 |
      |25 |
      |50 |
      |100|

  Scenario:Families Page Verify First Page Button Unclickable Condition
    And  The user verifies first page button is not clickable-families

  Scenario:Families Page Verify Previous Page Button Unclickable Condition
    And  The user verifies previous page button is not clickable-families

  Scenario:Families Page Verify Item next Button Unclickable Condition
    When The user clicks last page button-families
    And  The user verifies next button is not clickable-families

  Scenario: Families Page Verify Last Page Button Unclickable Condition
    When The user clicks last page button-families
    And  The user verifies last page button is not clickable-families

  Scenario:Families Page Verify First Page Button Clickable Condition
    When The user clicks last page button-families
    And  The user verifies first page button is clickable-families

  Scenario:Families Page Verify Previous Page Button Clickable Condition
    When The user clicks last page button-families
    And  The user verifies previous page button is clickable-families

  Scenario:Families Page Verify Item next Button Clickable Condition
    And  The user verifies next button is clickable-families

  Scenario: Families Page Verify Last Page Button Clickable Condition
    And  The user verifies last page button is clickable-families
