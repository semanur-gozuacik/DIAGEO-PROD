Feature: Users Management Test Cases
  Background:
    When  The User opens the browser with the given url
    And   The User inputs a valid username "validUsername"
    And   The User inputs a valid password "validPassword"
    And   The User clicks the Submit button
    Then  The User waits until the System element is visible with a timeout of 120 seconds
    Given The user on the settings users page
    And   The User gets the current URL and stores it in "UserManage"

  Scenario: Users Overview tables verification
    Then The User verifies User Overview table is displayed

  Scenario Outline:Users Overview-User selects different options for show entries
    When  The user selects "<entries>" into show entries users
    Then  The user should see  "<entries>" entrie in everypage users
    Examples:
      | entries|
      |10 |
      |25 |
      |50 |
      |100|

  Scenario:Users Overview Verify First Page Button Unclickable Condition
    And  The user verifies first page button is not clickable-users

  Scenario:Users Overview Verify Previous Page Button Unclickable Condition
    And  The user verifies previous page button is not clickable-users

  Scenario:Users Overview Verify Item next Button Unclickable Condition
    When The user clicks last page button-users
    And  The user verifies next button is not clickable-users

  Scenario: Users Overview Verify Last Page Button Unclickable Condition
    When The user clicks last page button-users
    And  The user verifies last page button is not clickable-users

  Scenario:Users Overview Verify First Page Button Clickable Condition
    When The user clicks last page button-users
    And  The user verifies first page button is clickable-users

  Scenario:Users Overview Verify Previous Page Button Clickable Condition
    When The user clicks last page button-users
    And  The user verifies previous page button is clickable-users

  Scenario:Users Overview Verify Item next Button Clickable Condition
    And  The user verifies next button is clickable-users

  Scenario:Users Overview Verify Last Page Button Clickable Condition
    And  The user verifies last page button is clickable-users

  Scenario: Verify UserName Filter -Valid Unique UserName
    And The user enters "testtest99" into username field
    And the user verify on username filter functionality "testtest99"

  Scenario: Verify UserName Filter -Valid Partial UserName
    And The user enters "test" into username field
    And the user verify on username filter functionality "test"-partial username

  Scenario: Verify UserName Filter -Invalid Unique UserName
    And The user enters "1234semaaa" into username field
    And the user verify on username filter functionality "No matching records found"-invalid username


  Scenario: Verify UserEmail Filter -Valid Unique UserName
    And The user enters "yana@efectura.com" into userEmail field
    And the user verify on userEmail filter functionality "yana@efectura.com"

  Scenario: Verify UserEmail Filter -Valid Partial UserName
    And The user enters "test" into userEmail field
    And the user verify on username filter functionality "test"-partial username

  Scenario: Verify UserEmail Filter -Invalid Unique UserName
    And The user enters "1234semaaa" into userEmail field
    And the user verify on username filter functionality "No matching records found"-invalid username

  Scenario: Verify First Name Filter -Valid Unique UserName
    And The user enters "98765" into first name field
    And the user verify on first name filter functionality "98765"

  Scenario: Verify First Name Filter -Valid Partial UserName
    And The user enters "98" into first name field
    And the user verify on first name filter functionality "98"-partial first name

  Scenario: Verify First Name Filter -Invalid Unique UserName
    And The user enters "1234semaaa" into first name field
    And the user verify on username filter functionality "No matching records found"-invalid first name

  Scenario Outline: Filter "<Is Real>" Is Real
    And The user clicks on Is Real
     And The user clicks on "<Is Real>" Is Real
   # And The incoming filter for "<Is Real>" should contain Is Real
    Examples:
      |Is Real  |
      |Enable      |
      |Disable     |

  Scenario: Reset Button Control
    And The user clicks on Is Real
    And The user clicks on "Enable" Is Real
    And the user clicks on Reset button
    And the user verify Reset button functionality-Users

