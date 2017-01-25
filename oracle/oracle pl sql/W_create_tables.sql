drop TABLE cities;
drop TABLE countries;
drop table users;

--create tables
create table countries(
  country_id NUMBER(3) DEFAULT CITY_SEQ.nextval not null,
  country_name VARCHAR2(50) not null, 
  CONSTRAINT country_id_PK PRIMARY KEY(country_id)
);

create table cities (
  city_id number(3) not null,
  city_name VARCHAR2(50) not null,
  country_id number(3) not null,
  CONSTRAINT city_id_PK PRIMARY KEY (city_id),
  CONSTRAINT country_id_FK FOREIGN KEY (country_id) REFERENCES countries(country_id)
);

create table users(
  user_id number(10) not null,
  user_salary number not null
);