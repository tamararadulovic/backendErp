DROP TABLE IF EXISTS clanObuka CASCADE;
DROP TABLE IF EXISTS clanOprema CASCADE;
DROP TABLE IF EXISTS instruktor CASCADE;
DROP TABLE IF EXISTS obuka CASCADE;
DROP TABLE IF EXISTS oprema CASCADE;
DROP TABLE IF EXISTS tipOpreme CASCADE;
DROP TABLE IF EXISTS clan CASCADE;
DROP TABLE IF EXISTS kartica CASCADE;
DROP TABLE IF EXISTS racun CASCADE;
DROP TABLE IF EXISTS proizvodjac CASCADE;
DROP TABLE IF EXISTS zaposleni CASCADE;

DROP SEQUENCE IF EXISTS obuka_seq;
DROP SEQUENCE IF EXISTS oprema_seq;
DROP SEQUENCE IF EXISTS tipOpreme_seq;
DROP SEQUENCE IF EXISTS kartica_seq;
DROP SEQUENCE IF EXISTS racun_seq;
DROP SEQUENCE IF EXISTS clan_seq;
DROP SEQUENCE IF EXISTS zaposleni_seq;
DROP SEQUENCE IF EXISTS proizvodjac_seq;
DROP SEQUENCE IF EXISTS instruktor_seq;

CREATE TABLE zaposleni(
	id integer not null,
	ime_zaposlenog varchar(20) not null,
	prezime_zaposlenog varchar(30) not null,
	datum_rodjenja date,
	telefon varchar(30),
	adresa varchar(50),
	strucna_sprema varchar(100),
	datum_zaposlenja date,
	korisnicko_ime varchar(20) not null,
	lozinka varchar(30) not null
);

CREATE TABLE instruktor(
	zaposleni integer not null,
	licenca varchar(50),
	zvanje varchar(100)
);

CREATE TABLE clan(
	id integer not null,
	ime_clana varchar(20) not null,
	prezime_clana varchar(30) not null,
	datum_rodjenja date,
	telefon varchar(30),
	datum_uclanjenja date,
	korisnicko_ime varchar(20) not null,
	lozinka varchar(30) not null
);

CREATE TABLE kartica(
	id integer not null,
	broj_racuna varchar(100) not null,
	ccv varchar(4) not null,
	vazi_do date,
	clan integer not null
);

CREATE TABLE racun(
	id integer not null,
	iznos numeric(10,2),
	datum_placanja date,
	clan integer not null
);

CREATE TABLE proizvodjac(
	id integer not null,
	naziv_proizvodjaca varchar(30),
	telefon varchar(30),
	adresa varchar(50)
);

CREATE TABLE tipOpreme(
	id integer not null,
	naziv_tipa varchar(30),
	opis_tipa varchar(100)
);

CREATE TABLE obuka(
	id integer not null,
	datum_pocetka date,
	datum_zavrsetka date,
	broj_casova integer,
	trajanje varchar(20),
	broj_clanova integer,
	zaposleni integer not null
);

CREATE TABLE oprema(
	id integer not null,
	naziv_opreme varchar(30),
	opis_opreme varchar(100),
	kolicina_na_stanju integer,
	velicina varchar(20),
	cena_iznajmljivanja numeric(10,2),
	garancija date,
	tipOpreme integer not null,
	proizvodjac integer not null
);

CREATE TABLE clanObuka(
	clan integer not null,
	obuka integer not null
);

CREATE TABLE clanOprema(
	clan integer not null,
	oprema integer not null
);


ALTER TABLE zaposleni ADD CONSTRAINT pk_zaposleni PRIMARY KEY(id);
ALTER TABLE clan ADD CONSTRAINT pk_clan PRIMARY KEY(id);
ALTER TABLE kartica ADD CONSTRAINT pk_kartica PRIMARY KEY(id);
ALTER TABLE racun ADD CONSTRAINT pk_racun PRIMARY KEY(id);
ALTER TABLE proizvodjac ADD CONSTRAINT pk_proizvodjac PRIMARY KEY(id);
ALTER TABLE tipOpreme ADD CONSTRAINT pk_tipOpreme PRIMARY KEY(id);
ALTER TABLE obuka ADD CONSTRAINT pk_obuka PRIMARY KEY(id);
ALTER TABLE oprema ADD CONSTRAINT pk_oprema PRIMARY KEY(id);
ALTER TABLE instruktor ADD CONSTRAINT pk_instruktor PRIMARY KEY(zaposleni);
ALTER TABLE clanObuka ADD CONSTRAINT pk_clanObuka PRIMARY KEY(clan, obuka);
ALTER TABLE clanOprema ADD CONSTRAINT pk_clanOprema PRIMARY KEY(clan, oprema);

