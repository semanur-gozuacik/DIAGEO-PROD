@dia_smoke_prod
Feature: MDM Smoke

  Background:
    When  The User opens the browser with the given url
    And   The User inputs a valid username "fatihUsername"
    And   The User inputs a valid password "fatihPassword"
    And   The User clicks the Submit button

  Scenario: Verify My Contact Button
    Given The user go to 'Contact' overview page
    When The user clicks My Contact button
    And The User gets the current URL and stores it in "ItemType=37&isFavorite=true"
    And The user verifies its contacts is displayed

  Scenario: Verify Code Filter -Valid Unique Code
    Given The user go to 'Contact' overview page
    And The user enters "5528401017" into "Fletum Kod" filter text input box
    Then The user verify "Fletum Kod" text filter with value "5528401017" in "overviewTable"

  Scenario: Verify Phone Number Filter
    Given The user go to 'Contact' overview page
    And The user enters "505740" into "Telefon Numarası" filter text input box
    Then The user verify "Telefon Numarası" text filter with value "505740" in "overviewTable"

  Scenario:Contact edit -Önizleme Tab
    Given The user go to 'Contact' overview page
    And The user enters "5528401017" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Önizleme" tab

  Scenario:Contact edit - Özellikler Tab
    Given The user go to 'Contact' overview page
    And The user enters "5528401017" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Özellikler" tab

  Scenario:Contact edit - MRP_CONTACT Tab
    Given The user go to 'Contact' overview page
    And The user enters "5528401017" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And The user clicks "MRP_CONTACT" tab

  Scenario:Contact edit - Kullanıcı Logları Tab
    Given The user go to 'Contact' overview page
    And The user enters "5528401017" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Kullanıcı Logları" tab

  Scenario: Account Home Page Reset Button Control
    Given The user go to 'Account' overview page
    And The user enters "test2123" into "Fletum Kod" filter text input box
#    And The user enters "test2123" into Code field
    And The user reset the basic filters
#    And the user clicks on Reset button
    And The user verify Reset button func for "Fletum Kod" text filter
#    And the user verify Reset button functionality

  Scenario:Account Home Page Verify Previous Page Button Clickable Condition
    Given The user go to 'Account' overview page
    When The user clicks 'next' pagination button
    And  The user verifies "previous" button is "Active"

  Scenario: Account Home Page Map Control
    Given The user go to 'Account' overview page
    When The user click map tab
    Then The user verify map is visible

  Scenario: Account Home Page Category Tree Control
    Given The user go to 'Account' overview page
    Given The user verify category tree is visible

  Scenario:Account edit - Önizleme Tab
    Given The user go to 'Account' overview page
    And The user enters "999999999" into "Son Müşteri Kodu" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Önizleme" tab

  Scenario:Account edit - Özellikler Tab
    Given The user go to 'Account' overview page
    And The user enters "999999999" into "Son Müşteri Kodu" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Özellikler" tab

  Scenario:Account edit - Siparişler Tab
    Given The user go to 'Account' overview page
    And The user enters "999999999" into "Son Müşteri Kodu" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Siparişler" tab
    Then The user verify 'siparislerTable' table is visible

  Scenario:Account edit - Faturalar Tab
    Given The user go to 'Account' overview page
    And The user enters "999999999" into "Son Müşteri Kodu" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Faturalar" tab
    Then The user verify 'faturalarTable' table is visible

  Scenario:Account edit - Kişiler Tab Filter Control
    Given The user go to 'Account' overview page
    And The user enters "999999999" into "Son Müşteri Kodu" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Kişiler" tab
    Then The user verify 'associationTable' table is visible
    And The user enters "test" into "İsim" filter text input box
    Then The user verify "İsim" text filter with value "test" in "associationTable"

  Scenario:Account edit - Komşu Tab Filter Control
    Given The user go to 'Account' overview page
    And The user enters "999999999" into "Son Müşteri Kodu" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Komşu" tab
    Then The user verify 'associationTable' table is visible
    And The user enters "999999" into "Son Müşteri Kodu" filter text input box

  Scenario:Account edit - Sorumlu Tab Filter Control
    Given The user go to 'Account' overview page
    And The user enters "999999999" into "Son Müşteri Kodu" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Sorumlu" tab
    Then The user verify 'associationTable' table is visible
    And The user enters "test" into "Açıklama" filter text input box
    Then The user verify "Açıklama" text filter with value "test" in "associationTable"

  Scenario: Event Home Page Etkinlik Adı Filter Control
    Given The user go to 'Event' overview page
    And The user enters "D Maris" into "Etkinlik Adı" filter text input box
    Then The user verify "Etkinlik Adı" text filter with value "D Maris" in "overviewTable"

  Scenario: Event Home Page Takvim Tab Verify
    Given The user go to 'Event' overview page
    When The user click event tab
    Then The user verify calendar is visible

  Scenario:Event edit - Önizleme Tab
    Given The user go to 'Event' overview page
    And The user clicks on Edit Button
    And The user clicks "Önizleme" tab

  Scenario:Event edit - Özellikler Tab
    Given The user go to 'Event' overview page
    And The user clicks on Edit Button
    And The user clicks "Özellikler" tab

  Scenario:Event edit - Yorumlar Tab
    Given The user go to 'Event' overview page
    And The user clicks on Edit Button
    And The user clicks "Yorumlar" tab

  Scenario:Asset edit - ACCOUNT_COOLER Tab Associated
    Given The user go to 'Event' overview page
    And The user enters "Etkinlik-3568666" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Dijital İçerik" tab
