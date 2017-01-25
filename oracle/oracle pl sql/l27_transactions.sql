set autocommit on;
set autocommit off;

insert into countries(COUNTRY_ID, COUNTRY_NAME) values(101, 'Nikaragua');
commit;
insert into countries(COUNTRY_ID, COUNTRY_NAME) values(102, 'Cad');
insert into countries(COUNTRY_ID, COUNTRY_NAME) values(103, 'Condivuar');
select * from COUNTRIES;

insert into countries(COUNTRY_NAME) values('Ispaniya');
insert into countries(COUNTRY_NAME) values('Germaniya');
savepoint sav1;

update countries set COUNTRY_NAME = 'Moldova' where COUNTRY_ID = 1;
rollback to sav1;
update countries set COUNTRY_NAME = 'UKRAINA' where COUNTRY_ID = 2;