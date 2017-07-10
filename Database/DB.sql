CREATE DATABASE IF NOT EXISTS CineBoost;
USE CineBoost;

CREATE TABLE IF NOT EXISTS Visitor(
	id int auto_increment not null,
	name varchar(255) not null,
	surname varchar(255) not null,
	birthdate date not null,
	email varchar(255) not null,
	password varchar(255) not null,
	adress varchar(255) not null,
	postcode varchar (4) not null,
	debitcardNumber varchar(255) not null,
	discount varchar(255) not null,
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Staff(
	id int auto_increment not null,
	name varchar(255) not null,
	surname varchar(255) not null,
	birthdate date not null,
	username varchar(255) not null,
	password varchar(255) not null,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Movie(
	id int auto_increment not null,
	name varchar (255) not null,
	productionsYear year not null,
	movieDescription longtext,
	genre varchar(255) not null,
	trailer varchar(255) not null,
	fsk varchar(255) not null,
	duration varchar(255) not null,
	movieRating varchar(255) not null,
	director varchar(255) not null,
	actor varchar(255) not null,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS CinemaHall(
	id int auto_increment not null,
	cinemaHallName varchar(255) not null,
	screen varchar(255) not null,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Offer(
	id int auto_increment not null,
	movie_FK int not null,
	cinemahall_FK int not null,
	title varchar(255) not null,
	movieStart datetime not null,
	movieLanguage varchar(255) not null,
	dimension varchar(255) not null,
	PRIMARY KEY (id),
	FOREIGN KEY (movie_FK) REFERENCES Movie(id),
	FOREIGN KEY (cinemahall_FK) REFERENCES CinemaHall(id)
);

CREATE TABLE IF NOT EXISTS Seat(
	id int auto_increment not null,
	cinemaHall_FK int not null,
	seatRow int not null,
	seatName varchar(255) not null,
	seatNr int not null,
	PRIMARY KEY (id),
	FOREIGN KEY (cinemaHall_FK) REFERENCES CinemaHall(id)
);

CREATE TABLE IF NOT EXISTS Offer_Seat(
	id int auto_increment not null,
	offer_FK int not null,
	seat_FK int not null,
	PRIMARY KEY (id),
	FOREIGN KEY (offer_FK) REFERENCES Offer(id),
	FOREIGN KEY (seat_FK) REFERENCES Seat(id)
);

CREATE TABLE IF NOT EXISTS Tickets(
	id int auto_increment not null,
	visitor_fk int not null,
	staff_fk int,
	offer_fk int not null,
	seat_fk int not null,
	PRIMARY KEY (id),
	FOREIGN KEY (visitor_FK) REFERENCES Visitor(id),
	FOREIGN KEY (offer_FK) REFERENCES Offer(id),
	FOREIGN KEY (seat_FK) REFERENCES Seat(id),
	FOREIGN KEY (staff_FK) REFERENCES Staff(id)
);

CREATE TABLE IF NOT EXISTS Reservation(
	id int auto_increment not null,
	ticket_FK int not null,
	PRIMARY KEY (id),
	FOREIGN KEY(ticket_FK) References Tickets(id)
);
