insert into authority(id, authority_naziv) values (1, 'ucenik');
insert into authority(id, authority_naziv) values (2, 'penzioner');
insert into authority(id, authority_naziv) values (3, 'gradjanin');
insert into authority(id, authority_naziv) values (4, 'administrator');
insert into authority(id, authority_naziv) values (5, 'zaposleni');

-- sifre svih korisnika su slovo a

insert into administratori(id, ime, prezime, email, lozinka, tip) values(-3,'admin','admin','admin@kts.com','$2a$10$S3rxpwjnJUrmgMrnMCJo8eIRCFvCcmzuPi5Y3Okz67i/2sj6xMfau', 3);

insert into zaposleni(id, ime, prezime, email, lozinka, tip) values(-4,'zaposleni','zaposleni','zaposleni@kts.com','$2a$10$S3rxpwjnJUrmgMrnMCJo8eIRCFvCcmzuPi5Y3Okz67i/2sj6xMfau', 4);

insert into korisnik(id, ime, prezime, email, lozinka, tip) values(-1,'Petar','Petrovic','pera@kts.com','$2a$10$S3rxpwjnJUrmgMrnMCJo8eIRCFvCcmzuPi5Y3Okz67i/2sj6xMfau', 2);
insert into korisnik(id, ime, prezime, email, lozinka, tip) values(-2,'Nikola','Nikolic','nikola@kts.com','$2a$10$S3rxpwjnJUrmgMrnMCJo8eIRCFvCcmzuPi5Y3Okz67i/2sj6xMfau', 2);

insert into user(id, city, company_id, email, first_name, last_name, password, phone_number, user_status, user_type, username, uuid) values(-1,'Novi Sad',-1,'pera@kts.com','Petar','Petrovic','$2a$10$S3rxpwjnJUrmgMrnMCJo8eIRCFvCcmzuPi5Y3Okz67i/2sj6xMfau','+381123456',0,0,'pera',-1);

insert into korisnik_authority(id, authority_id, korisnik_id) values (-1, 4, -3);
insert into korisnik_authority(id, authority_id, korisnik_id) values (-2, 5, -4);
insert into korisnik_authority(id, authority_id, korisnik_id) values (-3, 3, -1);
insert into korisnik_authority(id, authority_id, korisnik_id) values (-4, 3, -2);

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

