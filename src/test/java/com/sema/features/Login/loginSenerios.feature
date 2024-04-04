@regression @login
Feature: MDM Session Verification

  Background:
    Given I am on the MDM login page

  Scenario Outline: Attempt to Open a Session
    When I enter the username "<username>" and password "<password>"
    And click on the login button
    Then I should see the message "<expectedResult>"

    Examples:
      | username           | password         | expectedResult       |
      | invalidUsername    | validPassword    | session opening error |
      | validUsername      | invalidPassword  | session opening error |
      | validUsername      |                  | session opening error |
      |                    | invalidPassword  | session opening error empty|
      |                    | validPassword    | session opening error empty|
      |                    |                  | session opening error empty|
      | invalidUsername    | invalidPassword  | session opening error |
      | invalidUsername    | validPassword    | session opening error |
      | invalidUsername    |                  | session opening error |
      | validUsername      | validPassword    | successful login      |

  Scenario: Verify sign in with Microsoft button functionality
    When The user clicks sign in with microsoft button
    Then  The User gets the current URL and stores it in "https://login.microsoftonline.com/efectura0.onmicrosoft.com"

