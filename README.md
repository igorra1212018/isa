# Uputstva za instalaciju i pokretanje projekta

Ovaj README.md fajl sadrži detaljna uputstva za instalaciju i pokretanje projekta.

## Koraci

1. Instalacija Node.js verzije 18.15.0
2. Instalacija Angular CLI verzije 15.2.4 pomoću sledeće komande: `npm install -g @angular/cli@15.2.4`
3. Instalacija RabbitMQ (zahteva prethodno instaliran Erlang)
4. Instalacija Python verzije 3.9 (preporučuje se kreiranje Anaconda okruženja)
5. Instalacija PostgreSQL pgAdmina
6. Kreiranje Login/Group Role u pgAdminu:
   - Naziv: "admin"
   - Lozinka: "ftn"
   - Dodeliti sve privilegije u tabu "Privileges"
7. Kreiranje baze "donor_db" u pgAdminu sa vlasnikom "postgres"
8. Instalacija najnovije verzije Eclipse IDE ili instalacija JDK verzije 20 i konfiguracija u Eclipse-u
9. Instalacija Python paketa u Anaconda okruženju pomoću sledećih komandi:
   - `conda install -c conda-forge osmnx`
   - `conda install pika`
   - `conda install flask`
10. Navigacija do direktorijuma "isa/donorapp-frontend" i izvršavanje komande:
    ```
    npm install
    ```
11. Pokretanje RabbitMQ servera
12. Izvršavanje komande u RabbitMQ komandnoj liniji: `rabbitmq-plugins enable rabbitmq_management`
13. Konfiguracija okruženja u PyCharm-u i pokretanje "main.py"
14. Pokretanje "DonorApplication.java" kao Java aplikacije u Eclipse-u
15. Popunjavanje baze podataka izvršavanjem komandi iz "data.sql" fajla
16. Pokretanje frontend-a pomoću komande:
    ```
    npm start
    ```
17. Projekat će biti pokrenut na adresi "localhost:4200"
18. Šifre svih korisnika su u formatu `<ime>123`. Na primer, ako je ime "Saša Nikolić", šifra će biti "sasa123".
19. Napomena: Prilikom korišćenja funkcionalnosti praćenja dostave, nakon slanja početnih i krajnjih koordinata, potrebno je sačekati oko 10 sekundi da backend isprocesira putanju pre nego što počne simulacija vožnje.
