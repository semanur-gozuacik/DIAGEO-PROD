@regression
Feature: Contact Management Test Cases- Contact Edit Page
  Background:
    When   The User opens the browser with the given url
    And   The User inputs a valid username "validUsername"
    And   The User inputs a valid password "validPassword"
    And   The User clicks the Submit button
    Given  The user navigate to "https://diageo.efectura.com/Enrich/Items?itemType=Contact#"
    And   The User gets the current URL and stores it in "itemType=Contact"

  Scenario Outline: Edit item status "<ItemStatus>" Item Statuses- save button
    And The user enters "5528401017" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    Then The user verify Edit Page
    And the user selects "<ItemStatus>"
       #And the user clicks on unsaved change button
      # And The user enters "-------" in  comment area
      # And The user clicks save button
       #And the user verifies item status success message

    Examples:
      |ItemStatus |
      |Aktif     |
      |Pasif    |
      |Onaylı   |


  Scenario Outline: Edit item status "<ItemStatus>" Item Statuses - cancel button
    And The user enters "5528401017" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    Then The user verify Edit Page
    And the user selects "<ItemStatus>"


    Examples:
      |ItemStatus |
      |Pasif    |
      |Aktif     |


  Scenario: Edit item added list
    And The user enters "5528401017" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And  The user clicks list drop down button


  Scenario: Edit item removed list
    And The user enters "5528401017" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And  The user clicks removed button

  Scenario:Contact edit -Tarihçe Tab
    And The user enters "5528401017" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Tarihçe" tab

  Scenario:Contact edit -Kategoriler Tab
    And The user enters "5528401017" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Kategoriler" tab

  Scenario:Contact edit - Etkileşim Tab
    And The user enters "5528401017" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Üyelik" tab

  Scenario:Contact edit - Etkileşim Tab
    And The user enters "5528401017" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And The user clicks "MRP_CONTACT" tab

  Scenario:Contact edit -  Etkileşim Tab Associated
    And The user enters "5528401017" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Üyelik" tab
    And The user Assocaited All filter
    And The user clicks item
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message

  Scenario:Contact edit -Etkileşim Tab Associated Filter No
    And The user enters "Kişi-7733" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Etkileşim" tab
    And The user Assocaited No filter
    Then The user verify No Filter

  Scenario:Contact edit -İş Ortağı Tab
    And The user enters "Kişi-7733" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "İş Ortağı" tab

  Scenario:Contact edit - İş Ortağı Tab Associated
    And The user enters "Kişi-7733" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "İş Ortağı" tab
    And The user Assocaited All filter
    And The user clicks item
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message

  Scenario:Contact edit - İş Ortağı Tab Associated Filter No
    And The user enters "Kişi-7733" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "İş Ortağı" tab
    And The user Assocaited No filter
    Then The user verify No Filter

  Scenario:Contact edit - Kitler Tab
    And The user enters "Kişi-7733" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kitler" tab

  Scenario:Contact edit - Kitler Tab Associated
    And The user enters "Kişi-7733" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kitler" tab
    And The user Assocaited All filter
      # And The user clicks item
       #And the user clicks on unsaved change button
      # And The user enters "-------" in  comment area
      # And The user clicks save button
      # And the user verifies item status success message

  Scenario:Contact edit - Kitler Tab Associated Filter No
    And The user enters "Kişi-7733" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Kitler" tab
    And The user Assocaited No filter
   # Then The user verify No Filter

  Scenario:Contact edit -Özellikler Tab
    And The user enters "Kişi-7733" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Özellikler" tab

  Scenario:Contact edit - Sharing Tab
    And The user enters "Kişi-7733" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Sharing" tab

  Scenario:Contact edit - Sharing Tab Associated
    And The user enters "Kişi-7733" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Sharing" tab
    And The user Assocaited All filter
    And The user clicks item
    And the user clicks on unsaved change button
    And The user enters "-------" in  comment area
    And The user clicks save button
    And the user verifies item status success message

  Scenario:Contact edit -Sharing Tab Associated Filter No
    And The user enters "Kişi-7733" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Sharing" tab
    And The user Assocaited No filter
    Then The user verify No Filter


  Scenario:Contact edit -Preview Tab Export Button
    And The user enters "Kişi-7733" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks "Önizleme" tab
    And The user clicks Export PDF button
    Then The user verifies the file is downloaded

  Scenario:Contact edit -Preview Tab Refresh  Button
    And  The user enters "Kişi-7733" into Code field
    And  the user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks "Önizleme" tab
    And  The user clicks Refresh button
    Then The user verifies refresh button

  Scenario: Contact Export Entity Button -Özellikler
    And The user enters "Kişi-7733" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks Export Entity Button
    And The user clicks Export Attributes
    Then The user dowloand Export Entity verifies

  Scenario: Contact Export Entity Button - İlişki
    And The user enters "Kişi-7733" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks Export Entity Button
    And The user clicks Export Associations
    Then The user dowloand Export Entity verifies

  Scenario: Contact Export Entity Button - Permission
    And The user enters "Kişi-7733" into Code field
    And the user clicks on Search button
    And  The user clicks on Edit Button
    And The user clicks Export Entity Button
    And The user clicks Export Permission
    Then The user dowloand Export Entity verifies
@testtt
  Scenario Outline: İş Ortağı Associated Tab Status Fılter "<Status>"
    And The user enters "Kişi-7733" into Code field
    And  the user clicks on Search button
    And  The user clicks on Edit Button
    And  The user clicks "İş Ortağı" tab
    And  The user clicks Associated status
    And  The user selects  "<Status>"
    Then The user verifies displayed "<Status>" is correct
    Examples:
      |Status|
      |Status:All|
      |Enabled   |
      |Disabled  |
