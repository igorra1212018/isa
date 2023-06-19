--Roles
INSERT INTO public.role(id, name) VALUES (0,'USER');
INSERT INTO public.role(id, name) VALUES (1,'ADMINISTRATOR');
INSERT INTO public.role(id, name) VALUES (2,'STAFF');


--Donation centers
INSERT INTO public.donation_center(id, address, city, country, latitude, longitude, blood_a, blood_b, blood_ab, blood_o, description, name)
VALUES (0, 'Dr Sime Miloševića', 'Novi Sad', 'Serbia', 45.24903, 19.84820, 50, 60, 70, 80, 'Donacioni centar', 'Zavod za zdravstvenu zaštitu studenata');

INSERT INTO public.donation_center(id, address, city, country, latitude, longitude, blood_a, blood_b, blood_ab, blood_o, description, name)
VALUES (1, 'Bulevar slobodana Jovanovića 9', 'Novi Sad', 'Serbia', 45.25133, 19.80501, 20, 30, 23, 18, 'Javni zdravstveni centar', 'Dom Zdravlja Novo Naselje - Bistrica');

INSERT INTO public.donation_center(id, address, city, country, latitude, longitude, blood_a, blood_b, blood_ab, blood_o, description, name)
VALUES (2, 'Bulevar cara Lazara 75', 'Novi Sad', 'Serbia', 45.24057, 19.83044, 75, 22, 42, 88, 'Javni zdravstveni centar', 'Dom zdravlja "Novi Sad"');

INSERT INTO public.donation_center(id, address, city, country, latitude, longitude, blood_a, blood_b, blood_ab, blood_o, description, name)
VALUES (3, 'Zmaj Ognjena Vuka 19', 'Novi Sad', 'Serbia', 45.26145, 19.83687, 12, 105, 82, 74, 'Javni zdravstveni centar', 'Dom Zdravlja "Jovan Jovanović Zmaj"');

INSERT INTO public.donation_center(id, address, city, country, latitude, longitude, blood_a, blood_b, blood_ab, blood_o, description, name)
VALUES (4, 'Nehruova 53', 'Beograd', 'Serbia', 44.79939, 20.38386, 60, 229, 24, 22, 'Javni zdravstveni centar u Beogradu', 'Dom Zdravlja Novi Beograd');


--Users
INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (10, true, 'marko.mekic@test.com', 'Marko', 'Mekić', 0, '8597742685357', 'Student', 'Fakultet tehničkih nauka Novi Sad',
'$2a$10$JrBQZbE64oPnnPP9fRMe0urRWAm/IIXI.uytaBM72fF6QCkqtddJK', 0, '063241463', 'Braće Nemet 4', 'Novi Sad', 'Serbia', 45.23954, 19.80781, null, 120);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (11, true, 'tijana.nikolic@test.com', 'Tijana', 'Nikolić', 1, '4577397855271', 'Profesor Matematike', 'Gimnazija Jovan Jovanović Zmaj, Novi Sad',
'$2a$10$f/eIJ2mawbx75.SRBceU/.zafZvdcKy6RR6z1uEZQ7TULMUX0l8E.', 0, '062676349', 'Paje Marganovića 2', 'Novi Sad', 'Serbia', 45.25232, 19.82115, null, 30);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (12, true, 'darko.popovic@test.com', 'Darko', 'Popović', 0, '6488052659043', 'Kasir', 'Idea, Novi Sad',
'$2a$10$wQN2LVZipqY5KJ5ZK3hdzOYk2y4QD7V2cKGADh1eG68ZOQ4tQK5gq', 0, '063887221', 'Alekse Šantića 25', 'Novi Sad', 'Serbia', 45.24365, 19.83517, null, 100);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (13, true, 'milica.matic@test.com', 'Milica', 'Matić', 1, '4785296075844', 'Advokat', 'Advokatska služba Aleksić, Novi Sad',
'$2a$10$IelnpU0.wI5qmUzdmVnoB.4jA3CSj716cZsZ2lLVewwI9BpAqI0G.', 0, '063622143', 'Radnička 14', 'Novi Sad', 'Serbia', 45.24903, 19.84820, null, 0);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (14, true, 'petar.jankovic@test.com', 'Petar', 'Janković', 0, '1258605397321', 'Student', 'Univerzitet u Beogradu',
'$2a$10$mHfZ55SflXGL8.Aiha3KqeeNR5oWrT2kA9affudvChkCqFdSN.I2i', 0, '064982153', 'Knez Mihailova 10', 'Beograd', 'Serbia', 0, 0, null, 50);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (15, true, 'ana.simic@test.com', 'Ana', 'Simić', 1, '8416920573551', 'Doktor', 'Klinički centar Srbije, Beograd',
'$2a$10$kWJTg5fOWq4K2Ud.M/avNOBDNktE7bdHo8datXKMsqv0DgdckZHQq', 0, '063498721', 'Resavska 14', 'Beograd', 'Serbia', 0, 0, null, 580);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (16, true, 'nikola.markovic@test.com', 'Nikola', 'Marković', 0, '6458026874309', 'Inženjer', 'Elektrotehnički fakultet, Beograd',
'$2a$10$rLZuuU6Y/kLNDe5qpKUmRefhuptWAZoMQC/Wfh5tzjK3IKv0B9jc6', 0, '064321987', 'Bulevar Kralja Aleksandra 73', 'Beograd', 'Serbia', 0, 0, null, 20);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (17, true, 'milena.veljkovic@test.com', 'Milena', 'Veljković', 1, '9681407261246', 'Profesor', 'Matematička gimnazija, Beograd',
'$2a$10$OrpGI.FqxeyY4NTXr43RN.j4XWcTbpD3Q6D5f31oF8hRB7di.glWK', 0, '063754812', 'Cara Dušana 25', 'Beograd', 'Serbia', 0, 0, null, 210);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (18, true, 'dusan.popovic@test.com', 'Dušan', 'Popović', 0, '5213786142876', 'Konsultant', 'PwC, Beograd',
'$2a$10$gNHvJN0PHO1y4aqUN4LWteU8tNjSnOjmRhiEl6cjOmVFQCKj4HqQu', 0, '064987321', 'Kralja Milutina 5', 'Beograd', 'Serbia', 0, 0, null, 390);


--User roles
INSERT INTO public.user_roles(user_id, role_id) VALUES (10, 0);
INSERT INTO public.user_roles(user_id, role_id) VALUES (11, 0);
INSERT INTO public.user_roles(user_id, role_id) VALUES (12, 0);
INSERT INTO public.user_roles(user_id, role_id) VALUES (13, 0);
INSERT INTO public.user_roles(user_id, role_id) VALUES (14, 0);
INSERT INTO public.user_roles(user_id, role_id) VALUES (15, 0);
INSERT INTO public.user_roles(user_id, role_id) VALUES (16, 0);
INSERT INTO public.user_roles(user_id, role_id) VALUES (17, 0);
INSERT INTO public.user_roles(user_id, role_id) VALUES (18, 0);


--Staff
INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (20, true, 'dunja.bozic@test.com', 'Dunja', 'Božić', null, null, null, null,
'$2a$10$7kZVwuCsu7lk8OsZAZ2KdOea59iQkiyEEb3yi2mUndnZeGa5eNqS2', 0, null, null, null, null, 0, 0, 0, 0);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (21, true, 'nikola.curcic@test.com', 'Nikola', 'Ćurčić', null, null, null, null,
'$2a$10$95OZCS0XJJTCPXGLqRWp2uaDrsUMLvmWVUu3HPZMlEA6YkvnxcsYK', 0, null, null, null, null, 0, 0, 1, 0);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (22, true, 'marko.markovic@test.com', 'Marko', 'Marković', null, null, null, null,
'$2a$10$so1BJu0h1cuxVkA9CXI6Cen8v.soHtup8LBWplm3z94PPOLMD40VG', 0, null, null, null, null, 0, 0, 0, 0);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (23, true, 'milica.petrovic@test.com', 'Milica', 'Petrović', null, null, null, null,
'$2a$10$p5u1dyM3dbs/87iD7Okmx.w9jLzVoJn/K9FVu2whELo6y28n9pRCG', 0, null, null, null, null, 0, 0, 1, 0);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (24, true, 'ivan.jovanovic@test.com', 'Ivan', 'Jovanović', null, null, null, null,
'$2a$10$Sf00lIeb7jiHmeupVikz6uMSuwsH4I1KcY.qKc2ABA3Z6gdHqv8sO', 0, null, null, null, null, 0, 0, 2, 0);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (25, true, 'ana.pavlovic@test.com', 'Ana', 'Pavlović', null, null, null, null,
'$2a$10$lVsnZYd00kF9XPr9ieBSL.9Or33usGlsKKAW7Nv3fAfHOlr18bGJi', 0, null, null, null, null, 0, 0, 3, 0);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (26, true, 'luka.jankovic@test.com', 'Luka', 'Janković', null, null, null, null,
'$2a$10$FHKLzz1cBFrE2uuZXzn1kehE22eoPf0pl9zdwaWWs6Z7jSyj0R8Lq', 0, null, null, null, null, 0, 0, 2, 0);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (27, true, 'jovana.milic@test.com', 'Jovana', 'Milić', null, null, null, null,
'$2a$10$lQyjSwTDLriYexW4DbKSlubyq/iwNWmBOgII9UnVWd5uM/lPCvuNy', 0, null, null, null, null, 0, 0, 4, 0);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (28, true, 'stefan.petrovic@test.com', 'Stefan', 'Petrović', null, null, null, null,
'$2a$10$BimxadcsVc3Uk9sEUg85Iuw6yV2Q2nzQDMuiPKM36WYb8fCnnfmMO', 0, null, null, null, null, 0, 0, 3, 0);


