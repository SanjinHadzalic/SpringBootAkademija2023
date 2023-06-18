create table test
(
    id          int primary key auto_increment,
    name        varchar(255),
    description varchar(255)
);

insert into test(name, description)
values ('ZAG', 'desc:ZAG');

create table pretrage_letova
(
    id                  int primary key auto_increment,
    sifra_polazista     char(3),
    sifra_odredista     char(3),
    datum_odlaska       date,
    datum_povratka      date,
    broj_odraslih       int,

    datum_kreiranja     date,
    korisnik_kreiranja  varchar(50),
    datum_azuriranja    date,
    korisnik_azuriranja varchar(50)
);

create table rezultati_pretrage
(
    id                                 int primary key auto_increment,

    polazak_sifra_aerodroma_polazak    varchar(3),
    polazak_sifra_aerodroma_odrediste  varchar(3),
    polazak_datum_polaska              varchar(25),
    polazak_datum_dolaska              varchar(25),

    povratak_sifra_aerodroma_polazak   varchar(3),
    povratak_sifra_aerodroma_odrediste varchar(3),
    povratak_datum_polaska             varchar(25),
    povratak_datum_dolaska             varchar(25),

    prijevoznik                        varchar(255),
    cijena                             varchar(255),

    datum_kreiranja                    date,
    korisnik_kreiranja                 varchar(50),
    datum_azuriranja                   date,
    korisnik_azuriranja                varchar(50)
)