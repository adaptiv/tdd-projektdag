# language: sv
Egenskap: Räkna filmer
  1. Som filmsamlare
  kan jag se hur många filmer jag har
  för att få en grundläggande överblick på mitt filminnehav.
  Kommentar: T.ex. via kommando "count".
  Kommentar: Initiera biblioteket med en given filmlista.

  Scenario: Räkna filmer i ett tomt filmbibliotek
    Givet att filmbiblioteket är tomt
    När jag räknar antalet filmer
    Så kommer resultatet vara: "0"

  Scenario: Räkna filmer i ett populerat filmbibliotek
    Givet att filmbiblioteket innehåller 3 filmer
    När jag räknar antalet filmer
    Så kommer resultatet vara: "3"
