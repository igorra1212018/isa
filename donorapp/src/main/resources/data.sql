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


--Users
INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (10, true, 'marko.mekic@test.com', 'Marko', 'Mekić', 0, '8597742685357', 'Student', 'Fakultet tehničkih nauka Novi Sad',
'$2a$10$JrBQZbE64oPnnPP9fRMe0urRWAm/IIXI.uytaBM72fF6QCkqtddJK', 0, '063241463', 'Braće Nemet 4', 'Novi Sad', 'Serbia', 45.23954, 19.80781, null);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (11, true, 'tijana.nikolic@test.com', 'Tijana', 'Nikolić', 1, '4577397855271', 'Profesor Matematike', 'Gimnazija Jovan Jovanović Zmaj, Novi Sad',
'$2a$10$f/eIJ2mawbx75.SRBceU/.zafZvdcKy6RR6z1uEZQ7TULMUX0l8E.', 0, '062676349', 'Paje Marganovića 2', 'Novi Sad', 'Serbia', 45.25232, 19.82115, null);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (12, true, 'darko.popovic@test.com', 'Darko', 'Popović', 0, '6488052659043', 'Kasir', 'Idea, Novi Sad',
'$2a$10$wQN2LVZipqY5KJ5ZK3hdzOYk2y4QD7V2cKGADh1eG68ZOQ4tQK5gq', 0, '063887221', 'Alekse Šantića 25', 'Novi Sad', 'Serbia', 45.24365, 19.83517, null);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (13, true, 'milica.matic@test.com', 'Milica', 'Matić', 1, '4785296075844', 'Advokat', 'Advokatska služba Aleksić, Novi Sad',
'$2a$10$IelnpU0.wI5qmUzdmVnoB.4jA3CSj716cZsZ2lLVewwI9BpAqI0G.', 0, '063622143', 'Radnička 14', 'Novi Sad', 'Serbia', 45.24903, 19.84820, null);


--User roles
INSERT INTO public.user_roles(user_id, role_id) VALUES (10, 0);
INSERT INTO public.user_roles(user_id, role_id) VALUES (11, 0);
INSERT INTO public.user_roles(user_id, role_id) VALUES (12, 0);
INSERT INTO public.user_roles(user_id, role_id) VALUES (13, 0);


--Staff
INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (20, true, 'dunja.bozic@test.com', 'Dunja', 'Božić', null, null, null, null,
'$2a$10$7kZVwuCsu7lk8OsZAZ2KdOea59iQkiyEEb3yi2mUndnZeGa5eNqS2', 0, null, null, null, null, 0, 0, 0);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (21, true, 'nikola.curcic@test.com', 'Nikola', 'Ćurčić', null, null, null, null,
'$2a$10$95OZCS0XJJTCPXGLqRWp2uaDrsUMLvmWVUu3HPZMlEA6YkvnxcsYK', 0, null, null, null, null, 0, 0, 1);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (22, true, 'marko.markovic@test.com', 'Marko', 'Marković', null, null, null, null,
'$2a$10$so1BJu0h1cuxVkA9CXI6Cen8v.soHtup8LBWplm3z94PPOLMD40VG', 0, null, null, null, null, 0, 0, 0);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (23, true, 'milica.petrovic@test.com', 'Milica', 'Petrović', null, null, null, null,
'$2a$10$p5u1dyM3dbs/87iD7Okmx.w9jLzVoJn/K9FVu2whELo6y28n9pRCG', 0, null, null, null, null, 0, 0, 1);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (24, true, 'ivan.jovanovic@test.com', 'Ivan', 'Jovanović', null, null, null, null,
'$2a$10$Sf00lIeb7jiHmeupVikz6uMSuwsH4I1KcY.qKc2ABA3Z6gdHqv8sO', 0, null, null, null, null, 0, 0, 2);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (25, true, 'ana.pavlovic@test.com', 'Ana', 'Pavlović', null, null, null, null,
'$2a$10$lVsnZYd00kF9XPr9ieBSL.9Or33usGlsKKAW7Nv3fAfHOlr18bGJi', 0, null, null, null, null, 0, 0, 3);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (26, true, 'luka.jankovic@test.com', 'Luka', 'Janković', null, null, null, null,
'$2a$10$FHKLzz1cBFrE2uuZXzn1kehE22eoPf0pl9zdwaWWs6Z7jSyj0R8Lq', 0, null, null, null, null, 0, 0, 2);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (27, true, 'jovana.milic@test.com', 'Jovana', 'Milić', null, null, null, null,
'$2a$10$lQyjSwTDLriYexW4DbKSlubyq/iwNWmBOgII9UnVWd5uM/lPCvuNy', 0, null, null, null, null, 0, 0, 1);

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (28, true, 'stefan.petrovic@test.com', 'Stefan', 'Petrović', null, null, null, null,
'$2a$10$BimxadcsVc3Uk9sEUg85Iuw6yV2Q2nzQDMuiPKM36WYb8fCnnfmMO', 0, null, null, null, null, 0, 0, 3);


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
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (50, true, 'sasa.lukic@test.com', 'Saša', 'Lukić', null, null, null, null,
'$2a$10$H9NzV9vgV.DpCJFCiQfla.cu/DoY4KE0tOgJ9h3B7cFvEztpm2m8a', 0, null, null, null, null, 0, 0, null);


--Admin role
INSERT INTO public.user_roles(user_id, role_id) VALUES (50, 1);


--Terms
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (0,  '2023/06/18 8:30', 25, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (1,  '2023/06/18 9:30', 30, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (2,  '2023/06/18 19:00', 20, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (3,  '2023/06/18 9:30', 30, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (4,  '2023/06/18 9:30', 30, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (5,  '2023/06/18 19:00', 20, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (6,  '2023/01/10 12:30', 25, 2, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (7,  '2023/01/12 16:00', 20, 3, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (8,  '2023/02/05 14:30', 30, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (9,  '2023/02/08 09:30', 20, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (10, '2023/02/10 15:00', 25, 2, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (11, '2023/02/15 18:30', 30, 3, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (12, '2023/03/02 10:00', 20, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (13, '2023/03/05 13:30', 25, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (14, '2023/03/10 17:00', 30, 2, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (15, '2023/03/12 11:30', 20, 3, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (16, '2023/03/15 08:00', 25, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (17, '2023/04/01 16:30', 20, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (18, '2023/04/03 13:00', 30, 2, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (19, '2023/04/08 09:30', 25, 3, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (20, '2023/04/12 12:00', 20, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (21, '2023/04/18 14:30', 30, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (22, '2023/05/02 11:00', 25, 2, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (23, '2023/05/05 15:30', 20, 3, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (24, '2023/05/08 10:00', 30, 0, false);


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


--Loyalty program

INSERT INTO public.loyalty_program(id, points_per_donation, category1Name, category1Points, category2Name, category2Points, category3Name, category3Points) VALUES (1, 10, 'Silver', 100, 'Gold', 500, 'Platinum', 1000);