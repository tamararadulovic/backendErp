--ZAPOSLENI PODACI

INSERT INTO "zaposleni"("id", "ime_zaposlenog", "prezime_zaposlenog", "datum_rodjenja", "telefon", "adresa", "strucna_sprema", 
					"datum_zaposlenja", "korisnicko_ime", "lozinka")
VALUES(nextval('zaposleni_seq'), 'Dusan', 'Vukic', '1999-10-3', '060/4234250', 'Bulevar Evrope 11', 'Osnovne akademske studije',
	  '2020-11-25', 'dusanvukic', 'dusan123');
INSERT INTO "zaposleni"("id", "ime_zaposlenog", "prezime_zaposlenog", "datum_rodjenja", "telefon", "adresa", "strucna_sprema", 
					"datum_zaposlenja", "korisnicko_ime", "lozinka")
VALUES(nextval('zaposleni_seq'), 'Andjela', 'Milojkovic', '1999-11-21', '061/8599611', 'Bulevar Oslobodjenja 11', 'Osnovne akademske studije',
	  '2021-01-11', 'andjelamilojkovic', 'andjela123');
INSERT INTO "zaposleni"("id", "ime_zaposlenog", "prezime_zaposlenog", "datum_rodjenja", "telefon", "adresa", "strucna_sprema", 
					"datum_zaposlenja", "korisnicko_ime", "lozinka")
VALUES(nextval('zaposleni_seq'), 'Mila', 'Vladisavljevic', '1995-06-18', '065/3444285', 'Timocka 19/4', 'Master studije',
	  '2020-12-03', 'milavladisavljevic', 'mila123');
INSERT INTO "zaposleni"("id", "ime_zaposlenog", "prezime_zaposlenog", "datum_rodjenja", "telefon", "adresa", "strucna_sprema", 
					"datum_zaposlenja", "korisnicko_ime", "lozinka")
VALUES(nextval('zaposleni_seq'), 'Stevan', 'Cosic', '1990-04-23', '061/3123733', 'Nikole Pasica 13/4', 'Osnovne akademske studije',
	  '2017-02-20', 'stevancosic', 'stevan123');
INSERT INTO "zaposleni"("id", "ime_zaposlenog", "prezime_zaposlenog", "datum_rodjenja", "telefon", "adresa", "strucna_sprema", 
					"datum_zaposlenja", "korisnicko_ime", "lozinka")
VALUES(nextval('zaposleni_seq'), 'Aleksandar', 'Stankovic', '1994-01-26', '063/4528845', 'Timocke divizije 6/54', 'Osnovne akademske studije',
	  '2017-01-18', 'aleksandarstankovic', 'aleksandar123');
	  
	  
--INSTRUKTOR PODACI

INSERT INTO "instruktor"("zaposleni", "licenca", "zvanje")
VALUES(nextval('instruktor_seq'), 'IVSI', 'Instruktor skijanja I stepana');
INSERT INTO "instruktor"("zaposleni", "licenca", "zvanje")
VALUES(nextval('instruktor_seq'), 'IVSI', 'Instruktor skijanja I stepana');
INSERT INTO "instruktor"("zaposleni", "licenca", "zvanje")
VALUES(nextval('instruktor_seq'), 'IVSI', 'Instruktor skijanja II stepana');
INSERT INTO "instruktor"("zaposleni", "licenca", "zvanje")
VALUES(nextval('instruktor_seq'), 'ISIA', 'Instruktor skijanja III stepana');
INSERT INTO "instruktor"("zaposleni", "licenca", "zvanje")
VALUES(nextval('instruktor_seq'), 'ISIA', ' Instruktor skijanja IV stepana (Državni Demonstrator)');

--CLAN PODACI

INSERT INTO "clan"("id", "ime_clana", "prezime_clana", "datum_rodjenja", "telefon", "datum_uclanjenja", "korisnicko_ime", "lozinka")
VALUES(nextval('clan_seq'), 'Marko', 'Todorov', '1989-08-21', '065/3456215', '2021-04-01', 'markotodorov', 'markot');
INSERT INTO "clan"("id", "ime_clana", "prezime_clana", "datum_rodjenja", "telefon", "datum_uclanjenja", "korisnicko_ime", "lozinka")
VALUES(nextval('clan_seq'), 'Marijana', 'Kitic', '2000-11-11', '063/1254866', '2021-11-21', 'marijanakitic', 'marijanak');
INSERT INTO "clan"("id", "ime_clana", "prezime_clana", "datum_rodjenja", "telefon", "datum_uclanjenja", "korisnicko_ime", "lozinka")
VALUES(nextval('clan_seq'), 'Milos', 'Makulovic', '1998-02-25', '061/2340462', '2022-01-18', 'milosmakulovic', 'milosm');
INSERT INTO "clan"("id", "ime_clana", "prezime_clana", "datum_rodjenja", "telefon", "datum_uclanjenja", "korisnicko_ime", "lozinka")
VALUES(nextval('clan_seq'), 'Julija', 'Mitov', '1996-04-26', '060/2444516', '2022-02-01', 'julijamitov', 'julijam');
INSERT INTO "clan"("id", "ime_clana", "prezime_clana", "datum_rodjenja", "telefon", "datum_uclanjenja", "korisnicko_ime", "lozinka")
VALUES(nextval('clan_seq'), 'Milan', 'Firkosic', '2001-02-09', '060/3557552', '2020-12-03', 'milanfirkosic', 'milanf');


