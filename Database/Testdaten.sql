USE cineboost;

INSERT INTO Visitor (name,surname,birthdate,email,password,adress,postcode,debitcardNumber,discount) VALUES
('Vithun','Vamathevan','1998-12-14','vithun.vamathevan@gmail.com','test','Ringstrasse 121','8107','4000123456781234','0'),
('Brigitte','Schwartz','1938-07-10','brisch@cuvox.de','test','Wolfensbergstrasse 58','3762','4716332219668047','25'),
('Bernd','Schmitt','1941-06-23','BerndSchmitt@bluewin.com','test','Via Camischolas sura 142','4537','4929692836581896','20'),
('Kathrin','Ackerman','1987-09-10','KathrinAckerman@hotmail.dom','test','Kammelenbergstrasse 133','6073','4539750185086701','30'),
('Sebastian','Werfel','1993-10-12','SebastianWerfel@gmail.com','test','Bahnhofplatz 150','8852','4929934913730891','20');

INSERT INTO Staff (name,surname,birthdate,username,password) VALUES
('Dominik','Wildmeier','1955-03-13','CBAdmin00','test'),
('Julius','Milcher','1982-04-29','CBAdmin01','test'),
('Juergen','Tier','1923-02-20','CBAdmin02','test'),
('Simonetta','Winterrugga','1975-06-24','CBAdmin03','test'),
('Diego','Costa','1995-07-15','CBAdmin04','test');

INSERT INTO Movie (name,productionsyear,movieDescription,genre,trailer,fsk,duration,movieRating,director,actor) VALUES
('Lion',2017,'Der fünfjährige Inder Saroo steigt in den falschen Zug und landet 1600 Kilometer von zuhause entfernt in Kalkutta. Dort lebt er auf der Strasse, bis ihn ein australisches Paar adoptiert. 20 Jahre später findet Saroo via Internet zu seiner Familie zurück.','Drama','https://www.youtube.com/watch?v=-RNI9o06vqo','10/6','121','4.7','Garth Davis','Dev Patel, Nawazuddin Siddiqui. Nicole Kidman, Rooney Mara, Sunny Pawar'),
('Hanni&Nanni',2017,'Hanni und Nanni landen widerwillig im Internat Lindenhof. Sie beschliessen, so viel Unfug wie möglich anzustellen, damit sie schnell wieder von der Schule fliegen. Doch als Nanni neue Freunde findet, gehen die Zwillinge zum ersten Mal getrennte Wege.','Jugend, Kids & Family','https://www.youtube.com/watch?v=E8FVP_iL_dg','8/6','98','4.4','Isabell Suba','Jessica Schwarz, JoJo Putiloff, Laila Meinecke, Luise Wolfram, Rosa Meinecke, Sascha Vollmer, Tibor Locher'),
('Fluch der Karibik',2017,'Pirat Captain Jack Sparrows (Johnny Depp) Erzfeind Captain Salazar (Javier Bardem) macht mit einer Geisterarmee Jagd auf alle Piraten. Um seinen Kopf zu retten, muss Sparrow Poseidons Dreizack finden. Dieser garantiert die Kontrolle über die Weltmeere.','Abenteuer, Action, Komödie','https://www.youtube.com/watch?v=ewBd84EAdwQ','12','129','4.2','Epsen Sandberg, Joachim Ronning','Brenton Thwaites, David Wenham, Geoffrey Rush, Javier Bardem, Jessica Green, Johnny Depp, Kaya Scodelario, Keira Knightley, Orlando Bloom, Paul McCartney'),
('ALIEN: Covenant',2017,'Die Crew des Kolonienraumschiffs Covenant glaubt ein unentdecktes Paradies gefunden zu haben. Dabei stellt sich die Welt als gefährlicher Planet heraus, dessen einziger Bewohner der Androide David ist - der alleinige Überlebende der Prometheus Expedition.','Sci-Fi & Fantasy, Thriller','https://www.youtube.com/watch?v=svnAD0TApb8','16','122','3.6','Ridley Scott','Amy Seimetz, Billy Crudup, Carmen Ejogo, Danny McBride, Guy Pearce, James Franco, Katherine Waterston, Michael Fassbender, Noomi Rapace'),
('Wonder Woman',2017,'Die Amazonenprinzessin Diana wurde in einem abgelegenen Inselparadies zu einer mächtigen Kriegerin ausgebildet. Als sie von einem notgelandeten Piloten von den Konflikten im Rest der Welt erfährt, beginnt Diana an der Seite der Menschen zu kämpfen.','Abenteuer, Action, Sci-Fi & Fantasy','https://www.youtube.com/watch?v=VSB4wGIdDwo','14/12','141','4.5','Patty Jenkins','Chris Pine, Connie Nielsen, Danny Huston, David Thewlis, Gal Gadot, Robin Wright'),
('All Eyez On Me',2017,'Sein Tod mit nur 25 Jahren wurde nie aufgeklärt, doch seine Musik bleibt unvergesslich. Nun wird der Hip-Hop-Legende Tupac Shakur ein filmisches Denkmal gesetzt, das 2Pacs Musik, die Rivalität mit Notorious B.I.G. und seinen viel zu frühen Tod behandelt.','Biografie, Drama','https://www.youtube.com/watch?v=BaEQdDKvP5I','16','140','4.2','Benny Boom','Annie Ilonzeh, Danai Gurira, Demetrius Shipp Jr., Dominic L. Santana, Jamal Woolard, Kat Graham, Lauren Cohan, Rayan Lawrence');

