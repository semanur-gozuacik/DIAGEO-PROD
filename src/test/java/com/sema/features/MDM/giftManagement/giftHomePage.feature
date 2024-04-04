@regression
Feature: Gift Creation and Management Home Page
  Background:
    When   The User opens the browser with the given url
    And   The User inputs a valid username "validUsername"
    And   The User inputs a valid password "validPassword"
    And   The User clicks the Submit button
    Given  The user navigate to "https://diageo.efectura.com/Enrich/Items?itemType=Gift"
    And   The User gets the current URL and stores it in "itemType=Gift"

  Scenario:Gift Verify export button
    When  The user clicks on Export button

  Scenario:Gift Home Page Verify First Page Button Unclickable Condition
    And  The user verifies first page button is not clickable

  Scenario:Gift Home Page Verify Previous Page Button Unclickable Condition
    And  The user verifies previous page button is not clickable

  Scenario:Gift Verify Label Filter - Invalid  Label
    And The user enters "sema12345" into Label field
    And the user clicks on Search button
    And the user verify on code filter functionality  with invalid unique code "Eşleşen kayıt bulunamadı"

  Scenario Outline: Gift Home Page User selects different options for show entries
    When  The user selects "<entries>" into show entries
    Then  The user should see  "<entries>" entrie in everypage
    Examples:
      | entries|
      |10 |
      |25 |

  Scenario: Gift page edit verify
    And The user enters "Hediye-02" into Code field
    And the user clicks on Search button
    And The user clicks on Edit Button

  Scenario Outline:Gift Edit item status "<ItemStatus>" Item Statuses- save button
    And The user enters "Hediye-02" into Code field
    And the user clicks on Search button
    And The user clicks on Edit Button
    And the user selects "<ItemStatus>"
      # And the user clicks on unsaved change button
      # And The user enters "-------" in  comment area
       #And The user clicks save button
      # And the user verifies item status success message

    Examples:
      |ItemStatus |
      |Pasif     |
      |Taslak    |

  Scenario:Gift edit - Sertifika Tab
    And The user enters "Hediye-02" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Sertifika" tab

  Scenario:Gift edit - Hediye - Dijital İçerik Tab Associated
    And The user enters "Hediye-02" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Hediye - Dijital İçerik" tab
    And The user Assocaited All filter
    And The user clicks item
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message

  Scenario:Gift edit -Hediye - Dijital İçerik Tab Associated Filter No
    And The user enters "Hediye-02" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Hediye - Dijital İçerik" tab
    And The user Assocaited No filter
    Then The user verify No Filter

  Scenario:Kişiler Associated Tab Code Filter Functionality
    And The user enters "Hediye-02" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Hediye - Dijital İçerik" tab
    And The user clicks on code filter Filter
    # And The user enters "1310202301"
    Then The user verifies that code filter functionality

  Scenario:Gift edit - Etkileşim Tab Associated
    And The user enters "Hediye-02" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Etkileşim" tab
    And The user Assocaited All filter
    And The user clicks item
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message

  Scenario:Gift edit Etkileşim Tab Associated Filter No
    And The user enters "Hediye-02" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Etkileşim" tab
    And The user Assocaited No filter
    Then The user verify No Filter

  Scenario:Gift edit Kişiler Tab Associated
    And The user enters "Hediye-02" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kişiler" tab
    And The user Assocaited All filter

  Scenario:Gift edit -Kişiler Tab Associated Filter No
    And The user enters "Hediye-02" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kişiler" tab
    And The user Assocaited No filter
    Then The user verify No Filter