--KARTICA PODACI

INSERT INTO "kartica"("id", "broj_racuna", "ccv", "vazi_do","clan")
VALUES(nextval('kartica_seq'), '270-4568789523546-56', '445', '2023-05-14',1);
INSERT INTO "kartica"("id", "broj_racuna", "ccv", "vazi_do", "clan")
VALUES(nextval('kartica_seq'), '350-5945336576928-54', '225', '2027-10-04',2);
INSERT INTO "kartica"("id", "broj_racuna", "ccv", "vazi_do", "clan")
VALUES(nextval('kartica_seq'), '275-1447854945102-52', '865', '2025-11-02',3);
INSERT INTO "kartica"("id", "broj_racuna", "ccv", "vazi_do", "clan")
VALUES(nextval('kartica_seq'), '265-7541523226984-75', '134', '2024-03-24',4);
INSERT INTO "kartica"("id", "broj_racuna", "ccv", "vazi_do", "clan")
VALUES(nextval('kartica_seq'), '270-8268384732456-87', '652', '2026-09-15',5);


--RACUN PODACI

INSERT INTO "racun"("id", "iznos", "datum_placanja","clan")
VALUES(nextval('racun_seq'), '10000', '2022-01-11',1);
INSERT INTO "racun"("id", "iznos", "datum_placanja","clan")
VALUES(nextval('racun_seq'), '18500', '2022-02-02',2);
INSERT INTO "racun"("id", "iznos", "datum_placanja","clan")
VALUES(nextval('racun_seq'), '12000', '2022-03-10',3);
INSERT INTO "racun"("id", "iznos", "datum_placanja","clan")
VALUES(nextval('racun_seq'), '9000', '2022-01-21',4);
INSERT INTO "racun"("id", "iznos", "datum_placanja","clan")
VALUES(nextval('racun_seq'), '3000', '2022-03-08',5);


--OBUKA PODACI

INSERT INTO "obuka"("id", "datum_pocetka", "datum_zavrsetka", "broj_casova", "trajanje", "broj_clanova", "zaposleni")
VALUES(nextval('obuka_seq'), '2022-02-15', '2022-03-05', 20, '1h', 10, 1);
INSERT INTO "obuka"("id", "datum_pocetka", "datum_zavrsetka", "broj_casova", "trajanje", "broj_clanova", "zaposleni")
VALUES(nextval('obuka_seq'), '2021-12-01', '2021-12-21', 20, '1h', 15, 2);
INSERT INTO "obuka"("id", "datum_pocetka", "datum_zavrsetka", "broj_casova", "trajanje", "broj_clanova", "zaposleni")
VALUES(nextval('obuka_seq'), '2021-01-05', '2021-01-25', 15, '1h', 8, 3);
INSERT INTO "obuka"("id", "datum_pocetka", "datum_zavrsetka", "broj_casova", "trajanje", "broj_clanova", "zaposleni")
VALUES(nextval('obuka_seq'), '2020-12-13', '2021-01-03', 18, '1h', 13, 4);
INSERT INTO "obuka"("id", "datum_pocetka", "datum_zavrsetka", "broj_casova", "trajanje", "broj_clanova", "zaposleni")
VALUES(nextval('obuka_seq'), '2022-11-28', '2022-12-16', 19, '1h', 19, 5);

--PROIZVODJAC PODACI

