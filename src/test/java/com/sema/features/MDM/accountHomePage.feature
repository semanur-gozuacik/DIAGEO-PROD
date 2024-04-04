@regression
Feature: Account Management Test Cases- Account Home Page
  Background:
    When   The User opens the browser with the given url
    And   The User inputs a valid username "validUsername"
    And   The User inputs a valid password "validPassword"
    And   The User clicks the Submit button
    Given  The user navigate to "https://diageo.efectura.com/Enrich/Items?itemType=Account"
    And   The User gets the current URL and stores it in "itemType=Account"


  Scenario:Account Verify export button
    When  The user clicks on Export button

  Scenario Outline: Account Home Page User selects different options for show entries
    When  The user selects "<entries>" into show entries
    Then  The user should see  "<entries>" entrie in everypage
    Examples:
      | entries|
      |10 |
      |25 |
      |50 |
      |100|
      |250|

  Scenario: Account Home Page Reset Button Control
    And The user enters "test2123" into Code field
    And the user clicks on Reset button
    And the user verify Reset button functionality

  Scenario:Account Home Page Verify First Page Button Unclickable Condition
    And  The user verifies first page button is not clickable

  Scenario:Account Home Page Verify Previous Page Button Unclickable Condition
    And  The user verifies previous page button is not clickable

  Scenario:Account Home Page Verify Item next Button Unclickable Condition
    When The user clicks last page button
    And  The user verifies next button is not clickable

  Scenario:Account Home Page Verify Last Page Button Unclickable Condition
    When The user clicks last page button
   # And  The user verifies last page button is not clickable

  Scenario:Account Home Page Verify First Page Button Clickable Condition
    When The user clicks last page button
    And  The user verifies first page button is clickable

  Scenario:Account Home Page Verify Previous Page Button Clickable Condition
    When The user clicks last page button
    And  The user verifies previous page button is clickable

  Scenario:Account Home Page Verify Item next Button Clickable Condition
    And  The user verifies next button is clickable

  Scenario:Account Home Page Verify Last Page Button Clickable Condition
    And  The user verifies last page button is clickable

  Scenario: Account page edit verify
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And The user clicks on Edit Button

  Scenario Outline:Account Edit item status "<ItemStatus>" Item Statuses - cancel button
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And The user clicks on Edit Button
    And the user selects "<ItemStatus>"
   # And the user clicks on unsaved change button
   # And The user enters "-------" in  comment area
  #  And The user clicks cancel button
    #And the user verifies item status not change

    Examples:
      |ItemStatus |
      |Aktif     |
      |Pasif    |
     #  |Approved     |

  Scenario Outline:Account Edit item status "<ItemStatus>" Item Statuses- save button
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And The user clicks on Edit Button
    And the user selects "<ItemStatus>"
   # And the user clicks on unsaved change button
   # And The user enters "-------" in  comment area
   # And The user clicks save button
   # And the user verifies item status success message

    Examples:
      |ItemStatus |
      |Onaylı     |
      |Aktif    |
      |On Hold_tr     |
      |Pasif     |


  Scenario:Account edit -Önizleme Tab
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Önizleme" tab

  Scenario:Account edit -Özellikler Tab
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Özellikler" tab

  Scenario:Account edit -Sorumlu Tab
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Sorumlu" tab

  Scenario:Account edit - Sorumlu Tab Associated
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Sorumlu" tab
    And The user Assocaited All filter
    And The user clicks item
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message

  Scenario:Account edit -Sorumlu Tab Associated Filter No
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Sorumlu" tab
    And The user Assocaited No filter
    Then The user verify No Filter

  Scenario:Account edit -Siparişler Tab
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Siparişler" tab

  Scenario:Account edit -Ziyaretler Tab
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Ziyaretler" tab

  Scenario:Account edit -Faturalar Tab
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Faturalar" tab

  Scenario:Account edit -Ziyaret Listesi Tab
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Ziyaret Listesi" tab

  Scenario:Account edit -Categories Tab
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kategoriler" tab

  Scenario:Account edit -History Tab
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Tarihçe" tab

  Scenario:Account edit - Kişiler Tab Associated
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kişiler" tab
    And The user Assocaited All filter
    And The user clicks item
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message

  Scenario:Account edit -Kişiler Tab Associated Filter No
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kişiler" tab
    And The user Assocaited No filter
    Then The user verify No Filter

  Scenario:Account edit - Etkileşim Tab Associated
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Etkileşim" tab
    And The user Assocaited All filter
    And The user clicks item
   And the user clicks on unsaved change button
   And The user enters "-------" in  comment area
   And The user clicks save button
 #  And the user verifies item status success message

  Scenario:Account edit - Etkileşim Tab Associated Filter No
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Etkileşim" tab
    And The user Assocaited No filter
    Then The user verify No Filter

  Scenario:Account edit -Önizleme Tab Export Button
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Önizleme" tab
    And The user clicks Export PDF button
    Then The user verifies the file is downloaded

  Scenario:Account edit -Benzer Nokta Tab
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Benzer Nokta" tab

    Scenario: Account Associated Tab Associated On Fılter
      And The user enters "222093" into Code field
      And the user clicks on Search button
      And  The user clicks on Edit Button
      And The user clicks "Kişiler" tab
      And The user clicks Associated on filter
     And  The user enters "09.01.2024" info from field
      And The user enters "09.01.2024" info to field
      And The user clicks update button
     Then The user verifies that associated on filter functionality

  Scenario: Account Associated Tab Label Filter Functionality
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Sorumlu" tab
    And The user clicks on Label Filter
  #   And The user enters "test_umit"
    Then The user verifies that labet filter functionality

  Scenario: Account Associated Tab Families  Fılter
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kişiler" tab
   And The user associated selects "IWSA" families filter
    Then The user verifies that families filter functionality

  Scenario Outline: Account Kişiler Status Fılter "<Status>"
    And The user enters "222093" into Code field
    And  the user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks "Kişiler" tab
    And The user selects edit item "<status>"
    Examples:
      |status|
      |Etkin|
      |Devre Dışı|

  Scenario: Account Associated Tab Code Filter Functionality
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kişiler" tab
    And The user clicks on code filter Filter
   #  And The user enters "test_umit"
    Then The user verifies that code filter functionality

  Scenario: Account Associated Tab Code Filter Reset
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kişiler" tab
    And The user clicks on code filter Filter
   #  And The user enters "test_umit"
    And  The user clicks Reset button
    Then The user verifies that code filter reset button functionality

  Scenario Outline: Sorumlu Associated Tab Status Fılter "<Status>"
    And The user enters "222093" into Code field
    And  the user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks "Sorumlu" tab
    And The user selects edit item "<status>"
    Examples:
      |status|
      |Etkin|

  Scenario: Account Export Entity Button - Attributes
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks Export Entity Button
    And The user clicks Export Attributes
    Then The user dowloand Export Entity verifies

  Scenario: Account Export Entity Button - Associations
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks Export Entity Button
    And The user clicks Export Associations
    Then The user dowloand Export Entity verifies

  Scenario: Account Export Entity Button - Permission
    And The user enters "222093" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks Export Entity Button
    And The user clicks Export Permission
    Then The user dowloand Export Entity verifies



