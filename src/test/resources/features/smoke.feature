Feature: Smoke Test Pack
    In order to check main functionality
    I want to use navigation links on home page

    @Positive
    @Smoke
    Scenario Outline: Top navigation links checking
    Given on main page
    When click on top link "<navlink>"
      And wait for page to be loaded
    Then url "<navurl>" is opened
      And title is "<title>"

    Examples:
        |navlink|navurl|title|
        |Jobb|https://jobb.blocket.se/?ca=11&w=|Blocket Jobb - Lediga jobb|
        |Alla annonser|https://www.blocket.se/stockholm?ca=11| Stockholm | Blocket |
        |Bostad|https://www.blocket.se/bostad/saljes?ca=11&w=|Köp bostad i Stockholm - Blocket Bostad|
        |Fordon|https://www.blocket.se/stockholm/fordon?ca=11&cg=1000|Fordon|
        |Kundservice|https://blocket.zendesk.com/hc/sv|Kundservice|
        |Lägg in annons|https://www.blocket.se/ai/form/0?ca=11|Lägg in annons|

  @Negative
  @Smoke
  Scenario Outline: Verify Page Meddelanden incorrect login message
    Given on main page
    When click on top link "<navlink>"
    When url "<navurl>" is opened
    And enter login "<login>"
    And enter password "<password>"
    And click login button
    Then verify Error message "<error>"
    And url "<navurl>" is opened

      Examples:
        |navlink|navurl|login|password|error|
        |Meddelanden|https://login.schibsted.com/flow/login/|wrong@wrong.com|incorrectpass|Just den här kombinationen av e-postadress och lösenord finns inte.|
