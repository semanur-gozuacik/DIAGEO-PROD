@regression
Feature: User Management Test Cases- Contact Home Page
  Background:
    When   The User opens the browser with the given url
    And   The User inputs a valid username "validUsername"
    And   The User inputs a valid password "validPassword"
    And   The User clicks the Submit button
    Given  The user navigate to "https://diageo.efectura.com/Enrich/Items?itemType=Product"
    And   The User gets the current URL and stores it in "itemType=Product"

  Scenario:Product Verify export button
    When  The user clicks on Export button

  Scenario Outline: Product Home Page User selects different options for show entries
    When  The user selects "<entries>" into show entries
    Then  The user should see  "<entries>" entrie in everypage
    Examples:
      | entries|
      |10 |
      |25 |

  Scenario:Product Home Page Verify First Page Button Unclickable Condition
    And  The user verifies first page button is not clickable

  Scenario:Product Home Page Verify Previous Page Button Unclickable Condition
    And  The user verifies previous page button is not clickable

  Scenario: User Reset Button Control
    And The user enters "SA075VIR0123" into "Açıklama" filter text input box
    And The user clicks on Edit Button
    And the user clicks on Reset button

  Scenario:Product Home Page Verify Label Filter - Invalid  Label
    And The user enters "SA075VIR0123aa" into "Açıklama" filter text input box
    And The user clicks on Edit Button
    And the user verify on code filter functionality  with invalid unique code "Eşleşen kayıt bulunamadı"

  Scenario:Product edit -Digital Varlıklar Associated
    And The user enters "SA075VIR0123" into "Açıklama" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Dijital Varlıklar" tab
    And The user Assocaited All filter

  Scenario:Product  edit - Digital Varlıklar Tab Associated Filter No
    And The user enters "SA075VIR0123" into "Açıklama" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Dijital Varlıklar" tab
   And The user Assocaited No filter
    Then The user verify No Filter

  Scenario:Product edit -Web Resimleri Associated
    And The user enters "SA075VIR0123" into "Açıklama" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Web Resimleri" tab
    And The user Assocaited All filter

  Scenario:Product  edit - Web Resimleri Tab Associated Filter No
    And The user enters "SA075VIR0123" into "Açıklama" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Web Resimleri" tab
    And The user Assocaited No filter
    Then The user verify No Filter

  Scenario:Product edit -Yorumlar Tab
    And The user enters "SA075VIR0123" into "Açıklama" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Yorumlar" tab

  Scenario:Product edit -Ürün ETkinlik İLişkisi Associated
    And The user enters "SA075VIR0123" into "Açıklama" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Ürün-Etkinlik İLişkisi" tab

  Scenario:Product  edit - Kullanıcı İzinleri
    And The user enters "SA075VIR0123" into "Açıklama" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Kullanıcı İzinleri" tab

  Scenario:Product edit - İlişki Dosyalar Önizleme Tab Control
    And The user enters "SA075VIR0123" into "Açıklama" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Dosyalar Önizleme" tab

  Scenario:Group Permission Verify Item First Page Button Unclickable Condition
    And The user enters "SA075VIR0123" into "Açıklama" filter text input box
    And The user clicks on Edit Button
    And clicks group permission tab

  Scenario:Group Permission Verify Item Previous Page Button Unclickable Condition
    And The user enters "SA075VIR0123" into "Açıklama" filter text input box
    And The user clicks on Edit Button
    And clicks group permission tab
    And  The user verifies previous page button is not clickable asset

  Scenario:Product edit - İlişki Dosyalar Önizleme Tab Control
    And The user enters "SA075VIR0123" into "Açıklama" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Training File_TR" tab

  Scenario:Product edit - İlişki Dosyalar Önizleme Tab Control
    And The user enters "SA075VIR0123" into "Açıklama" filter text input box
    And The user clicks on Edit Button
    And The user clicks "MRP Surbey_TR" tab

  Scenario:Product edit - İlişki Dosyalar Catalog Tab Control
    And The user enters "SA075VIR0123" into "Açıklama" filter text input box
    And The user clicks on Edit Button
    And The user clicks "PRODUCT_CATALOG" tab