INSERT INTO "proizvodjac"("id", "naziv_proizvodjaca", "telefon", "adresa")
VALUES(nextval('proizvodjac_seq'), 'Fischer', '061/3123733', 'Horgoški put 47/a, Palić 24413');
INSERT INTO "proizvodjac"("id", "naziv_proizvodjaca", "telefon", "adresa")
VALUES(nextval('proizvodjac_seq'), 'Atomic', '066/4254618', 'Göllstrasse 24');
INSERT INTO "proizvodjac"("id", "naziv_proizvodjaca", "telefon", "adresa")
VALUES(nextval('proizvodjac_seq'), 'Burton', '063/4347344', '162 College Street');
INSERT INTO "proizvodjac"("id", "naziv_proizvodjaca", "telefon", "adresa")
VALUES(nextval('proizvodjac_seq'), 'Rossignol', '061/3445124', '78 340 Les Clayes Sous Bois, France');
INSERT INTO "proizvodjac"("id", "naziv_proizvodjaca", "telefon", "adresa")
VALUES(nextval('proizvodjac_seq'), 'Madshus', '065/4231145', '413 Pine Street 3rd Floor, Seattle, WA, 98101');

--TIP OPREME PODACI

INSERT INTO "tipopreme"("id", "naziv_tipa", "opis_tipa")
VALUES(nextval('tipOpreme_seq'), 'skije', '');
INSERT INTO "tipopreme"("id", "naziv_tipa", "opis_tipa")
VALUES(nextval('tipOpreme_seq'), 'naocare', '');
INSERT INTO "tipopreme"("id", "naziv_tipa", "opis_tipa")
VALUES(nextval('tipOpreme_seq'), 'stap', '');
INSERT INTO "tipopreme"("id", "naziv_tipa", "opis_tipa")
VALUES(nextval('tipOpreme_seq'), 'kaciga', '');
INSERT INTO "tipopreme"("id", "naziv_tipa", "opis_tipa")
VALUES(nextval('tipOpreme_seq'), 'torba', '');

--OPREMA PODACI

INSERT INTO "oprema"("id", "naziv_opreme", "opis_opreme", "kolicina_na_stanju", "velicina", "cena_iznajmljivanja", "garancija",
					"tipopreme", "proizvodjac")
VALUES(nextval('oprema_seq'), 'skije elan speed', 'SKIJE ELAN SPEED MAGIC PS ELX11', 5, '38,39,42,43,46', '7500', '2026-04-29', 1, 2);
INSERT INTO "oprema"("id", "naziv_opreme", "opis_opreme", "kolicina_na_stanju", "velicina", "cena_iznajmljivanja", "garancija",
					"tipopreme", "proizvodjac")
VALUES(nextval('oprema_seq'), 'naocare ski scott', 'NAOČARE SKI SCOTT LCG EVO LS YELLOW-LIGHT SENSITIVE BLUE CHROME', 3,
	   'univerzalna', '1800', '2023-01-28', 2, 5);
INSERT INTO "oprema"("id", "naziv_opreme", "opis_opreme", "kolicina_na_stanju", "velicina", "cena_iznajmljivanja", "garancija",
					"tipopreme", "proizvodjac")
VALUES(nextval('oprema_seq'), 'stap fischer', 'ŠTAP FISCHER RC 8 QF', 3, '110-135cm', '3000', '2022-07-14', 3, 1);
INSERT INTO "oprema"("id", "naziv_opreme", "opis_opreme", "kolicina_na_stanju", "velicina", "cena_iznajmljivanja", "garancija",
					"tipopreme", "proizvodjac")
VALUES(nextval('oprema_seq'), 'kaciga bolle', 'KACIGA BOLLE B-LIEVE ANNA VEITH SIGNATURE SERIES', 9, 'univerzalna', 
	   '2000', '2024-04-29', 4, 3);
INSERT INTO "oprema"("id", "naziv_opreme", "opis_opreme", "kolicina_na_stanju", "velicina", "cena_iznajmljivanja", "garancija",
					"tipopreme", "proizvodjac")
VALUES(nextval('oprema_seq'), 'torba snowboard', 'TORBA SNOWBOARD NITRO LIGHT SACK 165CM JET BLACK', 1, 
	   'univerzalna', '2300', '2020-03-07', 5, 4);
	   
--CLAN_OBUKA PODACI

INSERT INTO "clanobuka"("obuka", "clan")
VALUES(1,1);
INSERT INTO "clanobuka"("obuka", "clan")
VALUES(2,2);
INSERT INTO "clanobuka"("obuka", "clan")
VALUES(3,3);
INSERT INTO "clanobuka"("obuka", "clan")
VALUES(4,4);
INSERT INTO "clanobuka"("obuka", "clan")
VALUES(5,5);

--CLAN_OPREMA PODACI

INSERT INTO "clanoprema"("oprema", "clan")
VALUES(1,1);
INSERT INTO "clanoprema"("oprema", "clan")
VALUES(2,2);
INSERT INTO "clanoprema"("oprema", "clan")
VALUES(3,3);
INSERT INTO "clanoprema"("oprema", "clan")
VALUES(4,4);
INSERT INTO "clanoprema"("oprema", "clan")
VALUES(5,5);