@regression
Feature: User Management Test Cases- Contact Home Page
  Background:
    When   The User opens the browser with the given url
    And   The User inputs a valid username "validUsername"
    And   The User inputs a valid password "validPassword"
    And   The User clicks the Submit button
    Given  The user navigate to "https://diageo.efectura.com/Enrich/Items?itemType=MRP"
    And   The User gets the current URL and stores it in "itemType=MRP"


  Scenario Outline: User Home Page User selects different options for show entries
    When  The user selects "<entries>" into show entries
    Then  The user should see  "<entries>" entrie in everypage
    Examples:
      | entries|
      |10 |
      |25 |
      |50 |
      |100|
      |250|

  Scenario:User Home Page Verify export button
    When  The user clicks on Export button
  #  Then  The user verify that the export was "Success"

  Scenario:User Home Page Verify First Page Button Unclickable Condition
    And  The user verifies first page button is not clickable

  Scenario:User Home Page Verify Previous Page Button Unclickable Condition
    And  The user verifies previous page button is not clickable

  Scenario:User Home Page Verify Item next Button Unclickable Condition
    When The user clicks last page button
    And  The user verifies next button is not clickable

  Scenario:User Home Page Verify Last Page Button Unclickable Condition
    When The user clicks last page button
   # And  The user verifies last page button is not clickable

  Scenario:User Home Page Verify First Page Button Clickable Condition
    When The user clicks last page button
    And  The user verifies first page button is clickable

  Scenario:User Home Page Verify Previous Page Button Clickable Condition
    When The user clicks last page button
    And  The user verifies previous page button is clickable

  Scenario:User Home Page Verify Item next Button Clickable Condition
    And  The user verifies next button is clickable

  Scenario:User Home Page Verify Last Page Button Clickable Condition
    And  The user verifies last page button is clickable

  Scenario: User Reset Button Control
    And The user enters "test2123" into Code field
    And the user clicks on Reset button
    And the user verify Reset button functionality

  Scenario:User Home Page Verify Label Filter - Invalid  Label
    And The user enters "sema12345" into Label field
    And the user clicks on Search button
    And the user verify on code filter functionality  with invalid unique code "Eşleşen kayıt bulunamadı"

  Scenario: User Home Page edit verify
    And The user enters "test" into Code field
    And the user clicks on Search button
    And The user clicks on Edit Button

  Scenario Outline: Edit item status "<ItemStatus>" Item Statuses - cancel button
    And The user enters "test" into Code field
    And the user clicks on Search button
    And The user clicks on Edit Button
    And the user selects "<ItemStatus>"
    #And the user clicks on unsaved change button
    #And The user enters "-------" in  comment area
   # And The user clicks cancel button
    #And the user verifies item status not change

    Examples:
      |ItemStatus |
      |Aktif     |

  Scenario Outline: Edit item status "<ItemStatus>" Item Statuses- save button
    And The user enters "test" into Code field
    And the user clicks on Search button
    And The user clicks on Edit Button
    And the user selects "<ItemStatus>"
  #  And the user clicks on unsaved change button
  # # And The user enters "-------" in  comment area
   # And The user clicks save button
   # And the user verifies item status success message

    Examples:
      |ItemStatus |
      |Aktif     |
      |Pasif    |

  Scenario:User edit -Özellikler tab control
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Özellikler" tab

  Scenario:User edit -Kullanıcı Logları tab control
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kullanıcı Logları" tab

  Scenario:User edit -Kullanıcı control
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kullanıcı" tab

  Scenario:User edit -Müşteri tab control
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Müşteri" tab

  Scenario:User edit -Eğitim-Kullanıcı tab control
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Eğitim-Kullanıcı" tab

  Scenario:User edit -Kullanıcı-Dijital Varlık control
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kullanıcı-Dijital Varlık" tab

  Scenario:User edit -Kullanıcı-Anket tab control
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kullanıcı-Anket" tab


  Scenario:Group Permission Verify Item First Page Button Unclickable Condition
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    #And  The user verifies previous button is not clickable asset


  Scenario:Group Permission Verify Item Previous Page Button Unclickable Condition
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    And  The user verifies previous page button is not clickable asset


  Scenario:Group Permission Verify Item next Button clickable Condition
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks next page button asset

  Scenario: Group Permission Verify Previous Page Button clickable Condition
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks next page button asset

  Scenario: Group Permission Verify Last Page Button clickable Condition
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks last page button asset
    And  The user verifies last button is clickable asset

  Scenario: Group Permission Verify Last Page Button Unclickable Condition
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks last page button asset
    And  The user verifies last button is unclickable asset

  Scenario:Group Permission Verify Item next Button unclickable Condition
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks last page button asset
    And  The user verifies next button is unclickable asset

  Scenario:Group Permission Verify Item First Page Button Clickable Condition
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks group permission tab
    When The user clicks last page button asset
   # And  The user verifies first page button is clickable asset

  Scenario: User Permission Verify Item First Page Button Unclickable Condition
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    And  The user verifies first page button is not clickable user

  Scenario:User Permission Verify Item Previous Page Button Unclickable Condition
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    And  The user verifies previous page button is not clickable user

  Scenario:User Permission Verify Item next Button clickable Condition
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    When The user clicks next page button user
    And  The user verifies next button is clickable user

  Scenario:User Permission Verify Previous Page Button clickable Condition
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    When The user clicks next page button user
    When The user clicks next page button user
    When The user clicks previous page button user
    And  The user verifies previous button is clickable user

  Scenario:User Permission Verify Last Page Button clickable Condition
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    When The user clicks last page button user
    And  The user verifies last button is clickable user

  Scenario: User Permission Verify Last Page Button Unclickable Condition
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    When The user clicks last page button user
    And  The user verifies last button is unclickable asset

  Scenario:User Permission Verify Item next Button unclickable Condition
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    When The user clicks last page button user
    And  The user verifies next button is unclickable user

  Scenario: User Permission Verify Item First Page Button Clickable Condition
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And clicks user permission tab
    When The user clicks last page button user
    And  The user verifies first page button is clickable user

  Scenario:User edit Kullanıcı Resimleri Tab Export Button
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kullanıcı Resimleri" tab

  Scenario:User edit -Müşteri All Filter
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Müşteri" tab
    And The user Assocaited All filter
    And The user clicks item
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message

  Scenario:User edit -Müşteri tab No Filter
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Müşteri" tab
    And The user Assocaited No filter
    Then The user verify No Filter


  Scenario: User Export Entity Button - Attributes
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks Export Entity Button
    And The user clicks Export Attributes
    Then The user dowloand Export Entity verifies

  Scenario: User Export Entity Button - Associations
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks Export Entity Button
    And The user clicks Export Associations
    Then The user dowloand Export Entity verifies

  Scenario: User Export Entity Button - Permission
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks Export Entity Button
    And The user clicks Export Permission
    Then The user dowloand Export Entity verifies

  Scenario Outline:User edit -Kullanıcı - Dijital Varlık- Status Filter
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kullanıcı - Dijital Varlık" tab
    And The user selects edit item "<status>"
    Examples:
    |status|
    |Etkin|
    |Devre Dışı|

  Scenario Outline:User edit -Müşteri tab "<export>" button
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Müşteri" tab
    And The user clicks export button "<export>"
    Examples:
    |export|
    |Export Current View|
    |Export Detailed View|
    |Export All          |

  Scenario Outline: User edit -Kullanıcı Dijital Varlık tab -Family Filter
    And The user enters "test" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kullanıcı - Dijital Varlık" tab
    And The user clicks family filter
    And The user selects "<family>"
    Examples:
      |family|
      |İş Ortağı |
      |Afiş Kapağı|
      |Afiş       |
      |Eğitim Dökümanı|
      |Formlar|



