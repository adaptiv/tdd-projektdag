# language: sv
Egenskap: Lägga till filmer
  2. Som filmsamlare
  kan jag registrera en ny film till samlingen
  för att kunna utöka mitt innehav.
  Kommentar: T.ex. via kommando "add Alien 1979".

  Scenario: Registrera en film till samlingen
    Givet att filmbiblioteket är tomt
    När jag lägger till filmen "Alien" från 1979
    Och jag räknar antalet filmer
    Så kommer resultatet vara: "1"