ALTER TABLE kartica ADD CONSTRAINT fk_kartica_clan FOREIGN KEY(clan) REFERENCES clan(id) ON DELETE CASCADE;;
ALTER TABLE racun ADD CONSTRAINT fk_racun_clan FOREIGN KEY(clan) REFERENCES clan(id) ON DELETE CASCADE;;
ALTER TABLE obuka ADD CONSTRAINT fk_obuka_zaposleni FOREIGN KEY(zaposleni) REFERENCES zaposleni(id) ON DELETE CASCADE;;
ALTER TABLE instruktor ADD CONSTRAINT fk_instruktor_zaposleni FOREIGN KEY(zaposleni) REFERENCES zaposleni(id) ON DELETE CASCADE;;
ALTER TABLE oprema ADD CONSTRAINT fk_oprema_tipOpreme FOREIGN KEY(tipOpreme) REFERENCES tipOpreme(id) ON DELETE CASCADE;;
ALTER TABLE oprema ADD CONSTRAINT fk_oprema_proizvodjac FOREIGN KEY(proizvodjac) REFERENCES proizvodjac(id) ON DELETE CASCADE;;
ALTER TABLE clanObuka ADD CONSTRAINT fk_clanObuka_clan FOREIGN KEY(clan) REFERENCES clan(id) ON DELETE CASCADE;;
ALTER TABLE clanObuka ADD CONSTRAINT fk_clanObuka_obuka FOREIGN KEY(obuka) REFERENCES obuka(id) ON DELETE CASCADE;;
ALTER TABLE clanOprema ADD CONSTRAINT fk_clanOprema_clan FOREIGN KEY(clan) REFERENCES clan(id) ON DELETE CASCADE;;
ALTER TABLE clanOprema ADD CONSTRAINT fk_clanOprema_oprema FOREIGN KEY(oprema) REFERENCES oprema(id) ON DELETE CASCADE;;

CREATE INDEX idxpk_zaposleni ON zaposleni(id);
CREATE INDEX idxpk_clan ON clan(id);
CREATE INDEX idxpk_kartica ON kartica(id);
CREATE INDEX idxpk_racun ON racun(id);
CREATE INDEX idxpk_proizvodjac ON kartica(id);
CREATE INDEX idxpk_tipOpreme ON tipOpreme(id);
CREATE INDEX idxpk_obuka ON obuka(id);
CREATE INDEX idxpk_oprema ON oprema(id);
CREATE INDEX idxpk_instruktor ON instruktor(zaposleni);
CREATE INDEX idxpk_clanOprema ON clanOprema(clan,oprema);
CREATE INDEX idxpk_clanObuka ON clanObuka(clan,obuka);

CREATE INDEX idxfk_obuka_zaposleni ON obuka(zaposleni);
CREATE INDEX idxfk_insturktor_zaposleni ON instruktor(zaposleni);
CREATE INDEX idxfk_kartica_clan ON kartica(clan);
CREATE INDEX idxfk_racun_clan ON racun(clan);
CREATE INDEX idxfk_oprema_tipOpreme ON oprema(tipOpreme);
CREATE INDEX idxfk_oprema_proizvodjac ON oprema(proizvodjac);
CREATE INDEX idxfk_clanOprema_clan ON clanOprema(clan,oprema);
CREATE INDEX idxfk_clanObuka_clan ON clanObuka(clan,obuka);

CREATE SEQUENCE zaposleni_seq
INCREMENT 1;
CREATE SEQUENCE obuka_seq
INCREMENT 1;
CREATE SEQUENCE oprema_seq
INCREMENT 1;
CREATE SEQUENCE clan_seq
INCREMENT 1;
CREATE SEQUENCE kartica_seq
INCREMENT 1;
CREATE SEQUENCE racun_seq
INCREMENT 1;
CREATE SEQUENCE tipOpreme_seq
INCREMENT 1;
CREATE SEQUENCE proizvodjac_seq
INCREMENT 1;
CREATE SEQUENCE instruktor_seq
INCREMENT 1;