#    And The user Assocaited All filter
    And The user select "Hayır" in "IsAssociated" select filter
#    And The user clicks item
    And The user select item at order 1 in association tab
    And The user clicks save button in edit item
    And The user enters "-------" in comment area
    And The user clicks save button in edit item save modal
    Then The user verifies info "Değişiklikler başarıyla kaydedildi." appears
    And the user unassociate the item
    And The user select item at order 1 in association tab
    And The user clicks save button in edit item
    And The user enters "-------" in comment area
    And The user clicks save button in edit item save modal
    Then The user verifies info "Değişiklikler başarıyla kaydedildi." appears

  Scenario: Event Import Button Redirection Control
    Given The user go to 'Event' overview page
    And The user clicks on Edit Button
    When The user click import redirect button
    Then The user verify import page is open

  Scenario: Product Verify Code Filter -Valid Unique Code
    Given The user go to 'Product' overview page
    And The user enters "RA070TE037" into "Fletum Kod" filter text input box
    Then The user verify "Fletum Kod" text filter with value "RA070TE037" in "overviewTable"

  Scenario:Product edit - PRODUCT_CATALOG Tab Control
    Given The user go to 'Product' overview page
    And The user enters "RA070TE037" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Katalog" tab
    Then The user verify 'associationTable' table is visible

  Scenario:Product edit - Dijital Varlıklar Tab Control
    Given The user go to 'Product' overview page
    And The user enters "RA070TE037" into "Fletum Kod" filter text input box
    And The user clicks on Edit Button
    And The user clicks "Dijital Varlıklar" tab
    Then The user verify 'associationTable' table is visible

  Scenario: Sales Organization Verify Code Filter -Valid Unique Code
    Given The user go to 'SalesOrganization' overview page
    And The user enters "Salih Onur" into "Fletum Kod" filter text input box
    Then The user verify "Fletum Kod" text filter with value "Salih Onur" in "overviewTable"

  Scenario:Sales Organization edit - Satış Organizasyonu Kullanıcı Tab Control
    Given The user go to 'SalesOrganization' overview page
    And The user clicks on Edit Button
    And The user clicks "Satış Organizasyonu Kullanıcı" tab
    Then The user verify 'associationTable' table is visible

  Scenario: User Verify Code Filter -Valid Unique Code
    Given The user go to 'MRP' overview page
    And The user enters "test" into "Fletum Kod" filter text input box
    Then The user verify "Fletum Kod" text filter with value "test" in "overviewTable"

  Scenario:User edit - Planlı Ziyaretler Tab Control
    Given the user go in the item '3578662'
    And The user clicks "Planlı Ziyaretler" tab
    Then The user verify 'plannedVisitsTable' table is visible

  Scenario:User edit - Önizleme Tab Control
    Given the user go in the item '3578662'
    And The user clicks "Önizleme" tab

  Scenario:User edit - Rotalar Tab Control
    Given the user go in the item '3578662'
    And The user clicks "Rotalar" tab
    Then The user verify 'associationTable' table is visible

  Scenario:User edit - Satış Organizasyonu Kullanıcı Tab Control
    Given the user go in the item '3578662'
    And The user clicks "Satış Organizasyonu Kullanıcı" tab
    Then The user verify 'associationTable' table is visible

  Scenario: Event Calendar Management
    When The user go to Calendar page
    Then The user verify calendar page is open

  Scenario: ReportCardAnalysis Control
    When The user go to ReportCardAnalysis page
    Then The user verify table is displayed

  Scenario: Reserve Karne Analyis Control
    When The user go to reserve karne
    Then The user verify reserve karne

  Scenario: Reserve Karne Enis Control
    When The user impersonate Enis
    When The user go to reserve karne
    Then The user verify reserve karne

  Scenario: User Manage Username Filter Check
    Given The user go to User Manage page
    And The user enters "akt" into "UserName" filter text input box
    Then The user verify "UserName" text filter with value "akt" in "fletumUserTable"

