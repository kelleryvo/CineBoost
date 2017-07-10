
                          CineBoost 2017

  What is it?
  -----------

  Als Lernprodukt wird ein vollständiges Projekt erwartet. Dabei ist das bei den Designübungen er- arbeitet Kinobuchungssystem (KBS) zu implementieren.
  Von diesem KBS müssen im Rahmen der Analyse und Design die zentralen Aufgaben mit Use- Cases dargestellt und 
  davon Szenarios erarbeitet und verfeinert werden. Dabei soll das CRC- Verfahren für die Klassenfindung und 
  deren Beziehungen untereinander angewendet werden. Die zugrundeliegende Architektur und deren Umsetzung mit 
  Entwurfsmuster muss durch ent- sprechende UML-Diagramme dargestellt und beschrieben werden.

  The Latest Version
  ------------------

  Details von den aktuellsten Versionen kann man in eine Git-Repository
  anschauen und herunterladen. Folgender Link:
  https://github.com/kelleryvo/CineBoost

  Documentation
  -------------

  Die Dokumentation ist als Word Datei abgespeichert.
  Unter docs/ befindet sich alle aktuelle Dokumentationen.
  Folgender Link:
  https://github.com/kelleryvo/CineBoost/tree/master/docs

  Installation
  ------------

  Folgende Libraries werden genutzt:
  - mysql-connector-java-5.1.38-bin.jar
    Webseite: http://www.java2s.com/Code/Jar/m/Downloadmysqlconnectorjava5123binjar.htm

  Das Projekt wurde in InteliJ IDEA von JetBrains implementiert:
  - Webseite: https://www.jetbrains.com/idea/

  Für das Projekt nutzen wir Java SDK 1.8.0_101.
  - Download: http://www.oracle.com/technetwork/java/javase/downloads/index.html

  SQL Database
  --------
  
  Der SQL Dump befindet sich auch im Git-Repository.
  SQL Dump in einem Webservie importieren und man hat die ganze Datenbank Struktur
  plus Testdaten.

  Folgende Tabellen befinden sich in diesem Dump:
  ┌ CinemaHall
  |--- id
  |--- cinemaHallName
  └--- screen

  ┌ Movie
  |--- id
  |--- name
  |--- productionsYear
  |--- movieDescription
  |--- genre
  |--- trailer
  |--- fsk
  |--- duration
  |--- movieRating
  |--- director
  └--- actor

  ┌ Offer
  |--- id
  |--- movie_FK
  |--- title
  |--- cinemahall_FK
  |--- movieStart
  |--- movieLanguage
  └--- dimension

  ┌ Offer_Seat
  |--- id
  |--- offer_FK
  └--- seat_FK

  ┌ Reservation
  |--- id
  └--- ticket_FK

  ┌ Seat
  |--- id
  |--- cinemaHall_FK
  |--- seatRow
  └--- seatNr

  ┌ Staff
  |--- id
  |--- name
  |--- surname
  |--- birthdate
  |--- username
  └--- password

  ┌ Tickets
  |--- id
  |--- visitor_fk
  |--- staff_fk  
  |--- offer_fk  
  └--- seat_fk

  ┌ Visitor
  |--- id
  |--- name
  |--- surname
  |--- birthdate
  |--- email
  |--- password
  |--- adress
  |--- postcode
  |--- debitcardNumber
  └--- discount

