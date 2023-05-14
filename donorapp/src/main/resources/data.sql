INSERT INTO public.role(id, name) VALUES (0,'USER');
INSERT INTO public.role(id, name) VALUES (1,'ADMINISTRATOR');
INSERT INTO public.role(id, name) VALUES (2,'STAFF');

INSERT INTO public.user_table(id, activated, email, first_name, last_name, gender, jmbg, occupation,
occupation_info, password, penalty_count, phone_number, address, city, country, latitude, longitude, center_id)
VALUES (0, true, "maki1@test.com", "Maki", "Mekić", 0, "1231231231231", "Student", "Fakultet tehničkih nauka Novi Sad",
"")