--Staff roles
INSERT INTO public.user_roles(user_id, role_id) VALUES (20, 2);
INSERT INTO public.user_roles(user_id, role_id) VALUES (21, 2);
INSERT INTO public.user_roles(user_id, role_id) VALUES (22, 2);
INSERT INTO public.user_roles(user_id, role_id) VALUES (23, 2);
INSERT INTO public.user_roles(user_id, role_id) VALUES (24, 2);
INSERT INTO public.user_roles(user_id, role_id) VALUES (25, 2);
INSERT INTO public.user_roles(user_id, role_id) VALUES (26, 2);
INSERT INTO public.user_roles(user_id, role_id) VALUES (27, 2);
INSERT INTO public.user_roles(user_id, role_id) VALUES (28, 2);


--Admin
INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id, loyalty_points)
VALUES (50, true, 'sasa.lukic@test.com', 'Saša', 'Lukić', null, null, null, null,
'$2a$10$H9NzV9vgV.DpCJFCiQfla.cu/DoY4KE0tOgJ9h3B7cFvEztpm2m8a', 0, null, null, null, null, 0, 0, null, 0);


--Admin role
INSERT INTO public.user_roles(user_id, role_id) VALUES (50, 1);


--Terms
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (0,  '2023/06/18 8:30', 25, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (1,  '2023/06/18 9:30', 30, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (2,  '2023/06/18 19:00', 20, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (3,  '2023/06/18 9:30', 30, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (4,  '2023/06/18 9:30', 30, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (5,  '2023/06/18 19:00', 20, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (6,  '2023/01/10 12:30', 25, 2, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (7,  '2022/01/12 16:00', 20, 3, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (8,  '2022/02/05 14:30', 30, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (9,  '2022/02/08 09:30', 20, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (10, '2022/02/10 15:00', 25, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (11, '2022/02/15 18:30', 30, 3, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (12, '2022/03/02 10:00', 20, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (13, '2022/03/05 13:30', 25, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (14, '2022/03/10 17:00', 30, 2, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (15, '2022/03/12 11:30', 20, 3, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (16, '2022/03/15 08:00', 25, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (17, '2022/04/01 16:30', 20, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (18, '2022/04/03 13:00', 30, 2, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (19, '2022/04/08 09:30', 25, 3, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (20, '2022/04/12 12:00', 20, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (21, '2022/04/18 14:30', 30, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (22, '2022/05/02 11:00', 25, 2, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (23, '2022/05/05 15:30', 20, 3, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (24, '2022/05/08 10:00', 30, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (25, '2022/05/12 14:30', 25, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (26, '2022/05/15 09:00', 30, 2, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (27, '2022/05/18 16:30', 20, 3, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (28, '2022/05/21 12:00', 25, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (29, '2022/05/24 10:30', 30, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (30, '2023/05/27 15:00', 20, 2, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (31, '2023/05/30 11:30', 25, 3, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (32, '2023/06/02 14:00', 30, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (33, '2023/06/05 10:30', 20, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (34, '2023/06/08 16:00', 25, 2, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (35, '2023/06/11 12:30', 30, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (36, '2023/06/14 09:00', 20, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (37, '2023/06/17 15:30', 25, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (38, '2023/06/20 11:00', 30, 2, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (39, '2023/06/23 14:30', 20, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (40, '2023/06/26 10:00', 25, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (41, '2023/06/29 16:30', 30, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (42, '2023/07/02 12:00', 20, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (43, '2023/07/05 09:30', 25, 3, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (44, '2023/07/08 15:00', 30, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (45, '2023/07/11 10:30', 20, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (46, '2023/07/14 16:00', 25, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (47, '2023/07/17 12:30', 30, 3, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (48, '2023/07/20 09:00', 20, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (49, '2023/07/23 15:30', 25, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (50, '2023/07/26 11:00', 30, 2, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (51, '2023/07/29 14:30', 20, 3, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (52, '2023/11/01 10:00', 25, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (53, '2023/11/04 16:30', 30, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (54, '2023/11/07 12:00', 20, 2, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (55, '2023/11/10 09:30', 25, 3, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (56, '2023/11/13 15:00', 30, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (57, '2023/11/16 10:30', 20, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (58, '2023/11/19 16:00', 25, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (59, '2023/11/22 12:30', 30, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (60, '2023/11/25 09:00', 20, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (61, '2023/11/28 15:30', 25, 4, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (62, '2023/11/30 11:00', 30, 2, false);


--Equipment
INSERT INTO public.equipment (id, name, quantity, center_id) VALUES (10, 'Špric', 150, 0);
INSERT INTO public.equipment (id, name, quantity, center_id) VALUES (11, 'Špric', 50, 1);
INSERT INTO public.equipment (id, name, quantity, center_id) VALUES (12, 'Špric', 200, 2);
INSERT INTO public.equipment (id, name, quantity, center_id) VALUES (13, 'Špric', 183, 3);
INSERT INTO public.equipment (id, name, quantity, center_id) VALUES (14, 'Špric', 130, 4);
INSERT INTO public.equipment (id, name, quantity, center_id) VALUES (15, 'Vata',  500, 0);
INSERT INTO public.equipment (id, name, quantity, center_id) VALUES (16, 'Vata',  2000,1);
INSERT INTO public.equipment (id, name, quantity, center_id) VALUES (17, 'Vata',  3000,2);
INSERT INTO public.equipment (id, name, quantity, center_id) VALUES (18, 'Vata',  221, 3);
INSERT INTO public.equipment (id, name, quantity, center_id) VALUES (19, 'Vata',  99,  4);


--Donation center scores
INSERT INTO public.donation_center_score (id, score, center_id, user_id) VALUES (100, 5, 3, 10);
INSERT INTO public.donation_center_score (id, score, center_id, user_id) VALUES (101, 5, 2, 11);
INSERT INTO public.donation_center_score (id, score, center_id, user_id) VALUES (102, 2, 3, 12);
INSERT INTO public.donation_center_score (id, score, center_id, user_id) VALUES (151, 3, 4, 14);
INSERT INTO public.donation_center_score (id, score, center_id, user_id) VALUES (201, 4, 1, 13);
INSERT INTO public.donation_center_score (id, score, center_id, user_id) VALUES (202, 4, 4, 15);
INSERT INTO public.donation_center_score (id, score, center_id, user_id) VALUES (203, 1, 4, 16);
INSERT INTO public.donation_center_score (id, score, center_id, user_id) VALUES (204, 4, 2, 17);
INSERT INTO public.donation_center_score (id, score, center_id, user_id) VALUES (205, 3, 2, 18);


--Donation center complaints
INSERT INTO public.donation_center_complaint (id, reply, text, center_id, user_id) VALUES (100, NULL, 'Kupatilo nije bilo čisto.', 4, 14);
INSERT INTO public.donation_center_complaint (id, reply, text, center_id, user_id) VALUES (101, NULL, 'Premalo doktora radi i velika je gužva.', 4, 14);


--Staff complaints
INSERT INTO public.staff_complaint (id, reply, text, staff_id, user_id) VALUES (100, NULL, 'Ana je bila nepristojna prema meni.', 25, 12);
INSERT INTO public.staff_complaint (id, reply, text, staff_id, user_id) VALUES (101, NULL, 'Jovana je kasnila na termin.', 27, 16);


--Reservations
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (201, false, '2023-04-03 18:44:07.035379', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000028249444154785ecdd43196ee1018066069640bd1c4d692862d482334b1051ab646c316a2e1929929e697e9af26e73ce7f0bd3e02d4dfe306ff0d88e9c63272aaaabc017e03972f02ce10a9b98feade40a3fb749eef2ac543fe019a435af3b5ede62f48176ec54344f91d5c56965ed80497f3778e0f1093f919fa7b2f1f50ab87fc748226f3d38f0f100baa29026c6e1ac9f9069e13c856385fe408b12f3ac0bd311a94e6a70a76790541c5c227290b396a78a27f8266679c95a0d594ed293b80c5c6126ab7951caaf44507d0bbf20bd27b52f7fa941da040c6b68da30851757dfb03243f797614ce9659e05750a93a19219bcaa99f6003e42008208c11b8b566be81b400a920002e535c7bb0019c3f2e00090d62d9e63e6580906a59015c00a3a9f4b203dc00f259ddb8b6bb075e2159400b9f0481a83c65072800e0761dd0bd5bb0f429236077b1151b1967a77ab0018c113458746d2b47ba2f3a40c41af0d9496777a7fba2033831d7dafa234d154f0b0728f0bc7719d9c2e1649fe89fe064f028dba9ba94fd2b14ea0fbfb1e99a8dc7ee0db2b1801dd5a29b56df830d204e59656ab9b3389f6318a0ec21c2f302049e353fd13f41d37818cfb6b306b1f62903a4ec54c8e6da457b127ab001725c6693935f493bb15728535967155155557d05fb84f655ad0762be50447dca0046ec2e25bd2ecb77f40142e484ada835e05a9edf6380abdda87604a5bdb2ee79940608055f6c393cadb23c0fdb0085713639816f768a77a8557908b09d4275aa471f404ced65354606e391edc10670d953bf61992e865d9f3280464eb34340aaa9987af417d0a78cdb14826ebb7c07c117defeb0e6cfe51fc065a95c5032ae87a55f393ea045d78c20e701274fd9017e8fff17fe0171cc0741fef7c43f0000000049454e44ae426082', 2, 23, 12);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (101, true, '2023-01-02 18:11:03.219096', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000023b49444154785eddd43dbaf5101000601ad9024db2b5a4610bd2e4a7892dd0b0b568d8020d9f1be716579c0d7caaf3bccfc9983103c87f5700ff15043045131320723d601762962387f642009ad8875313e3668eb645922fa00eca940acc7f05e3360e001ff76f9055e278d28898df3c1a0880a8cffaada581b2bcf14699c06af92f08f0547204881247591762daf86a1cb11a81a50b25a49e31115e597f76219e594f59b8c9bb71ea423e4f9b36925d895c536f216ccb31b9f5022cdb5a7e0b318c4b495f0fea1eeab62da421ed9ae245840ded5d880e137b119185f9a4fe021ba6687354d9cbfa490bf91a4eaf24bbf08c9e56bea0a4bb2616169313aa87dc42c0005ac7e75d0ee939e417c47b5e4b2b586069b55d481ca6991c43c21c9a2ec418c3ee8d30f71ad62e24a88c3dc845cb68d5236c21ac812330293d9cf59317a4196aa80e34c403d6182d649bcb3090ac6262754e5b48f0422524bb31189f71e840f4566f4479393f07f4827c8ddb0c101361514ff92f886ef19a122b2973431f0ebcba2951feb37d171273b8fcb9a4165d2dbf85ecf060f52e349f794dac85b0f89bd2793fb3774fd0176473aa2c0e3a13713de5bf20704e5707952c37b9f6a585b495f26119ce28ea73f186f2ab3c6c8b09cbf5b92f0d84c9e86d03c40700fa50da37793d1d7cb7f119cb17048031943fcf859235d316623651efe614e54a7f8153dd6804a03c0775a47aa01c42e58aacead9b60312de2313d72ad227680b5929517217f7727cee6d03e509363600ba11f369430b7fd7ff0dff008b6589131b81767c0000000049454e44ae426082', 0, 6, 11);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (100, false, '2023-01-01 18:08:13.571976', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000028049444154785ecdd43196f7101000701ab94234713569e40ad2048d5c8186abd1708568f824bb5bec5fb6ff3479eff7de30c66440fbbd2ef0df80845973e28b66f802e40d7c715bd4d8b6f3da9b7f0383ebcca083ada55dfd011ad1c92711a3fd0b2e51a184cdc0f20e3d2580ad979b2de53b8f0f90d0fe2cf37d970f682d96b07a75ea597cd7e303e44c02e760c6863126dec06cc5abec76d51348f7a623d0830161d87686797e85d3e7d82faf7c5d9bbd531fa0c9bd3555b7fb63ee630790085f146c36b6f3fb293f21acd16d1afbe6b37a4206507a3fab9060cab62e776203445b45ceb9e220e2b3e9000189c4170425db4a7d4ef90487dd94bda6ab6f12df2103789f3887565511bf8e1d4003a1c16e4494bdda77c8003691848be6f301c893d800d79ac06ecb5d1f07fd1b84035e74bd284338ebfbd8010c9824df2531f3d47bf30d94f74d2572aa8b92f3159a356839b0634858776f3a80263edade55ad5222c51b248016e8c0145505cfb1035c0c5146a7b01c077d4a3880929b4353da9b8dfa78854b5cec38f89a104ecf430de04b6fddac11db1d29af1013679c540a03a29b7f03db074a71885320d4755f6e80c0d67000be9e0e1bf40a06ea639e02b186d4e72907682dd0fef31d8072a8ef90015420015b0da3d9fdd3b803f4c7c18152704c363d251c201b0ef8ee7dbe3607ee9001e4d4bc4a7cf5d1d027f501340c7d5c24c066919f120e102bdb54a0f0acab7b06db00753f63b372595594cfc819a035effac0d1e898c9d3da0348a8791f04673e1396afe04b29f520cabb9978ff06069b3d6789c0bcc9f9bedc0b9c175f366b84add37db93738634f8b2f7bf809f90dbea8de0e086c2d9ee52b8f0fe8a94f39f7d1ca457d1a7780dfebff857f317208fd4d52a8280000000049454e44ae426082', 2, 7, 10);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (251, false, '2023-03-07 19:23:29.069103', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000028649444154785ecdd43bb6ed101800601aa640b3333569620a4913d230051aa6160d5388864bf6b9c58d9cfe2abfb5fc0f8f1fd47fd705fe1b90f01247725cd7e302d31bf87c28206ae4f6dcaa7f034393f7c1cc0aeddbf10b981dea1ccc67b6bf4150d04b184e98dfc167f7e16ab227d9f24f1d0f90d0fe5de6a79707d41a977df39227237ecee301924c3e4530d98bc745bcc189cbb212c4d5b285d8830e5068e4595fbbd0c1dd6907d0c9b7fec3a1d55c782f7d8023e49423db0175e04e3b4011875bb1128a115cee2c4fc85602aadd1cc12c49df3280e4399feb422322c2bd8235586ea9ec2bc172aa6f2017228e880d2cc27c4fec09116c8ad66bdd1123b46f1920c5d9fa384b844395bdf4011498b5daa2c87292a26f1920a7c33186104eda96bbdb2744b0ef589fb0f4dedfe1037061582e88ec9f9e768020b18f08d06b76e03ec201cce4962d4eb61d81d7bdb0012e6af0f5a18a7d766a7ad001ac976c9f7d7f0e5ef5a003f896f622ed311121710f3a40bf227a2d0c1a045d0f3a809b0f493e1f1811cfe72be882f3c956a8b03d27ff06650be7ba55472f5ebecff209479b0552b8596739dfa50f50b6dcbeba020c89c25e21f2363056b6a51ad4dddc00366b4544d5e1e28af6c206703b4022d8d2fe0fb84b1f4032e1b56be65b9f3ded006ec1a9307e6245e337e813aa212205eb48cb6d7b6103587da175275ccd0a7eeff6090adae39c525981d0b96f19a07d0ab2b32d6b7dd4fb2a07285b5c856d5f0757895ea156274eeacd545a9377e94f90b00dd06a6d046de8dce7f1049f5338d97424b54ebe6f19c050ebd64d226eb884bdf41770737bdc3004ebd32fa01680f035b711297bda017cb659b507a51077e25bc7035ae9d846b2407b2df7c819e0dff5ffc21f5742eff2a35179fa0000000049454e44ae426082', 2, 21, 13);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (354, false, '2023-06-19 22:33:52.366461', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000028749444154785ecdd4b195ae2010065048b005487e5ad3445ad044c6045a80045a83045b90049eb8fb8215375fc27bce0c1f3882eacf75a23f03808bdc0f2774dd4fc4dfc06737235993b061adfe0d0c0bdc473329b2adfb2fe00bd6399acf647f8398b0071c03ceefe0b37542711be89abf733c00b0fdbfccf7591e506b4edbea411c467edfc70380527924c4ed29d22cdfc088a8164a849ad7985ad30e8e1d86accf6dd2d1dddb7690e6856e38ee5a4d45b4e81d64ab8f9cc60d3187ee6d3bd0d5966550528d7428ad6907316b60da4d094d405b4907ba1e362c334b844af70a0e7dc6f528db4207e0f50d0c11754f83198a345f17f484446562f55c463252d64a3a50f2c83e4d408658a145efc006aed59a64060eb295747094c98d2321fcd0b6b46d3b28946c830e38b5b3bfc251b32ee30033a11b69db761001c944103b2787482be9a07a43d6c4ed75055eb7601d44bb1fe787a9f1b33173377d82e116b6c9b771f0aa35ed20c2479e14f140250c77d3279c1f7cb2731e9921d8b5a61d789811fd7c7020228757808de5302e580dd775fb37302cc3b256c74e51c63be913ae819420dda4334c77f40e622033f60a2d447e9574704d5a36cb357735aafb701df830292aabcea750ac05eb008630cb68cbe010fa3acb13f2b971ed08afbeea7b603a08225ee320c2a058ba9b76a0e335bad1baebd5a8b605eb006420cb46859a14be8fdf81c241067e9405499d5b4907b1ac661bd7acf55eef4fd94159a391f6fa75860af7e07650abc381f9f69b7adda27700d85f91ad2de87a74eea44ff0f9a861e4fba116ee5b490786e9b4ac408411805bf4175002c6ebf18bd61fbf0010448673321b86b66d073e2ba6ae81524438f995e30180d564139db13de7fbc9e9e0e7fabbf00feecafa6c081bbf0c0000000049454e44ae426082', 0, 53, 13);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (355, false, '2023-06-19 22:35:37.181373', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000023949444154785eddd4b1d1a52010006048b40549a0354da4054d14126c01136c4d1269613791e3e4bf7fe621af8123f39b7117966549fc5c40fe2b00d211a981ba1915ad02c6dd92861efea407d641ef6e126ab899b7ec1be0d948db8cf22bb8560925ee66fd067147db1e86edc7ef3e3e0108db7fd6bfb3149056382ea1668dbff5f80498f83400e1eb11ae1ca304bc46a66f891b346dde470971535d0b0b598d08394b09083db3ed166eeaafa10ad01edbd5cfe8f11e7415228c449c0b97666ce62fc076c490f6e6c6b50ae84350c28d72437c82be0046de75e29c7ab2465f07323beaa477e9bb0ed1b4c1c3aab8b846590598d66bde3ce2e6afb60af16296d32d449098839670d3735664e9db4be412bea1278df48a8670d2fc4b09d1a7533b61e58190d3be60df53bb3033d861cfd750020ce8563c76b730cc2d5542b4d4b43761c7013f694bc00dbd36ab1bb40f5b1560b6f4e22cc5bcc973d92f402b416835848bf4cff15f708fcd329ff26cc67e7aaee10520d2d9389f26328abd0a77ab537737f4ee78f3b4d40bfe5e902312a4a13e3f8f12d0081dd0035fb5cecfa30490304d7c69a48ee6d9fa0be2a68113b187f40aeb80db25d314f066e9c75ca012ee859e12c65e9ac13f69dfd09eec70297737dcb40a20ac808630ad2622aa1023225ea97a697ce5db2f0188b029aee57cb6f9359490465f4c53cfacda433edc0bb41da2217c56137ddab202aee3a9004738f9cf2f2f38dce015693797e65615e2be29e13d74d2b12aa4111c5ceaa8f4d02017a884cff57fc31f2365891fe442b3b20000000049454e44ae426082', 0, 59, 14);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (301, false, '2023-02-20 22:04:28.045164', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000023c49444154785eddd431b2a4201006604ce40a92c0d524d12b682290e01524c1ab492257a0135856665fd508ef024bd504f395d540f3034adf23a0ff0a0222cadc1b3f13c8ae09904c1886515c6377421b94d1ebae4524ee20bf01b8206c3fcdbfc2e9244524f6e23748c60ef8d4c49c3febf886bc74f3193f7bf9869462677ba6c50efffaf182b0b030204447c4ef52e30d09ae09cbd9d935f967da0a40ed070b425916e7a7680511dfd89ce062e76ede8661603731de41e4aa0990ee85e985ce7aead726a4a3936b1010675ba6ad2179eff6b8ac0a3e9b7b43e8d1d81d8370765a9f692b48e95a78dcd0b6e0bdf4e30d819dde431cd99e0fb309494f53fedac3ee3eeba820494409e47a33b826401039301bc5372b2dac20ffe89c53edfd85da0000678e835cfa15f626446ebcb1e4b4a83bca41bd21f0402465c65b5216564192ddd5415ebec853b721a5d3687c71e56edc068b4f2f99de48c4e518de00e7852807e7ef7e9b9b908cded6b08cfdc45339b90ae022ca0a1fe9fc13fe6f887857116d0339b69e352150e1ffa68625e59ed055909cee6ea1e44667551a54c1e98f71623affd565fb6f801b1f4c76c6efb12b97f00d918e5829c9f5c6afe77ad4b0917c8d8d9c3537e59a56803d584ad780b8fd6cff058169aeb9c4715850d9fe1b72a135c91c070f7fd3db808098c40731c992a3d47803a4431c343f5bca8512dc0ad4c1ef59d2552e5d89430de7c19457a70fec69720be27a910be7d7eb89650dc9dc885d6b1884fdbc412f0868d888cff946333cd356f03dfe6ff803771c90399c930e090000000049454e44ae426082', 2, 20, 14);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (151, false, '2023-01-19 18:14:50.471192', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000023a49444154785eddd4b1b1ad2010005049a00549a43549a4054d1412684112694d12680112788cdcff679e701b781b9e1957965d76c8bf230c7f0ac2808d1531901c39e842cc273be170e8004cec83d0ea9c269ab03df1173857aafc0917f6158c908c93048f6f9075e4c848accdbf73bca01c5d7fe27f2dbfa184c39218af622dbf81b012afc340ac63aee6784374f34813bbe134a1e793162e72d1b000c7bcf77d30d18d48f904a2dbba9036e1e0bc621b13155d88de1d3ea69dc905d61c6f08d3381ed68bc4aee5e8428c56941e2cc7b5e59ab40189e54ace7de3e34ebb90a88de63aec8d127adad040ce5ab89571e44b33bb10cf1d5975d3a8e2e792df906fb8e2a8540e2cda2ea4611d81cd1c39e2eac1de903930be4cb5f737a839de104bfd5a19be9d5b405d08583b22b471033deb7cbc21db309368045f70ace5bf21f26182fb30eccb0aeac0bc212d87e590042a6c2dbf81f25be325b9769cb0e842e4d4617151ef4078ca6f41e99bdddb0d9799d6f2df10267aad102e8764ee79840de48424e2ecda7482a40b897a9d80a4eaa2f649da406925752be04829f13c8f06c25e06f29a1626a2ac6d6880f2159d407b9550bd8f3724129588d6ca7da6754e1bd8e1ccee7966723e6a1b1a40566b79b8659ae173850d0462ae117160cf15982ee43254da9b93251c3f3be8056128d966cce1b47d66ec0d6505a3b2f5f8216c607d10da26c0c78daf407f01734e5808e313a9ddefc0c5b2105ef1e993f40de5b71cdd232d0d7fc6a181b282e3c5ac9cb75c9f6903bfe36fc30fc36092af936a296c0000000049454e44ae426082', 2, 22, 11);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (351, false, '2023-06-19 22:29:57.127187', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000028049444154785ecdd53d9aee1018066069d8024d6c2d5f936c411a3f0d5ba0616bd1b08568389199292632fd51ded7e5f5909780f67b9ce0bf013955c890df4c5327a06f108a3331a8b4b9736fe10d2cc99e4f7ecf39edea0f301e6ea514f9717f41d3b4c919aea4bc432812ec9686124af9cef10039b99f61bff7f280d68a5d3e416ed9fd9cc7032446076380ba734bab7803d74a53096e7add63ea4507a878d26065fc63a2c7afe0a170214a80f4de628f3e80534d23bdecd1d5e56bd9274838cfeb3a2f78dd4dbd77fb8404308748eed19cf3bdec002a58c8f94a12242df4ed0fd02413d767e40c23495fa1d2636533c4a80a7b071b200194a3c678810b267dca00ceb473059332754a730f36803a8406286d46e205dd4907d0c2cf6006806db9f66507b07b90c49d53b41c825738382ac742e50a49857dd90182c4e06a07727e3c807dca00967aaa12752aa1607ab0018c932be0442f3327b6171d21b8187290a27e82ed45073801a64d49e4f726ef231c6105f8a32aa3154ebe171da0770cca95e690cbf10ef56a25be2b8ddc81c21b1c606a39d7999c5b4b3dd8005514cd6888a648715fb101fc5e510e1a2c505c57e90d2a959801f6a934caf92efa8452728e255e7768d3b4071bc08a03b9928be400bc833ad8425c56cd34f3d5410398abe4b149a44922f79427a4e95cd86e678cbfa30fe04cbada8164f9d1f8eb663f414f279f45ae1c88701fd000b1e2ab6ff7783556bd1fb6012a437a0a122929e43bb4763dc1975cb982e9d1079093475913d7c2417c0f36c0f5f2c6caa9cafd83f6290358a2454e006e7693538ffe027e65f4ba84d1d2fc0718533c3a3f56a8bbf907b87e050b9fcc21eaeeb7af1c0f9093b16cc5f3c2f87a2f3bc0eff1ffc23fc0c0f8bcdb35bcea0000000049454e44ae426082', 0, 55, 10);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (352, false, '2023-06-19 22:31:07.28197', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000023949444154785eddd5bdb1ac2014006048a00549a43549a4054914126901126d6d49a00548e0b9b2efce2c721bb884df0c67ce9f08caf789e04f4104c3e65404b42409bb908ab506c162233c531f94cdc3885826ce905fc0a085068366fe2b1c33229266b4fd06c56a49cf9dd8f3278f6f8880d8cff95f4b03ef9ac94e75d0e9a71fdf109791daab7ae7b9af315a4807972c6f2f348ef8bed2012c599ca1e721843eb8920cd621c3e44517f240945916e15266aa0fc405c94ae6fb8cea95168ac73b4f41657ecc5b17b2f0d820306d872835680b6547cb428f55c861655dc8ebe6ce83bb17cef81ec3038a5286472e71b886d98594d7016097924e9f26b750943688efb4447ef5aa0791389b5c9eb0a7fe4eec01d742abe0240ce105ef2b0f282e0aabcf5d18117117aec55da824a707ccd44c5bc82c8e349d4ace24d57eb45024a07e93609d1758b7b0854c3c743b3d9872e133ec06e2328c38c2632579a8d53e002c0826c98287f16ef2038a19117fb1179a2756cb6f21996958d0386f3bf7f5236c21229ab1e452d88c681f58e4196a830fe6eaa05a78af235a00d35aabfbf378028cc28cd47395b4ee427a015624b441675c536f210ecc501bdcbe4eac3e172de415ac3c4f13dfa7ad8ee101d863b56f711e277437f90191aa3c60499d59e0d9852b90b09e4a9e49aad36fe17e6d9895681475a51e908a41e2a0fba65ce47d5066a05a8e422ed0fe02073e835367c8b476ec09e76b2b4ae2ebda27680bc58877694cf2a3ee470bd7ef445c6fc13189f71bd783eff3b7e11f883f81931eff2b340000000049454e44ae426082', 0, 54, 11);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (353, false, '2023-06-19 22:32:28.974725', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000028349444154785ecdd53d9aee1014006069d8024d6c8d26d98234210d5b8886ad49c316a2e192995bcc27d34fcaf7c9f9218780faf3b9c19f0135d528a6b29a7adc80be81cf0a5d8ec7d586adfa37384999f7c96d1aeedbf10ba87d32f5c633b7bf415926afe811a6fc0e3e1bb569ea03def2771f1fa026fbff39bfd7f201b546ccb8576b3ae5f77e7c80c2986d11507baf71916f904cf24744462fdb157bd2011cbf1792ee9d9bcb3d650750a86c3e7085342febd3fa27587ba59c020fc481a7ec00412627e0cc20c3a8f4a4039c6073c8b8d63d57b8870c50204d4508122196ee15ceed9411ddbbc048d1fa064aa6b805d86acaf36bc73ee16a72cf02f7ce480f19a0ccb3d8177e687455d55b1fc02bb0ea2dcaaca8923d6480206d610cce28195b7ad9019c580031652a7dedaf901dc94120b540bcc35e7600af30eb51377700f69001b23fa95aa86d23e14d6f6c0045dc421cd16cdec9d9930e60bc391cf747d2dceb9e74804b4dfec66d98b054a8271d20aee626d92df48493eb4907b8b99a219c79806b0eaf1069448509ae910dc8bf41b5374da93a72af85f5c606683d43b13a6eb2e2cff2074881a1403510507e850c70eee41682b5d72ffd2c6e8023e788a5f1d7bd6ad21b1b209b1ce595faf901f415bc55dcfa745dbe9a676006b8f72d07b630a4497c920e90150462b30e63596d6f6c80c3ad55ed78d55c4fcfa71c40032c403b870c48937bc80057f5d5319e8d39eaf3290728023269553b85553d833b406d974ec0d4b79579d35b1f404dedb6a8d61700c873190ce0739cca339682fa1e32c0d9e63a1d0aaee7dafe2cef6082a065baaeb6d5bfc0892edd4ed8b94faa971da0ff0a16aec5025727bffaf880763ab26d03916dbb8a7bd2017e3e7f17fe01c841f0dcd6c3d7710000000049454e44ae426082', 0, 57, 12);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (356, false, '2023-06-19 22:38:11.252495', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000023749444154785eddd4bd91b42018006048b00548a4354db405491412690112684d13680112f838d9fb664eb8068e68f799d985f717e49f27803f0501506f0dd322300ebb1073f94c844cb3b0b10fc29afd08cbb8de8afc02fa76185a87d75fc1aa0df2e196f937c80a4d981a84e9f73b5e1000d19ff31dcb0bcab915a2da7e87df40809c69cfd13e8ecbda8534b293dd8e709630eb42d80705301872c083e8423413356bbcc6c321da8752847108306d68af656840adc2ebecb6c1909a8f376443ee84311a893e6bf86f48cb364bcf0f1d1379c26f2026305f50cb2ce43577216d1b8b22e1390da90fd1caaf629786b9cf5aca06ee341ede3a121d7a52d801051d42f062d6d53f7d437673699892e2d5c7bb0f0aa0897034e80bda3e8818c342a5be6378ae6d204605bdd59213ad6a19de1058d4d25b11f31d8e2ee40b7240f950be7fae7d43bc1d3c97398afc3ffc17a485266acd3297ee7d8add40bc98703bd1610d87ef421af1b6e3c17f0de1d08512b395699ac03e7fc6e30df91cd261fd45b5ab0dd340801728190c6088a98e47033327b7ced2c073165d2883650e330b99c3f2a4b081d28eda4b3e0704c8f39316dc71b273223a2b56c7e30d69a7690268956181f5da06ca3a523b4c7859c6fa8e3704aaf632eab454b496b28192140ca315619f436ddc3794b5758289987162aa26e80d31dbdb262a6ce918da07a1f9b801b494ceaa7dda8222de4c8c2f183ee3d101cdcbaef13eeaacfb5076b3cc6647cbb43fcbb181f27457764af4d2fa5adb37fc3c7f1bfe01310b836d7535339b0000000049454e44ae426082', 2, 13, 15);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (358, false, '2023-06-19 22:41:31.067817', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000023249444154785eddd4bb91862010006048b40548b03549a4054d50136d0112694d13686149d863f4bf9b39e11a3832bf19759f10fc7d80fc2b00d25dee18a715a6855621a219195fd4215717ebb03ae7f01c84ba0cff03ac17ca3acfd49fe04200d25e3bfe056884e6ee6858f713c76f00c2ede77ce7f202c4c4b7a673f63bfd02802eca7ad26821065505bc4e365d892f53625315e2b5af27232d026bd72a80f25aab788ad9375d159216d4b740d3d8e83bf402d00ce348711bdb83dfe917008d9027e39be0767bea51c2c0ef46c4c49ff4df80d0e149e326d7fd945548d365e3eaa94d6daa03b00e1a46f724afed6e6501899ef2502ef1e89bbb8405e4784088a63d27e7ef8f1680366070f9db2ac4ab0ad110a6f9d2b4f6a4ae0a4902f5ba5bed15e189a380c95ec1d935716b9ebebc016d0c7b7046e2057315621ec6b35bdafcfc89e30d0832294fc38a9ff40b48239b7dbb68699aee6e76098dcab3422d2898eb90770c7ad2869f252c204d676e633f1b2d315401ad3b67b763dee7cfc0bc21f53d193a4fa18de909bd00690fc25d6e7a9eaa2ac4ada78796f92e80e129e11bd0b0beb3464243d8330e6f000993d73db768a63bfd0292e6a7264ced30d0278e025acf374d93180671ffb600e88efc0661822e4f2b0bc8451969740bd1129e48df90afad70add61dfd64ee021510f1e867e7569727a6abc36a78384833d085dc635901bb4d078dcbc0e8b31e2518d1730c215ab47540a32ce62b78e8f57d39169043df8631777177e12e6101bfcfff862f136182ef2622c3020000000049454e44ae426082', 2, 10, 16);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (360, false, '2023-06-19 22:46:17.503943', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000023649444154785eddd4bd91ad201400604ca00549a4354ca0054d50126d0112684d12680112589eeebe99156e034bf8cd88e717507e9f08fe144430516cd608c4ba0f5d4845098ae579acd2a63e48836c5ed8c49dc21f4051c6b5f523ff08f6a87f44ee2c9fa028b88cc4c091fc8fe3374480f5f7f9c9e505f59889911da5eff41b88c30ee7b0a3cc0de35d283a22edf2886bf05b17d245141b4708f185741f9c1724a46bda32445dc84896bc25991728eed01b2825edc40bb82083eff41b8810e765d0c784f5f1d4e30dff6eb47ee2f612e4a9c71be282cb0ec8c1866b767d109be2d2e372c071ed031b641d8433e8e49f38de90010fbefe14a70cef1236902e809c47e55aad9fbb9021e5296f6ae421dd81351047802fbc43a4afc176a1e8e40cb752fb35dea1b7e0d41a0c3e93d45a7621e274064fb40deef9a481a2001d0c40665c86e78e068ab3a79f4f59fc937e03490148f42e6605e15dc20632d84e67061d790a4f3d1a580da08084ba84f24ebf81222fb0793adb48e133fc6fc86248c5fa858d103f77bca1a885c109ce8ae87c37aa056b905382a1b4cff77a3490d76b1162ae6f41e6f7683710a7bac2e73e4708c767c6de50f6f55818c3ba3e5f4f1bde90c5345130f133d68ef7018560d8500eca3de94224d25e239804ae4bd2855257688e448d9b8bdfbd7d417db6ccb0e303d255f52115b39acdd626b988fb20f5850c806cd8c127a8837b80756710dc6de801a5a49c219df9e79317d4fd3883953253718f43033574c5165aeb8b9e356de0f7f9dbf00598ff6fa53ea709650000000049454e44ae426082', 2, 26, 17);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (362, false, '2023-06-19 22:48:47.171616', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000023849444154785eddd4bd91ad201400604ca00548b43549a4054c1013694112684d1268011278ccd57d338bdc0696f09be1ccf903507e9f08fe1444300a6238006295431752d17e26bb3ad6dda63eec86d83c2f237327f902a75898b61eb3af60a3e0003955be41d186e3c9403cfdcfe3374440f4737e6a69a0940c4766254a4ff92f88831434489499595817d2b905ed3c2635f9ad0f19cc0bc610920be92e94c8e414d2356e19a22e4480a7bc259739144f2d0d247789c96f074786dcfd68216264f8a08f91e8e38ed142ad3ad5aca9ad373fe5bf210224013996e1a2ae0bc5b983ed999403e2b50b91a9501741059dfc9d470b65f793af0d2629c34f0b5f10e9899c87f45aada75d481767290b8e594877a62d643ca48b4888f435d83ed0480cb34afb357e527f41715a054354dab5debb90690ac14fda06f713a381720d66300019cc873bc60b8a5f95a7612ffee9470be918e4a48da0274477b52f90f3e6cca4234ba10f11edd70c50a88f70ff94ff82e457b9794e6d9ce1bdfc2d647ab062fdb260489e16361007bfc011e973d2f99e5c0bc96aedceed6049d2fbbdb41031c742cc5495bc7c3e8317d4f6a7a2248d10e23b680b1172c89799e8728a7b2d5bc8028a198c4c4566ef51be00156596c11d33f35317629df38501c944823e9412398d93e49b8bcf6c1ba8df961924517e5ecf3ea46293d96c1d928b77f92fd8f5850c80cb501feb17384938c02a17089e8ebd01cc535121a9fc73a58172ae75fbd19e6771ef470bf5dbc20b9fc516d1f36e5bf87dfe36fc0351aa7539fca27cdb0000000049454e44ae426082', 2, 18, 18);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (357, false, '2023-06-19 22:39:14.683098', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000023b49444154785eddd4b195ad2010005048b4054da0354da0054d10126d0112684d12698149e0b3fa76cf59611bf864ef1e1f0333c3a0fc7b45f45f4144a3e40a945d41e2264036eaec10552776d0066594a6764ea3d7e31fa0d97804dd31fe27d885064953b7fd0559f77b47f7d1b8ef73bca01cdd7cd6cf5d7e43594e5d54af0a7ef2f11be242c40c92cc2e5ccf1e6fc82eae2a6ddec5aebfc356007a34210a44771aee4d2bc8a718d6e30809fb6b6e0258c4c8b0828734ab36e48b4a2204df59b7362111d287c855e2966d4d88f49c6d374deb01706f5a031baf812c42a02dfb26940c316c39ece5771b12220cc74d597a31de84f2a133870738fcd5b7211b7fe1a3e497c313e50db1e3894a81fa8b3e29ac2047acbfba3a84137f4efa023071f496eeab837887ad201bbd50391ad0b3b913540380dc62092c46788a5dc18973c81251173fe7784342d3347582ccea73fd0a20114610b6624ce8791e6fc87ada249673b8d074b7430590e8c5cff5ecd8b4dc65a8209fabb1842c0b62d434a154d11fb2ebed40baa7a5de00e57558c421ecd83fcfe30da977ba071fc9a6d49da006246c4ab77095f7bb94157c0da55046413862d786c8d34066ef7731b1fbfa15243188f56413df67ff84ada04fbdb21b9cc39c7013223d5cec25c27241b409a51f0c949143b3f9eee4174444d66b365a9055dfc5aea08c3eb26c6e2fb98e9fdbbe41194d9524ab5cf0dd960d70875212bb7092cf5f2af82a933afbc396b9d584ac474bbd8903b74f17be21a2a1b7774ff1f824e80dbfd7ff0dff00802c8973e176eeda0000000049454e44ae426082', 0, 39, 15);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (359, false, '2023-06-19 22:42:59.87049', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000023349444154785eddd4b195ad2014055048a00549b43549b0054d4412690112690d136ce192c067e99bbfd608af8121dc817acfb982f2ef03e84f01a05eba63890a960d3721667b01dba6c4958b6d50879039897e3a0dfb02565d81b9d04d5fc11d3342f4d4f91b6483c66e384837fc7cc70b0031fb393fb3bc20e7b4183268fb337e058055b4d746c6be17531bd04c963360b3a46e6903533bea1075d051d5847808eeaee87b19c8d086d3942200a799ac4f0d6f48dcb3ab843cd383dde3579013928919d133bb3fe3576063c9d7731d137bf2a800fac523be49a53d6f02a0514615984a347d81b98cd5619df8b9df55569041acebe43c8b81dc1156100fc20321d42f2edc0fad2089b58c9e4d375df16c4387d6116f845a8f5d1380c102ebe0f419e153e51bb0192e678f9559f3ecd81b52095f8741a97c826c42f6b8fc65a5cd139ed756907862bbc05ae5403fddbe00a8de7b66566e48ff64fa86ec677e1dd8c204f21ebf06abb615b1ebff4f5801602f751a65796cbeda402848a7e369c3b33015c4308f620868a6313d55be21877ef2cce58477ae9a00e3d8cb84b02e7b71475841d43686e1e04010bb87ab200919e6bed494cdf2645ac13aa4b1eb260d02dfafad817a6a56960f21faa7db37c0e00ec4366cf0f659a937e41c0147a7fccae15edc0acab51510622e8d8b7996ee0d311ff8904eb9b252431b94f5d46e44e00ddd6bd9021b661c37d1e127b11a0c1238d12bda6cdb50ee669dcb2d2ec6f5be1c2b289fbe8b99a741bbeba9f20dbfcfdf867f053777f704f83e380000000049454e44ae426082', 0, 61, 16);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (361, false, '2023-06-19 22:46:51.856518', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000023249444154785eddd4b191862010065048a00548a0354cb0054d50126941126c4d136801123846ee6ee694bf81237ce3ce2ccbb782f2f744f0af200206a89b2350f30abb908acd826ab3cdfa487dd08e30a5241baf9d7e805a82f8e1c9f8111c991dc097299fa05827087788f0df3efe4204d47e9f9fbb3ca0940c98e41b4ebff3784084ab1a3cc0797472fc0097b19727b436bf74210b26242108d113db2e4429000fe9644b46b80be544d39222cc1352adf527e46982f57b3f6147efebbf2042c704dc11a3766bf37842f2537d03311ca7e2f7f55f90095a56786d129ec3d585385ce7a8332d1b227317f26c7741a00936f9d6fa138a8edc84e3a429a37b842f489eef4ae2e39c0f3f74212f579ca422640ca975fa8448003fe18ab03de1d185942275e3a1ad9fe3ddfa1bac0dc1515b036c7517224c2678ae8f70b592374c400906b023136c254f289b64d843a38bc72da72f08a6f8a5467347a88df00971f1027b6ce39842e842168409c6435d427d5fff05718e62f46239a2402dfc4f48c9d172042f09a2df237c40248a216ed2ce6dbe1fea0579e2e1b2651bd33ab47d7901917356833625cb16a917486c43fd3c22445ac69e507430212a6acbaeee92176405d4c4d868627df13ee0386e75fdb63a04de85c8577e1280145d411feaf34d433aec5ee3b9742102c2a0b66613f3de87540e7be41aa97245da07bd0bea009270059fa026d789799508b48deac03ac15cd7c7e49f9207146b4d7183ce42b5383ca1fe827759af57226e6bfa82bfe77fc317d7fd692152085dd50000000049454e44ae426082', 0, 62, 17);
INSERT INTO public.reservation (id, canceled, creation_date, qr_code, status, term_id, user_id) VALUES (363, false, '2023-06-19 22:49:20.3514', '\x89504e470d0a1a0a0000000d494844520000007d0000007d0100000000a7fb51880000023549444154785eddd431aea52014066068600bd0c8d6b4d12d60c38546b7008d6c0d1bd8023430dccbbc491e7237302426e64b50ce39bf82f27b45f05f4104ccd36b8f40ec120e2115cd672af1b12b9bc6a0ac6399afd3766bfa05f4fa2ac67ab27d850b6704f07d966f508ce3805d88b09f73741001357fd74f2d1d9492c1b43289d3bf7e7410a1244b90386fd7ba8d612bd6dc99d07af8d71838732b21085187cd10ca59920dc94daf8cf01092837ade92ca1c8936861e4ae69c0b8138bee8a7fc0744aae24ccd31d5abf5a387e2f662bdd8ac13acf5a38714a7770e8e15bae51e42667588cad37220b20f215d4cce849ec124df6ae9218a3de360334d19b516f6503cbe33c7b7dbad5f86904a9230bf34d9426a27ed21cff07450226c1cb443a8d5b16bb3caf83d7e8efe046542b0e64cca18358474471a3c3336dc6dcb038a84e76d25be0887ed193dd43133bf2ea7aa55b631f490717d5b9062d108b7e21eb03b56db6be29642dbd243142cce8085f7b83ee53f6129f2e5e7c5c619b5f03f6085a52686af04d1b6a587a2b7034d68d1cce436b91e326007d4a28e492e9fcfe309302f362ff55f90d796b11ed2793a6ce51211222d0e3d44ea6938566a8a169f2d0fc802bb799ab633d6898f01dfa6263f1df3e6d91022932f47c024a8046378676a495693d71d5bb47b88a0de2a73fa79d76348e52242b03aa49aad31289382066885127c05bff279972b02ad6303c89c9533a433ff6ce9a0cef22c56a93c8b4f1c1e507fc1fafdd01271fb4c1ff07bfddff00722ab8739fb6c14f70000000049454e44ae426082', 0, 50, 18);


--Questionnaire questions
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (1,false,'Da li ste do sada dobrovoljno davali krv ili komponente krvi?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (2,false,'Da li ste ikada bili odbijeni kao davalac krvi ili komponente krvi?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (3,false,'Da li se trenutno osećate zdravim, sposobnim i odmornim da date krv ili komponente krvi?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (4,false,'Da li ste nešto jeli pre dolaska na davanje krvi ili komponente krvi?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (5,false,'Da li se bavite opasnim zanimanjem ili hobijem?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (6,false,'Da li redovno (svakodnevno) uzimate bilo kakve lekove?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (7,false,'Da li ste poslednja 2-3 dana uzimali bilo kakve lekove (npr. Brufen, Kafetin, Analgin...)?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (8,false,'Da li stalno uzimate Aspirin (Cardiopirin)? Da li ste ga uzimali u poslednjih 5 dana?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (9,false,'Da li ste do sada ispitivani ili lečeni u bolnici ili ste trenutno na ispitivanju ili bolovanju?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (10,false,'Da li ste vadili zub u proteklih 7 dana?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (11,false,'Da li ste u poslednjih 7 do 10 dana imali temperaturu preko 38°C, kijavicu, prehladu ili uzimali antibiotike?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (12,false,'Da li ste primili bilo koju vakcinu ili serum u proteklih 12 meseci?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (13,false,'Da li ste u poslednjih 6 meseci naglo izgubili na težini?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (14,false,'Da li ste imali ubode krpelja u proteklih 12 meseci i da li ste se zbog toga javiljali lekaru?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (15,false,'Da li ste ikada bili lečeni od epilepsije (padavice), šećerne bolesti, astme, tuberkuloze, infarkta, moždanog udara, malignih oboljenja, mentalnih bolesti ili malarije?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (16,false,'Da li bolujete od neke druge hronične bolesti: srca, pluća, bubrega, jetre, želuca i creva, kostiju i zglobova, nervnog sistema, krvi i krvnih sudova?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (17,false,'Da li ste ikada imali problema sa štitastom žlezdom, hipofizom i/ili primali hormone?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (18,false,'Da li imate neke promene na koži ili bolujete od alergije?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (19,false,'Da li dugo krvarite posle povrede ili spontano dobijate modrice?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (20,false,'Da li ste u proteklih 6 meseci imali neku operaciju ili primili krv?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (21,false,'Da li ste u proteklih 6 meseci putovali ili živeli u inostranstvu?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (22,false,'Da li ste u proteklih 6 meseci imali akupunkturu, pirsing ili tetovažu?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (23,false,'Da li ste pili alkohol u poslednjih 6 sati?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (24,false,'Da li ste bolovali ili bolujete od hepatitisa (žutice) A, B ili C?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (25,false,'Da li ste bili u kontaktu ili živite sa osobom obolelom od hepatitisa (žutice)?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (26,false,'Da li mislite da je postojala mogućnost da se zarazite HIV-om?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (27,false,'Da li ste ikada koristili bilo koju vrstu droge?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (28,false,'Da li ste ikada koristili preparate koji se zvanično ne izdaju na recept i/ili preparate za bodi bilding (steroide)?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (29,false,'Da li ste ikada za pružanje seksualnih usluga uzimali novac ili drogu?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (30,false,'Da li znate na koje sve načine ste mogli izložiti sebe riziku od zaraznih, krvlju prenosivih bolesti?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (31,false,'Da li ste imali seksualne odnose tokom proteklih 6 meseci bez zaštite sa osobom koja je HIV pozitivna?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (32,false,'Da li ste imali seksualne odnose tokom proteklih 6 meseci bez zaštite sa osobom koja ima ili je imala hepatitis (žuticu) B ili C?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (33,false,'Da li ste imali seksualne odnose tokom proteklih 6 meseci bez zaštite sa osobom koja je ikada za pružanje seksualnih usluga uzimala novac ili drogu?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (34,false,'Da li ste imali seksualne odnose tokom proteklih 6 meseci bez zaštite sa osobom koja je ikada koristila bilo koju vrstu droge na bilo koji način?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (35,false,'Da li ste imali seksualne odnose tokom proteklih 6 meseci bez zaštite sa osobom čije Vas je tadašnje seksualno ponašanje moglo dovesti u rizik dobijanja seksualno prenosive bolesti?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (36,false,'Da li ste Vi imali analne seksualne odnose tokom proteklih 6 meseci?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (37,true,'Da li ste u drugom stanju?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (38,true,'Da li trenutno imate menstruaciju?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (39,true,'Da li ste u poslednjih 6 meseci imali porođaj ili prekid trudnoće?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (40,false,'Da li imate manje od 50kg?');
INSERT INTO public.questionnaire_question(id, woman_only, text) VALUES (41,false,'Da li imate suviše visok ili suviše nizak pritisak?');


--Questionnaires
INSERT INTO public.questionnaire (id, date, user_id) VALUES (100, '2023-06-19 16:08:03.294', 10);
INSERT INTO public.questionnaire (id, date, user_id) VALUES (101, '2023-06-19 16:10:50.426', 11);
INSERT INTO public.questionnaire (id, date, user_id) VALUES (151, '2023-06-19 16:43:56.005', 12);
INSERT INTO public.questionnaire (id, date, user_id) VALUES (201, '2023-06-19 17:22:39.706', 13);
INSERT INTO public.questionnaire (id, date, user_id) VALUES (251, '2023-06-19 20:04:17.452', 14);
INSERT INTO public.questionnaire (id, date, user_id) VALUES (301, '2023-06-19 20:38:01.184', 15);
INSERT INTO public.questionnaire (id, date, user_id) VALUES (302, '2023-06-19 20:41:19.038', 16);
INSERT INTO public.questionnaire (id, date, user_id) VALUES (303, '2023-06-19 20:46:07.628', 17);
INSERT INTO public.questionnaire (id, date, user_id) VALUES (304, '2023-06-19 20:48:35.049', 18);


--Questionnaire answers
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1000, false, 1, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1001, false, 2, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1002, true, 3, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1003, false, 4, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1004, false, 5, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1005, false, 6, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1006, false, 7, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1007, false, 8, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1008, false, 9, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1009, false, 10, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1010, false, 11, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1011, false, 12, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1012, false, 13, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1013, false, 14, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1014, false, 15, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1015, false, 16, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1016, false, 17, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1017, false, 18, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1018, false, 19, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1019, false, 20, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1020, false, 21, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1021, false, 22, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1022, false, 23, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1023, false, 24, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1024, false, 25, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1025, false, 26, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1026, false, 27, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1027, false, 28, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1028, false, 29, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1029, false, 30, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1030, false, 31, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1031, false, 32, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1032, false, 33, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1033, false, 34, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1034, false, 35, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1035, false, 36, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1036, false, 40, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1037, false, 41, 100);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1038, true, 1, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1039, false, 2, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1040, true, 3, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1041, true, 4, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1042, false, 5, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1043, false, 6, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1044, false, 7, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1045, false, 8, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1046, false, 9, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1047, false, 10, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1048, false, 11, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1049, false, 12, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1050, false, 13, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1051, false, 14, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1052, false, 15, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1053, false, 16, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1054, false, 17, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1055, false, 18, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1056, false, 19, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1057, false, 20, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1058, false, 21, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1059, false, 22, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1060, false, 23, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1061, false, 24, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1062, false, 25, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1063, false, 26, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1064, false, 27, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1065, false, 28, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1066, false, 29, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1067, false, 30, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1068, false, 31, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1069, false, 32, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1070, false, 33, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1071, false, 34, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1072, false, 35, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1073, false, 36, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1074, false, 37, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1075, false, 38, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1076, false, 39, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1077, false, 40, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1078, false, 41, 101);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1101, false, 1, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1102, false, 2, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1103, true, 3, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1104, false, 4, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1105, false, 5, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1106, false, 6, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1107, false, 7, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1108, false, 8, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1109, false, 9, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1110, false, 10, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1111, false, 11, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1112, false, 12, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1113, false, 13, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1114, false, 14, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1115, false, 15, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1116, false, 16, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1117, false, 17, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1118, false, 18, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1119, false, 19, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1120, false, 20, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1121, false, 21, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1122, false, 22, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1123, false, 23, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1124, false, 24, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1125, false, 25, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1126, false, 26, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1127, false, 27, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1128, false, 28, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1129, false, 29, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1130, false, 30, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1131, false, 31, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1132, false, 32, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1133, false, 33, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1134, false, 34, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1135, false, 35, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1136, false, 36, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1137, false, 40, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1138, false, 41, 151);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1151, true, 1, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1152, false, 2, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1153, true, 3, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1154, false, 4, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1155, false, 5, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1156, false, 6, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1157, false, 7, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1158, false, 8, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1159, false, 9, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1160, false, 10, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1161, false, 11, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1162, false, 12, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1163, false, 13, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1164, false, 14, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1165, false, 15, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1166, false, 16, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1167, false, 17, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1168, false, 18, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1169, false, 19, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1170, false, 20, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1171, false, 21, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1172, false, 22, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1173, false, 23, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1174, false, 24, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1175, false, 25, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1176, false, 26, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1177, false, 27, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1178, false, 28, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1179, false, 29, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1180, false, 30, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1181, false, 31, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1182, false, 32, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1183, false, 33, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1184, false, 34, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1185, false, 35, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1186, false, 36, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1187, false, 37, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1188, false, 38, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1189, false, 39, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1190, false, 40, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1191, false, 41, 201);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1201, false, 1, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1202, false, 2, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1203, true, 3, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1204, false, 4, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1205, false, 5, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1206, false, 6, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1207, false, 7, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1208, false, 8, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1209, false, 9, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1210, false, 10, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1211, false, 11, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1212, false, 12, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1213, false, 13, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1214, false, 14, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1215, false, 15, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1216, false, 16, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1217, false, 17, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1218, false, 18, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1219, false, 19, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1220, false, 20, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1221, false, 21, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1222, false, 22, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1223, false, 23, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1224, false, 24, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1225, false, 25, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1226, false, 26, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1227, false, 27, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1228, false, 28, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1229, false, 29, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1230, false, 30, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1231, false, 31, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1232, false, 32, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1233, false, 33, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1234, false, 34, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1235, false, 35, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1236, false, 36, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1237, false, 40, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1238, false, 41, 251);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1251, false, 1, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1252, false, 2, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1253, true, 3, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1254, false, 4, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1255, false, 5, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1256, false, 6, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1257, false, 7, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1258, false, 8, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1259, false, 9, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1260, false, 10, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1261, false, 11, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1262, false, 12, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1263, false, 13, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1264, false, 14, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1265, false, 15, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1266, false, 16, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1267, false, 17, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1268, false, 18, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1269, false, 19, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1270, false, 20, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1271, false, 21, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1272, false, 22, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1273, false, 23, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1274, false, 24, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1275, false, 25, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1276, false, 26, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1277, false, 27, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1278, false, 28, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1279, false, 29, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1280, false, 30, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1281, false, 31, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1282, false, 32, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1283, false, 33, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1284, false, 34, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1285, false, 35, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1286, false, 36, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1287, false, 37, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1288, false, 38, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1289, false, 39, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1290, false, 40, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1291, false, 41, 301);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1292, false, 1, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1293, false, 2, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1294, true, 3, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1295, false, 4, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1296, false, 5, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1297, false, 6, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1298, false, 7, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1299, false, 8, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1300, false, 9, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1301, false, 10, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1302, false, 11, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1303, false, 12, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1304, false, 13, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1305, false, 14, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1306, false, 15, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1307, false, 16, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1308, false, 17, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1309, false, 18, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1310, false, 19, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1311, false, 20, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1312, false, 21, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1313, false, 22, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1314, false, 23, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1315, false, 24, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1316, false, 25, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1317, false, 26, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1318, false, 27, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1319, false, 28, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1320, false, 29, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1321, false, 30, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1322, false, 31, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1323, false, 32, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1324, false, 33, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1325, false, 34, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1326, false, 35, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1327, false, 36, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1328, false, 40, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1329, false, 41, 302);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1330, false, 1, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1331, false, 2, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1332, true, 3, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1333, false, 4, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1334, false, 5, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1335, false, 6, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1336, false, 7, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1337, false, 8, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1338, false, 9, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1339, false, 10, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1340, false, 11, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1341, false, 12, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1342, false, 13, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1343, false, 14, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1344, false, 15, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1345, false, 16, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1346, false, 17, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1347, false, 18, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1348, false, 19, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1349, false, 20, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1350, false, 21, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1351, false, 22, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1352, false, 23, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1353, false, 24, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1354, false, 25, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1355, false, 26, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1356, false, 27, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1357, false, 28, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1358, false, 29, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1359, false, 30, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1360, false, 31, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1361, false, 32, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1362, false, 33, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1363, false, 34, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1364, false, 35, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1365, false, 36, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1366, false, 37, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1367, false, 38, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1368, false, 39, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1369, false, 40, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1370, false, 41, 303);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1371, false, 1, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1372, false, 2, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1373, true, 3, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1374, false, 4, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1375, false, 5, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1376, false, 6, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1377, false, 7, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1378, false, 8, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1379, false, 9, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1380, false, 10, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1381, false, 11, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1382, false, 12, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1383, false, 13, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1384, false, 14, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1385, false, 15, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1386, false, 16, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1387, false, 17, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1388, false, 18, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1389, false, 19, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1390, false, 20, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1391, false, 21, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1392, false, 22, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1393, false, 23, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1394, false, 24, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1395, false, 25, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1396, false, 26, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1397, false, 27, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1398, false, 28, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1399, false, 29, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1400, false, 30, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1401, false, 31, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1402, false, 32, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1403, false, 33, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1404, false, 34, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1405, false, 35, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1406, false, 36, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1407, false, 40, 304);
INSERT INTO public.questionnaire_answer (id, answer, question_id, questionnaire_id) VALUES (1408, false, 41, 304);

--Loyalty program
INSERT INTO public.loyalty_program(id, points_per_donation, category1Name, category1Points, category2Name, category2Points, category3Name, category3Points) VALUES (1, 10, 'Silver', 100, 'Gold', 500, 'Platinum', 1000);
