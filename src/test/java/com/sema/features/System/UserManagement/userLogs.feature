Feature: Users Management User Logs  Test Cases
  Background:
    When  The User opens the browser with the given url
    And   The User inputs a valid username "validUsername"
    And   The User inputs a valid password "validPassword"
    And   The User clicks the Submit button
    Then  The User waits until the System element is visible with a timeout of 120 seconds
    Given The user on the settings users logs page
    And   The User gets the current URL and stores it in "UserLogs"
    And The user click

  Scenario: Users Logs tables verification
    Then The User verifies User logs table is displayed

  Scenario: Verify UserName Filter -Invalid Unique UserName
    And The user enters "1234semaaa" into username field
    And The user user logs search button

  Scenario: Verify UserName Filter -Valid Unique UserName
    And The user enters "Yana" into username field
    And The user user logs search button

  Scenario: Verify UserName Filter -Valid Unique UserName
    And The user enters "Yana" into username field
    And The user clicks Reset button user

  Scenario: Verify UserName Filter -Valid Unique UserName
    And The user enters "Yana" into username field
    And The user clicks Refresh button user

  Scenario: Verify UserEmail Filter -Valid Unique UserName
    And The user enters "yana@efectura.com" into logs userEmail field

  Scenario: Verify Result Filter -Valid Unique Result
    And The user enters "Succes" into logs result field

  Scenario:Users Overview Verify First Page Button Unclickable Condition
    And  The user verifies first page button is not clickable-users logs

  Scenario:Users Overview Verify Previous Page Button Unclickable Condition
    And  The user verifies previous page button is not clickable-users logs

  Scenario:Users Overview Verify Item next Button Unclickable Condition
    When The user clicks last page button-users logs
    And  The user verifies next button is not clickable-users logs
  
  Scenario Outline:Users Logs -User selects different options for show entries
    When  The user selects "<entries>" into show entries users logs
    Then  The user should see  "<entries>" entrie in everypage users logs
    Examples:
      | entries|
      |10 |
      |25 |