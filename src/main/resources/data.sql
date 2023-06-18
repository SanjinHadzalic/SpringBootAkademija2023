create table test
(
  id int primary key auto_increment,
  name varchar(255),
  description varchar(255)
);

insert into test(name, description) values ('ZAG', 'desc:ZAG');

create table pretrage_letova
(
    id int primary key auto_increment,
    sifra_polazista char(3),
    sifra_odredista char(3),
    datum_odlaska date,
    datum_povratka date,
    broj_odraslih int,

    datum_kreiranja date,
    korisnik_kreiranja varchar(50),
    datum_azuriranja date,
    korisnik_azuriranja varchar(50)
)