INSERT INTO CinemaHall (cinemaHallName,screen) VALUES
('Saal 1','Small'),
('Saal 2','Medium'),
('Saal 3','Large');

INSERT INTO Offer (movie_FK,cinemahall_FK,title,movieStart,movieLanguage,dimension) VALUES
(1,1,'Montag','2017-07-19 13:17:00','Deutsch','3D'),
(2,2,'Dienstag','2017-07-19 13:17:00','Deutsch','2D'),
(3,3,'Mittwoch','2017-07-19 13:17:00','Deutsch','3D'),
(4,1,'Donnerstag','2017-07-19 13:17:00','Englisch','2D'),
(5,2,'Freitag','2017-07-19 13:17:00','Englisch','3D'),
(6,3,'Samstag','2017-07-19 13:17:00','Englisch','2D');

INSERT INTO Seat (cinemaHall_FK,seatRow,seatName,seatNr) VALUES
/* Saak 1 (Klein) 5X10 */
(1,1,'1A',1),(1,1,'2A',2),(1,1,'3A',3),(1,1,'4A',4),(1,1,'5A',5),(1,1,'6A',6),(1,1,'7A',7),(1,1,'8A',8),(1,1,'9A',9),(1,1,'10A',10),
(1,1,'1B',1),(1,1,'2B',2),(1,1,'3B',3),(1,1,'4B',4),(1,1,'5B',5),(1,1,'6B',6),(1,1,'7B',7),(1,1,'8B',8),(1,1,'9B',9),(1,1,'10B',10),
(1,1,'1C',1),(1,1,'2C',2),(1,1,'3C',3),(1,1,'4C',4),(1,1,'5C',5),(1,1,'6C',6),(1,1,'7C',7),(1,1,'8C',8),(1,1,'9C',9),(1,1,'10C',10),
(1,1,'1D',1),(1,1,'2D',2),(1,1,'3D',3),(1,1,'4D',4),(1,1,'5D',5),(1,1,'6D',6),(1,1,'7D',7),(1,1,'8D',8),(1,1,'9D',9),(1,1,'10D',10);
/* Saak 2 (Medium) 7X10
(2,1,1),(2,1,2),(2,1,3),(2,1,4),(2,1,5),(2,1,6),(2,1,7),(2,1,8),(2,1,9),(2,1,10),
(2,2,1),(2,2,2),(2,2,3),(2,2,4),(2,2,5),(2,2,6),(2,2,7),(2,2,8),(2,2,9),(2,2,10),
(2,3,1),(2,3,2),(2,3,3),(2,3,4),(2,3,5),(2,3,6),(2,3,7),(2,3,8),(2,3,9),(2,3,10),
(2,4,1),(2,4,2),(2,4,3),(2,4,4),(2,4,5),(2,4,6),(2,4,7),(2,4,8),(2,4,9),(2,4,10),
(2,5,1),(2,5,2),(2,5,3),(2,5,4),(2,5,5),(2,5,6),(2,5,7),(2,5,8),(2,5,9),(2,5,10),
(2,6,1),(2,6,2),(2,6,3),(2,6,4),(2,6,5),(2,6,6),(2,6,7),(2,6,8),(2,6,9),(2,6,10),
(2,7,1),(2,7,2),(2,7,3),(2,7,4),(2,7,5),(2,7,6),(2,7,7),(2,7,8),(2,7,9),(2,7,10),
*/
/* Saak 3 (Large) 7X10
(3,1,1),(3,1,2),(3,1,3),(3,1,4),(3,1,5),(3,1,6),(3,1,7),(3,1,8),(3,1,9),(3,1,10),
(3,2,1),(3,2,2),(3,2,3),(3,2,4),(3,2,5),(3,2,6),(3,2,7),(3,2,8),(3,2,9),(3,2,10),
(3,3,1),(3,3,2),(3,3,3),(3,3,4),(3,3,5),(3,3,6),(3,3,7),(3,3,8),(3,3,9),(3,3,10),
(3,4,1),(3,4,2),(3,4,3),(3,4,4),(3,4,5),(3,4,6),(3,4,7),(3,4,8),(3,4,9),(3,4,10),
(3,5,1),(3,5,2),(3,5,3),(3,5,4),(3,5,5),(3,5,6),(3,5,7),(3,5,8),(3,5,9),(3,5,10),
(3,6,1),(3,6,2),(3,6,3),(3,6,4),(3,6,5),(3,6,6),(3,6,7),(3,6,8),(3,6,9),(3,6,10),
(3,7,1),(3,7,2),(3,7,3),(3,7,4),(3,7,5),(3,7,6),(3,7,7),(3,7,8),(3,7,9),(3,7,10),
(3,8,1),(3,8,2),(3,8,3),(3,8,4),(3,8,5),(3,8,6),(3,8,7),(3,8,8),(3,8,9),(3,8,10),
(3,9,1),(3,9,2),(3,9,3),(3,9,4),(3,9,5),(3,9,6),(3,9,7),(3,9,8),(3,9,9),(3,9,10),
(3,10,1),(3,10,2),(3,10,3),(3,10,4),(3,10,5),(3,10,6),(3,10,7),(3,10,8),(3,10,9),(3,10,10);
*/
INSERT INTO Offer_Seat (offer_FK,seat_FK) VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6);

INSERT INTO Tickets (visitor_FK,staff_FK,offer_FK,seat_FK) VALUES
(1,3,1,13),
(2,1,2,12),
(3,5,3,29),
(4,3,4,34),
(5,1,5,23);

INSERT INTO Reservation (ticket_FK) VALUES
(1),
(2),
(3),
(4),
(5);
