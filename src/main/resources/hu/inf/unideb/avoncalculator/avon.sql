CREATE TABLE vasarlo
(
Vasarlo_ID int NOT NULL GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
Vezetek_nev varchar(255),
Kereszt_nev varchar(255),
Telefon_szam varchar(255),
E_mail varchar(255),
Vasarlo_kedvezmeny int,
PRIMARY KEY (Vasarlo_ID)
);

CREATE TABLE rendeles
(
Rendeles_ID int NOT NULL GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
Kampany varchar(255),
Vasarlo_ID int,
Idopont date,
PRIMARY KEY (Rendeles_ID),
FOREIGN KEY (Vasarlo_ID) REFERENCES vasarlo (Vasarlo_ID)
);

CREATE TABLE termek
(
Termek_ID int NOT NULL GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
Cikkszam int,
Nev varchar(255),
Ar int,
Darabszam int,
Avon_kedvezmeny int,
Rendeles_ID int,
PRIMARY KEY (Termek_ID),
FOREIGN KEY (Rendeles_ID) REFERENCES rendeles (Rendeles_ID)
);

