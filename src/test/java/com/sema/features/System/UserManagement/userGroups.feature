Feature: Users Management User Logs  Test Cases
  Background:
    When  The User opens the browser with the given url
    And   The User inputs a valid username "validUsername"
    And   The User inputs a valid password "validPassword"
    And   The User clicks the Submit button
    Then  The User waits until the System element is visible with a timeout of 120 seconds
    Given The user on the settings user groups page
   # And   The User gets the current URL and stores it in "UserGroups"

  Scenario: Users Groups tables verification
    Then The User verifies User groups table is displayed

  Scenario: Users Groups tables create new
    Then The User verifies User groups create new button
    Then The User "sema"
    Then The User create button

  Scenario: Users Groups Delete Button
    Then The user groups filter "GROUP_TEST"
    Then The User reset button
    Then The user verifies reset button functionality user groups

  Scenario: Users Groups Edit Button
    Then The user groups filter "GROUP_TEST"
    Then The user edit button user groups
    Then The user user groups edit verifies

  Scenario: Users Groups Edit Button Users Tab  "All"filter
    Then The user groups filter "GROUP_TEST"
    Then The user edit button user groups
    Then The user user groups edit verifies
    Then The user Users tab
    Then The user "All"filter

  Scenario: Users Groups Edit Button Users Tab No Filter
    Then The user groups filter "GROUP_TEST"
    Then The user edit button user groups
    Then The user user groups edit verifies
    Then The user Users tab
    Then The user "No"filter

  Scenario: Users Groups Edit Button Users Tab username filter
    Then The user groups filter "GROUP_TEST"
    Then The user edit button user groups
    Then The user user groups edit verifies
    Then The user Users tab
    Then the user username filter "test@gmail.com"
    Then The user verifies username filter

  Scenario: Users Groups Edit Button Users Tab - User select
    Then The user groups filter "GROUP_TEST"
    Then The user edit button user groups
    Then The user user groups edit verifies
    Then The user Users tab
    Then The user select checkbox button user groups
    Then the user groups save button

    Scenario: Users Groups Export Button
    Then The user groups filter "GROUP_TEST"
    Then The user export button user groups

   Scenario: Users Groups Delete Button
    Then The user groups filter "sema"
    Then The User delete button

  Scenario Outline:Users Overview-User selects different options for show entries
    When  The user selects "<entries>" into show entries user groups
    Then  The user should see  "<entries>" entrie in everypage users groups
    Examples:
      | entries|
      |10 |
      |25 |
  Scenario:Users Overview Verify First Page Button Unclickable Condition
    And  The user verifies first page button is not clickable-users groups

  Scenario:Users Overview Verify Previous Page Button Unclickable Condition
    And  The user verifies previous page button is not clickable-users groups

  Scenario:Users Overview Verify Item next Button Unclickable Condition
    When The user clicks last page button-users groups
    And  The user verifies next button is not clickable-users groups