--Roles
INSERT INTO public.role(id, name) VALUES (0,'USER');
INSERT INTO public.role(id, name) VALUES (1,'ADMINISTRATOR');
INSERT INTO public.role(id, name) VALUES (2,'STAFF');


--Donation centers
INSERT INTO public.donation_center(id, address, city, country, latitude, longitude, description, name)
VALUES (0, 'Dr Sime Miloševića', 'Novi Sad', 'Serbia', 45.24903, 19.84820, 'Donacioni centar', 'Zavod za zdravstvenu zaštitu studenata');

INSERT INTO public.donation_center(id, address, city, country, latitude, longitude, description, name)
VALUES (1, 'Bulevar slobodana Jovanovića 9', 'Novi Sad', 'Serbia', 45.25133, 19.80501, 'Javni zdravstveni centar', 'Dom Zdravlja Novo Naselje - Bistrica');


--Users
INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (10, true, 'marko.mekic@test.com', 'Marko', 'Mekić', 0, '8597742685357', 'Student', 'Fakultet tehničkih nauka Novi Sad',
'$2a$10$JrBQZbE64oPnnPP9fRMe0urRWAm/IIXI.uytaBM72fF6QCkqtddJK', 0, '063241463', 'Braće Nemet 4', 'Novi Sad', 'Serbia', 45.23954, 19.80781, 1);

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
INSERT INTO public.user_roles(user_id, role_id) VALUES (10, 2);
INSERT INTO public.user_roles(user_id, role_id) VALUES (11, 0);
INSERT INTO public.user_roles(user_id, role_id) VALUES (12, 0);
INSERT INTO public.user_roles(user_id, role_id) VALUES (13, 0);


--Admin
INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (100, true, 'sasa.lukic@test.com', 'Saša', 'Lukić', null, null, null, null,
'$2a$10$H9NzV9vgV.DpCJFCiQfla.cu/DoY4KE0tOgJ9h3B7cFvEztpm2m8a', 0, null, null, null, null, 0, 0, null);


--Admin role
INSERT INTO public.user_roles(user_id, role_id) VALUES (100, 1);


--Terms
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (0, '2023/06/18 8:30', 25, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (1, '2023/06/18 9:30', 30, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (2, '2023/06/18 19:00', 20, 0, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (3, '2023/06/18 9:30', 30, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (4, '2023/06/18 9:30', 30, 1, false);
INSERT INTO public.term(id, date, duration, center_id, deleted) VALUES (5, '2023/06/18 19:00', 20, 1, false);


--Blood
INSERT INTO public.blood_table(	id, quantity, type)	VALUES (1, 50, 0);
INSERT INTO public.blood_table(	id, quantity, type)	VALUES (2, 60, 1);
INSERT INTO public.blood_table(	id, quantity, type)	VALUES (3, 70, 2);
INSERT INTO public.blood_table(	id, quantity, type)	VALUES (4, 80, 3);


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