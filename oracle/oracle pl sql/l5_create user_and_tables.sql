--alter session set "_ORACLE_SCRIPT"=true;--if when installed oracle db i checked pluggeble db

create user c##oraclestudy
IDENTIFIED BY oracle_study159;

create table customers(
  id int not null,
  name VARCHAR(20) not null,
  age int not null,
  address char(25),
  salary decimal(18, 2),
  primary key (id)
);