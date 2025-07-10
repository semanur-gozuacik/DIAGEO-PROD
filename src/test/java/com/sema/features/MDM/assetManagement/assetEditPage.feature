
Feature: Asset Management Test Cases- Asset Home Page Edit
  Background:
    When   The User opens the browser with the given url
    And    The User inputs a valid username "validUsername"
    And    The User inputs a valid password "validPassword"
    And    The User clicks the Submit button
    Given The user is on the Asset item home page
    And   The User gets the current URL and stores it in "itemType=Asset" Asset page


  Scenario Outline: Edit item status "<ItemStatus>" Item Statuses - cancel button-Asset
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And The user clicks on Edit Button
    And the user selects "<ItemStatus>"
      # And the user clicks on unsaved change button
       #And The user enters "-------" in  comment area
       #And The user clicks cancel button
      # And the user verifies item status not change

    Examples:
      |ItemStatus |
      |Active     |
      |Passive    |
      |Approved   |
      |On Hold    |
      |Running    |
     # |Draft    |

  Scenario Outline: Edit item status "<ItemStatus>" Item Statuses- save button
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And The user clicks on Edit Button
    And the user selects "<ItemStatus>"
      # And the user clicks on unsaved change button
       #And The user enters "-------" in  comment area
      # And The user clicks save button
      # And the user verifies item status success message

    Examples:
      |ItemStatus |
      |Active     |
      |Passive    |
      |Approved   |
      |On Hold    |
      |Running    |
      |Draft    |

  Scenario: Edit item added list
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks list drop down button
   #  And  The user clicks new list item
   #  Then The user verifies item is added

  Scenario: Edit item removed list
    And  The user enters "TEST123456" into Code field
    And  the user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks removed button
  #   Then The user verifies item is removed

  # Scenario: Edit item removed list all elements
   # And The user enters "TEST123456" into Code field
  #  And the user clicks on Search button
   # And  The user clicks on Edit Button
    #And  The user clicks list drop down button
    #And  The user clicks new list item
    #Then The user verifies item is added
    #And The user waits ten seconds
   # And  The user clicks list drop down button
   # And  The user clicks new list second item
   #And The user waits ten seconds
    #And  The user clicks list drop down button
  #  Then The user verifies item is added allItem

    Scenario:Group Permission Verify Item First Page Button Unclickable Condition
     And The user enters "TEST123456" into Code field
     And the user clicks on Search button
     And  The user clicks on Edit Button
    And clicks group permission tab
  #  And  The user verifies previous button is not clickable asset

  Scenario:Group Permission Verify Item Previous Page Button Unclickable Condition
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    And  The user verifies previous page button is not clickable asset

  Scenario:Group Permission Verify Item next Button clickable Condition
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks next page button asset
    And  The user verifies next button is clickable asset

  Scenario:Group Permission Verify Previous Page Button clickable Condition
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks next page button asset
    When The user clicks next page button asset
    When The user clicks previous page button asset
    And  The user verifies previous button is clickable asset

  Scenario:Group Permission Verify Last Page Button clickable Condition
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks last page button asset
    And  The user verifies last button is clickable asset

  Scenario:Group Permission Verify Last Page Button Unclickable Condition
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks last page button asset
    And  The user verifies last button is unclickable asset

  Scenario:Group Permission Verify Item next Button unclickable Condition
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks last page button asset
    And  The user verifies next button is unclickable asset

  Scenario:Group Permission Verify Item First Page Button Clickable Condition
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks last page button asset
    #And  The user verifies first page button is clickable asset

    Scenario:User Permission Verify Item First Page Button Unclickable Condition
      And The user enters "TEST123456" into Code field
      And the user clicks on Search button
      And  The user clicks on Edit Button
      And clicks user permission tab
      And  The user verifies first page button is not clickable user

  Scenario:User Permission Verify Item Previous Page Button Unclickable Condition
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    And  The user verifies previous page button is not clickable user

  Scenario:User Permission Verify Item next Button clickable Condition
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    When The user clicks next page button user
    And  The user verifies next button is clickable user


  Scenario:User Permission Verify Previous Page Button clickable Condition
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    When The user clicks next page button user
    When The user clicks next page button user
    When The user clicks previous page button user
    And  The user verifies previous button is clickable user

  Scenario:User Permission Verify Last Page Button clickable Condition
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    When The user clicks last page button user
    And  The user verifies last button is clickable user

  Scenario:User Permission Verify Last Page Button Unclickable Condition
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    When The user clicks last page button user
    And  The user verifies last button is unclickable asset

  Scenario:User Permission Verify Item next Button unclickable Condition
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    When The user clicks last page button user
    And  The user verifies next button is unclickable user

  Scenario:User Permission Verify Item First Page Button Clickable Condition
    And The user enters "TEST123456" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    When The user clicks last page button user
    And  The user verifies first page button is clickable user

  Scenario:Asset edit -Item Comment Tab
    And The user enters "Asset_19" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "ItemComment" tab
    #Then The user verifies itemComment tab details is displayed

  Scenario:Asset edit - Categories Tab
    And The user enters "Asset_19" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Categories" tab

  Scenario:Asset edit - History Tab
    And The user enters "Asset_19" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "History" tab

  Scenario:Asset edit - ACCOUNT_COOLER Tab
    And The user enters "Asset_19" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "ACCOUNT_COOLER" tab

  Scenario:Asset edit - ACCOUNT_COOLER Tab Associated
    And The user enters "Asset_19" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "ACCOUNT_COOLER" tab
    And The user Assocaited All filter
    And The user clicks item
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message

  Scenario:Asset edit -ACCOUNT_COOLER Tab Associated Filter No
    And The user enters "Asset_19" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "ACCOUNT_COOLER" tab
    And The user Assocaited No filter
    Then The user verify No Filter

  Scenario:Asset edit -Attributes Tab
    And The user enters "Asset_19" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Attributes" tab
