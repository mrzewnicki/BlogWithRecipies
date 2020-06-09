create database db_cookingbook;
create user 'cookingbook'@'%' identified by 'password';
grant all on db_cookingbook.* to 'cookingbook'@'%';
use db_cookingbook;

insert into user values('1', '$2a$10$XHBoQ35bapBQ/ONaP3bzWOA.VudsH0anWN1hvcJ06NXFYYhAI6xsG',  'administrator');
insert into user values('2', '$2a$10$VgMfhglD5nTCMeIccQWYcOtgqJEh5colz6S8UCwJrmBu14Qq8lNEq',  'user');
insert into role values(1, "admin");
insert into user_roles values(1,1);

insert into przepis values(1, "2h", "Pierogi ruskie", "Ciasto rozwalkowac i dodac farsz. Gotowac do wyplyniecia", "latwy", "pierogi", null, 1);
insert into przepis values(2, "15min", "Jajecznica", "Jajka wbic na patelnie doprawic sola i pieprzem. Smacznego", "latwy", "jajka", null, 2);
insert into przepis values(3, "2h", "Tort urodzinowy", "Skladniki wymieszac i piec przez godzine do wyrosniecia", "trudny", "ciasta", null, 1);
