@semaaa
Feature: Sales Organization Management Test Cases- Connector Home Page
  Background:
    When   The User opens the browser with the given url
    And    The User inputs a valid username "validUsername"
    And    The User inputs a valid password "validPassword"
    And   The User clicks the Submit button
    Given  The user navigate to "https://diageo.efectura.com/Enrich/Items?itemType=SalesOrganization"
    And   The User gets the current URL and stores it in "itemType=SalesOrganization"

  Scenario:Sales Organization Verify Label Filter - Valid Label
    And The user enters "0204test" into Label field
    And the user clicks on Search button
    And the user verify on label filter functionality with partial unique code "0204test"

  Scenario: Sales Organization Verify Label Filter - Partial Unique Label
    And The user enters "selçuk" into Label field
    And the user clicks on Search button
    And the user verify on label filter functionality with partial unique code "selçuk"

  Scenario:Sales Organization Verify Code Filter -Valid Unique Code
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And the user verify on code filter functionality "2655724"-connector

  Scenario:Sales Organization Verify Code Filter -Valid partial Code
    And The user enters "265" into Code field
    And the user clicks on Search button
    And the user verify on code filter functionality with partial unique code "265"-connector

  Scenario: Reset Button Control
    And The user enters "2655724" into Code field
    And the user clicks on Reset button
    And the user verify Reset button functionality-connector

  Scenario Outline: Sales Organization Home Page User selects different options for show entries
    When  The user selects "<entries>" into show entries
    Then  The user should see  "<entries>" entrie in everypage
    Examples:
      | entries|
      |10 |
      |25 |
      |50 |
      |100|
      |250|

   # And   The user
   #  Scenario: Verify export button
   #    When  The user clicks on Export button
   #    Then  The user verify that the export was "Success" verify that the file is located in the downloads folder
    #And   The user verify that the file is in the correct format

  Scenario:Sales Organization Page Verify First Page Button Unclickable Condition
    And  The user verifies first page button is not clickable

  Scenario:Sales Organization Page Verify Previous Page Button Unclickable Condition
    And  The user verifies previous page button is not clickable

  Scenario:Sales Organization Page Verify Item next Button Unclickable Condition
    When The user clicks last page button
    And  The user verifies next button is not clickable

  Scenario: Sales Organization Page Verify Last Page Button Unclickable Condition
    When The user clicks last page button
    And  The user verifies last page button is not clickable

  Scenario:Sales Organization Page Verify First Page Button Clickable Condition
    When The user clicks last page button
    And  The user verifies first page button is clickable

  Scenario:Sales Organization Page Verify Previous Page Button Clickable Condition
    When The user clicks last page button
    And  The user verifies previous page button is clickable

  Scenario:Sales Organization Page Verify Item next Button Clickable Condition
    And  The user verifies next button is clickable

  Scenario: Sales Organization Page Verify Last Page Button Clickable Condition
    And  The user verifies last page button is clickable

  Scenario: Create List- create button
    And  The user clicks plus icon
    Then The user verifies New List pop up is open
    When The user enters "otomasyon" List Name
    #And  The user enters "_5458429214" Can view
   # And  The user enters "1757483988_5392786463" Can edit
   # And The user clicks create button-New List
    #Then The user verifies "otomasyon" is visible
  @sales
  Scenario: Create List- create button-exist user
    And  The user clicks plus icon
    Then The user verifies New List pop up is open
    When The user enters "Sematestyeni" List Name
  #  And  The user enters "_5458429214" Can view
   # And  The user enters "1757483988_5392786463" Can edit
   # And  The user clicks create button-New List
   # Then The user verifies error message "USER_LIST_ALREADY_EXISTS" is displayed

  Scenario: Create List- delete list-cancel button
    And The user selects deleted element-asset
  #  And The user clicks cancel button in delete popup-asset
   # Then The user verifies "otomasyon" is visible

  Scenario: Create List- delete list
    And The user selects deleted element-asset
   # And The user clicks cancel button in delete popup-asset
   # And The user clicks delete button in delete popup
   # Then The user verifies "otomasyon" is not visible
  @sales
  Scenario: Sales Organization page edit verify
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And The user clicks on Edit Button
    Then The user verify Edit Page-Connector
  @sales
  Scenario: Verify Sales Organization Star Item Functionality- One Contact
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And the user clicks on Star items
    And the user verify My Count badge count is correct
  @sales
  Scenario: Verify Sales Organization  Items Functionality- more than One Contact
    And The user enters "265" into Code field
    And the user clicks on Search button
    And the user clicks on Star items
    And the user verify My Count badge count is correct
  @sales
  Scenario:Sales Organization edit -Attributes Tab
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Attributes" tab
  @sales
  Scenario:Sales Organization edit -ItemComment Tab
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Özellikler" tab
  @sales
  Scenario:Sales Organization edit -Categories Tab
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kategoriler" tab
  @sales
  Scenario: Sales Organization Edit item added list
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
  #  And  The user clicks list drop down button
 #   And  The user clicks new list item-connector
   # Then The user verifies item is added
  @sales
  Scenario: Sales Organization Edit item removed list
    And  The user enters "2655724" into Code field
    And  the user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks removed button
    Then The user verifies item is removed
  @sales
  Scenario:Sales Organization Group Permission Verify Item First Page Button Unclickable Condition
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    # And  The user verifies previous button is not clickable asset

  @sales
  Scenario:Sales Organization Group Permission Verify Item Previous Page Button Unclickable Condition
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    And  The user verifies previous page button is not clickable asset
  @sales
  Scenario:Sales Organization Group Permission Verify Item next Button clickable Condition
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks next page button asset
    And  The user verifies next button is clickable asset
  @sales
  Scenario:Sales Organization Group Permission Verify Previous Page Button clickable Condition
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks next page button asset
    When The user clicks next page button asset
    When The user clicks previous page button asset
    And  The user verifies previous button is clickable asset
  @sales
  Scenario:Connector Group Permission Verify Last Page Button clickable Condition
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks last page button asset
    And  The user verifies last button is clickable asset
  @sales
  Scenario:Connector Group Permission Verify Last Page Button Unclickable Condition
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks last page button asset
    And  The user verifies last button is unclickable asset
  @sales
  Scenario:Connector Group Permission Verify Item next Button unclickable Condition
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks last page button asset
    And  The user verifies next button is unclickable asset
  @sales
  Scenario:Connector Group Permission Verify Item First Page Button Clickable Condition
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks last page button asset
    #And  The user verifies first page button is clickable asset
  @sales
  Scenario:Connector User Permission Verify Item First Page Button Unclickable Condition
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    #And  The user verifies first page button is not clickable user

  @sales
  Scenario:Connector User Permission Verify Item Previous Page Button Unclickable Condition
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    And  The user verifies previous page button is not clickable user

  @sales
  Scenario:Connector User Permission Verify Item next Button clickable Condition
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    When The user clicks next page button user
    And  The user verifies next button is clickable user
  @sales
  Scenario:Connector User Permission Verify Previous Page Button clickable Condition
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    When The user clicks next page button user
    When The user clicks next page button user
    When The user clicks previous page button user
    And  The user verifies previous button is clickable user

  @sales
  Scenario:Connector User Permission Verify Last Page Button clickable Condition
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    When The user clicks last page button user
    And  The user verifies last button is clickable user

  @sales
  Scenario:Connector User Permission Verify Last Page Button Unclickable Condition
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    When The user clicks last page button user
    And  The user verifies last button is unclickable asset
  @sales
  Scenario:Connector Edit item status Passive Item Status-cancel button
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And The user clicks on Edit Button
    And the user selects "Passive"
      # And the user clicks on unsaved change button
      # And The user enters "-------" in  comment area
       #And The user clicks cancel button
      # And the user verifies item status not change
  @sales
  Scenario:SalesOrganization  Edit item status Passive  Item Status- save button
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And The user clicks on Edit Button
    And the user selects "Passive"
     #  And the user clicks on unsaved change button
      # And The user enters "-------" in  comment area
      # And The user clicks save button
      # And the user verifies item status success message
  @sales
  Scenario:SalesOrganization  edit -History Tab
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Satış Saha" tab
  @sales
  Scenario:SalesOrganization edit - Kişiler Tab Associated
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Satış Saha" tab
    And The user Assocaited All filter
    And The user clicks item
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message
  @sales
  Scenario:SalesOrganization edit -Kişiler Tab Associated Filter No
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Satış Saha" tab
    And The user Assocaited No filter
    Then The user verify No Filter
  @sales
  Scenario:SalesOrganization  edit -History Tab
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Satış Organizasyonu Kullanıcı" tab
  @sales
  Scenario:SalesOrganization edit - Kişiler Tab Associated
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Satış Organizasyonu Kullanıcı" tab
    And The user Assocaited All filter
    And The user clicks item
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message
  @sales
  Scenario:SalesOrganization edit -Kişiler Tab Associated Filter No
    And The user enters "2655724" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Satış Organizasyonu Kullanıcı" tab
    And The user Assocaited No filter
    Then The user verify No Filter
