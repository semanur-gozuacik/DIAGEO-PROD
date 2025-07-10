@regression
Feature: Event Management Test Cases- Event Home Page
  Background:
    When   The User opens the browser with the given url
    And   The User inputs a valid username "validUsername"
    And   The User inputs a valid password "validPassword"
    And   The User clicks the Submit button
    Given The user is on the Event item home page
    And   The User gets the current URL and stores it in "itemType=Event"

  Scenario:Event Verify export button
    When  The user clicks on Export button

  Scenario:Event Home Page Verify First Page Button Unclickable Condition
    And  The user verifies first page button is not clickable

  Scenario:Event Home Page Verify Previous Page Button Unclickable Condition
    And  The user verifies previous page button is not clickable

  Scenario:Event Home Page Verify Item next Button Unclickable Condition
    When The user clicks last page button
    And  The user verifies next button is not clickable

  Scenario:Event Home Page Verify Last Page Button Unclickable Condition
    When The user clicks last page button
   # And  The user verifies last page button is not clickable

  Scenario:Event Home Page Verify First Page Button Clickable Condition
    When The user clicks last page button
    And  The user verifies first page button is clickable

  Scenario:Event Home Page Verify Previous Page Button Clickable Condition
    When The user clicks last page button
    And  The user verifies previous page button is clickable

  Scenario:Event Home Page Verify Item next Button Clickable Condition
    And  The user verifies next button is clickable

  Scenario:Event Home Page Verify Last Page Button Clickable Condition
    And  The user verifies last page button is clickable

  Scenario:Event Verify Label Filter - Invalid  Label
    And The user enters "Wset-1. Seviye Şarap SLT -Temmuz 2025--" into "Etkinlik Adı" filter text input box
    And The user clicks on Edit Button
    And the user verify on code filter functionality  with invalid unique code "Eşleşen kayıt bulunamadı"

  Scenario Outline: Event Home Page User selects different options for show entries
    When  The user selects "<entries>" into show entries
    Then  The user should see  "<entries>" entrie in everypage
    Examples:
      | entries|
      |10 |
      |25 |
      |50 |
      |100|
      |250|

  Scenario: Event page edit verify
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button

  Scenario Outline: Edit item status "<ItemStatus>" Item Statuses - cancel button
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And the user selects "<ItemStatus>"
      # And the user clicks on unsaved change button
      # And The user enters "-------" in  comment area
      # And The user clicks cancel button
       #And the user verifies item status not change

    Examples:
      |ItemStatus |
      |Aktif     |


  Scenario Outline: Edit item status "<ItemStatus>" Item Statuses- save button
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And the user selects "<ItemStatus>"

    Examples:
      |ItemStatus |
      |Aktif     |
      |Pasif    |

  Scenario: Edit item added list
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And  The user clicks list drop down button


  Scenario: Edit item removed list
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And  The user clicks removed button

  Scenario:Event edit - Özellikler Tab
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Özellikler" tab

  Scenario:Event edit - Kişiler Tab
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And  The user clicks on Edit Button
    And The user clicks "Kişiler" tab

  Scenario:Event edit - Kural Listesi Tab
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And  The user clicks on Edit Button
    And The user clicks "Kural Listesi" tab

  Scenario:Event edit - Katılım Takibi Tab
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user clicks "Katılım Takibi" tab

  Scenario:Event edit - Kit Tab
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user clicks "Kit" tab

  Scenario:Event edit - Çatı-Etkinlik Tab
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user clicks "İlgili Çatı" tab

  Scenario:Event edit - Sharing Tab
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user clicks "Sharing" tab

  Scenario: Verify My Count Star Item Functionality- One Contact
    And The user enters "event" into Code field
    And the user clicks on Search button
    And the user clicks on Star items
    And the user verify My Count badge count is correct

  Scenario: Event Home Page Reset Button Control
    And The user enters "test2123" into Code field
    And the user clicks on Reset button
    And the user verify Reset button functionality

  Scenario:Event edit - Lokasyon Tab
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user clicks "Dijital İçerik" tab

  Scenario:Contact edit -Lokasyon Tab Associated
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user Assocaited All filter
    And The user clicks item
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message

  Scenario:Contact edit -Dijital İçerik Tab Associated Filter No
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user Assocaited No filter
    Then The user verify No Filter

  Scenario:Event edit - Yorumlar Tab
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user clicks "Yorumlar" tab

  Scenario:Event edit - Kişiler Tab Associated
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user clicks "Kişiler" tab
    And The user Assocaited All filter

  Scenario:Event edit Kişiler Tab Associated Filter No Control
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user Assocaited No filter
    Then The user verify No Filter

  Scenario:Event edit - Tarihçe Tab
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user clicks "Tarihçe" tab

  Scenario:Event edit - Sharing Tab Associated Control
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user Assocaited All filter
    # And The user clicks item
    # And the user clicks on unsaved change button
     #And The user enters "-------" in  comment area
    # And The user clicks save button
     #And the user verifies item status success message

  Scenario:Event edit Sharing Tab Associated Filter No Control
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user Assocaited No filter
    Then The user verify No Filter

  Scenario:Event edit - Kategorier Tab Control
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user clicks "Kategorier" tab


  Scenario:Event edit - Lokasyon Tab Control
    And The user enters "Etkinlik-3528816" into "Fletum Kod" filter text input box
    And The user clicks "Lokasyon" tab