# --------------------------------------------------------------------------------
  Scenario:  Görev Listesi - Verify "Search All" Button Control
    When The user go to task list
    When The user enters 'Haktan Kaçar' into search all
    Then The user verify "Oluşturan" text filter with value "Haktan Kaçar" in "taskListTable"

  Scenario:  Görev Listesi - Form Redirect Control
    When The user go to task list
    When The user enters 'off' into search all
    When The user click first row
    Then The user verify form is open

  Scenario: Form Start Button Navigate Control
    Given The user go to "panel" page
    Given The user go in "Modül Akışı" flow
    Then The user verify flow start page is open

  Scenario: Process Detail navigation control
    Given The user go to "panel" page
    When The user go in 'Modül Akışı' flow history
    Then The  user verify history page is open

  Scenario: Menu and Modul Reports Controls
    Given The user go to Reports page
    When The user select 'MenuTrackingReports' report
    Then The user verify 'reportTable' table is visible
    When The user select 'ModuleTrackingReports' report
    Then The user verify 'reportTable' table is visible

  Scenario: Import Screen Control
    Given The user go to Imports page
    Then The user verify 'importOverviewTable' table is visible

  Scenario: DB Module Monitor Screen Control
    Given The user go to DB module page
    Then The user verify 'dbModuleTable' table is visible

  Scenario: Jobs Screen Control
    Given The user go to Jobs page
    Then The user verify job page is open

  Scenario: AI Assistance
    Given The user go to edit item
    When The user click ai button
    Then The user verify ai modal

  Scenario: Rota AI Assistance
    Given The user go to rota edit item
    When The user click nba ai button
    Then The user verify ai modal

  Scenario: NBA Tables
    Given The user go to edit item
    When The user click 'NBA' tab
    When The user take screenshot

  Scenario: Comment Meeting Notes
    Given The user go to edit item '3568666'
    And The user clicks "Yorumlar" tab
    When The user click add comment button
    When The user select comment type 'Toplantı Notu'
    When The user select first yetkili option 'İSTANBUL TEKEL-BERAT AKÇİN - 999999999 - test sema sema'
    When The user select second yetkili option 'Semanur Gozuacik'
    When The user click send comment button
    Then The user verifies info "MailSended" appears
    Then The user delete the comment
    Then The user verifies info "Yorum başarıyla silindi." appears


  Scenario: Chat Scenarios
    Given The user go to edit item '3568666'
    When The user mention '@kgu' in chat
    Given The user login with "kgu"
    Then The user verify notification
    Then The user verify link


  Scenario: EmbedDashboardCalendar
    Given The user go to EmbedDashboardCalendar
    When The user verify 'No Data'
    When The user take screenshot for EmbedDashboardCalendar

  Scenario: Calender Scenarios
    Given The user go to calender page
    Then The user verify calendar

  Scenario: Event-File Assoc
    Given The user go to 'Event' overview page
    When The User clicks on the createButton element

  Scenario: MY 360 Redirection
    When The user go to MY360 page
    When The user select customer 'AKIN BÜFE -- 965005'
    Then The user take screenshot for my
    When The user wait 15 seconds
    And The user clicks "Ziyaret Listesi" tab
    When The user wait 25 seconds
    Then The user verify 'visitListTable' table is visible

  Scenario: Support Mail Test
    When The user click support button
    When The user fill support inputs
    When The user upload support file
    When The user click send ticket button
    Then The user verifies info "Ticket Başarıyla Gönderildi" appears
    Then The user verify mail is sent

  Scenario: Global Search
    When The user search in global input

  Scenario: Transaction Tables Export
#    Given The user go to edit item '3495770'
#    And The user clicks "TRX_ICHEDEF_PLANLAMA" tab
#    When The user click 'Dışarı Aktar' button
#    When The user get selected export options
#    When The user complete the export
#    When The user wait 1 second
#    Then The user verifies info "Başarılı" appears
#    When The user wait 1 second
#    Then The user verify file is downloaded
#    When The user wait 8 second
    Given The user go to edit item '1782611'
    And The user clicks "Faturalar" tab
    When The user wait 20 second
    When The user click 'Dışarı Aktar' button
    When The user get selected export options
    When The user complete the export
    Then The user verifies info "Başarılı" appears
    When The user wait 1 second
    Then The user verify file is downloaded
    And The user clicks "Siparişler" tab
    When The user wait 20 second
    When The user click 'Dışarı Aktar' button
    When The user get selected export options
    When The user complete the export
    Then The user verifies info "Başarılı" appears
    When The user wait 1 second
    Then The user verify file is downloaded








