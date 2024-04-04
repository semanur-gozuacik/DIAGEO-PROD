Feature: Gift Creation and Management
  Background:
    When   The User opens the browser with the given url
    And   The User inputs a valid username "validUsername"
    And   The User inputs a valid password "validPassword"
    And   The User clicks the Submit button
    Then   The User waits until the MDM element is visible with a timeout of 120 seconds
    And   The User performs a mouseover on the MDM element
    And   The User performs a mouseover on the Gift Management element
    And   The User performs a mouseover on the Gift element
    And   The User clicks on the Gİft element
    And   The User gets the current URL and stores it in "itemType=Gift"
    Then   The User waits until the createItem element is visible with a timeout of 120 seconds
    And   The User clicks on the createItem element
    #And The user enters the same random string into the "2027" input field
    #And     And The user waits for the "2027" input field to be visible
    #And  The User presses the down arrow key and then presses Enter in the Choose Family element

  Scenario: Create Gift on Fletum invalid
    And   The User presses the down arrow key and then presses Enter in the Choose Family element
    And   The User clicks on the Categories element
    Then   The User waits until the ROOT element in the gift is visible with a timeout of 120 seconds
    And   The User clicks on the TEST element
    And   The User clicks on the createButton element
   # Then   The User waits until the page contains "EMPTY_FAMILY" with a timeout of 120 seconds

