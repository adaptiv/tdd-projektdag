# language: sv
Egenskap: Lista filmer
  3. Som filmsamlare
  kan jag lista alla filmer i mitt bibliotek
  för att få en överblick av mitt filminnehav.
  Kommentar: T.ex. via kommando "list".

  Scenario: Lista alla filmer i mitt bibliotek
    Givet att jag har en filmsamling
    När jag listar innehåller i filmbilioteket
    Så kommer den innehålla samtliga filmer

  Scenario: Se vilka filmer som är utlånade i filmlistan
    Givet att jag har en filmsamling
    Och jag lånat ut en film
    När jag listar innehåller i filmbilioteket
    Så kommer den innehålla samtliga filmer
    Och den utlånade filmen kommer vara markerad som utlånad
