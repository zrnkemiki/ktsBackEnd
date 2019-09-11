-- sifre svih korisnika su slovo a

-- regular user
insert into user(id, city, company_id, email, first_name, last_name, password, phone_number, user_status, user_type, username, uuid) values(-1,'Novi Sad',-1,'pera@kts.com','Petar','Petrovic','$2a$10$S3rxpwjnJUrmgMrnMCJo8eIRCFvCcmzuPi5Y3Okz67i/2sj6xMfau','+381123456',0,0,'pera',-1);
-- admin
insert into user(id, city, company_id, email, first_name, last_name, password, phone_number, user_status, user_type, username, uuid) values(-2,'Novi Sad',-1,'admin@kts.com','Admin','Adminovic','$2a$10$S3rxpwjnJUrmgMrnMCJo8eIRCFvCcmzuPi5Y3Okz67i/2sj6xMfau','+381123456',0,3,'admin',-1);
-- employee
insert into user(id, city, company_id, email, first_name, last_name, password, phone_number, user_status, user_type, username, uuid) values(-3,'Novi Sad',-1,'zaposleni@kts.com','Nikola','Nikolic','$2a$10$S3rxpwjnJUrmgMrnMCJo8eIRCFvCcmzuPi5Y3Okz67i/2sj6xMfau','+381123456',0,4,'zaposleni',-1);

insert into stajaliste(id, adresa, lokacijax, lokacijay, naziv) values(-1,'Bulevar Cara Lazara 10', 11.04,12.08,'Merkator');
insert into stajaliste(id, adresa, lokacijax, lokacijay, naziv) values(-2,'Bulevar Oslobodjenja 13', 14.04,18.08,'Futoska Pijaca');
insert into stajaliste(id, adresa, lokacijax, lokacijay, naziv) values(-3,'Bulevar Evrope 11', 1.04,2.08,'Bulevar Evrope');

insert into linija(id, broj, naziv, tip) values(-1,1,'Centar - Telep','autobus');
insert into linija(id, broj, naziv, tip) values(-2,4,'Centar - Bulevar','autobus');
insert into linija(id, broj, naziv, tip) values(-3,13,'Bulevar Evrope - Centar','tramvaj');

insert into polazak(id, dan, vreme) values(-1, "Radni dan", "11:45");
insert into polazak(id, dan, vreme) values(-2, "Nedelja", "13:50");
insert into polazak(id, dan, vreme) values(-3, "Subota", "16:45");

insert into linija_polasci(linija_id, polasci_id) values(-1,-1);
insert into linija_polasci(linija_id, polasci_id) values(-2,-2);
insert into linija_polasci(linija_id, polasci_id) values(-3,-3);

insert into linija_stajalista(linija_id, stajalista_id) values(-1,-1);
insert into linija_stajalista(linija_id, stajalista_id) values(-2,-2);
insert into linija_stajalista(linija_id, stajalista_id) values(-3,-3);

insert into vozilo(id, id_linija, id_trenutno_stajaliste, tip) values(-1,-1,-1,'autobus');
insert into vozilo(id, id_linija, id_trenutno_stajaliste, tip) values(-2,-2,-2,'autobus');
insert into vozilo(id, id_linija, id_trenutno_stajaliste, tip) values(-3,-3,-3,'tramvaj');

insert into cenovnik(id, datum_do, datum_od) values(-1,'2019-05-13', '2019-01-13');

insert into karte(id, aktivirana, cena, id_vlasnik, tip, vazi_do, vazi_od) values (-1, 1, 200, -2, 'mesecna', '2019-02-25', '2019-01-25');
insert into karte(id, aktivirana, cena, id_vlasnik, tip, vazi_do, vazi_od) values (-2, 1, 200, -1, 'dnevna', '2019-01-25', '2019-01-25');

