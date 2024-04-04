
Feature: Contact Management Test Cases Create Home Page
  Background:

    When   The User opens the browser with the given url
    And   The User inputs a valid username "validUsername"
    And   The User inputs a valid password "validPassword"
    And   The User clicks the Submit button
    Then   The User waits until the MDM element is visible with a timeout of 15 seconds
    Given  The user navigate to "https://diageo.efectura.com/Enrich/Items?itemType=Contact#"
    And   The User gets the current URL and stores it in "itemType=Contact"

  Scenario: Create Contact on Fletum with invalid family
    And   The User clicks on the createItem element
    And   The User clicks on the Categories element
    And   The User clicks on the Contact Categories element
    And   The User clicks on the new node element Contact
    And   The User clicks on the createButton element
    Then  The User waits until the page contains "EMPTY_FAMILY" with a timeout of 15 seconds

  Scenario: Create Contact on Fletum without Categories-EKOSYSTEM
    And   The User clicks on the createItem element
    Then The User waits until the uniqueCode element is visible with a timeout of 15 seconds
    And   The User inputs the value from cont into the inputCode field
    And   The User presses the down arrow key and then presses Enter in the "Ekosystem" element
    And   The User clicks on the createButton element
    Then  The User waits until the page contains "Please choose categories" text with a timeout of 15 seconds

  Scenario Outline: Create Contact on Fletum with valid credentials - "<Family>"
    And   The User clicks on the createItem element
    Then The User waits until the uniqueCode element is visible with a timeout of 15 seconds
    And   The User inputs the value from cont into the inputCode field
    And   The User presses the down arrow key and then presses Enter in the "<Family>" element
    And  The user enters a DIA_FirstName "sematest" input fields
    And  The user enters a Surname "gözüaçık"" input fields
    And  The User clicks on the Categories element
    Then The User waits until the  Contact element is visible with a timeout of 15 seconds
    And  The User clicks on the Contact Categories element
    And   The User clicks on the new node element Contact
    And  The User clicks on the createButton element
    Then The User waits until the page contains "Changes saved succesfully." with a timeout of 15 seconds
    Examples:
      |Family|
      |Ekosystem|

  Scenario Outline: Delete Contact on Fletum with valid credentials - "<Family>"-cancel button
    And  The user enters "199955523515555" into Code field
    And  the user clicks on Search button
    And  The user clicks delete button- "<Family>"
    And  The user clicks cancel button in popup
    Examples:
      |Family|
      |Ekosystem|
      |IWSA     |

  Scenario Outline: Delete Contact on Fletum with valid credentials - "<Family>"
    And  The user enters "<Number>" into Code field
    And  the user clicks on Search button
    And  The user clicks delete button- "<Family>"
    And  The user clicks delete button in popup
    Then The User waits until the page contains "Item Deleted Succesfully." with a timeout of 15 seconds-Asset
    Examples:
      |Family   | Number        |
      |Ekosystem|199955523515555|
      |IWSA     |testcontact2322|

  Scenario Outline: Create Contact on Fletum with valid credentials - "<Family>"
    And   The User clicks on the createItem element
    Then The User waits until the uniqueCode element is visible with a timeout of 15 seconds
    And   The User inputs the "testcontact2322" from cont into the inputCode field
    And   The User presses the down arrow key and then presses Enter in the "<Family>" element
    And  The user enters a DIA_FirstName "sematest" input fields
    And  The user enters a Surname "gözüaçık"" input fields
    And  The User clicks on the Categories element
    Then The User waits until the  Contact element is visible with a timeout of 15 seconds
    And  The User clicks on the Contact Categories element
    And   The User clicks on the new node element Contact
    And  The User clicks on the createButton element
    Then The User waits until the page contains "Changes saved succesfully." with a timeout of 15 seconds
    Examples:
      |Family|
      |IWSA|