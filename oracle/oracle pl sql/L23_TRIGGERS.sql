set serveroutput on;
delete from users;
insert into users (USER_ID, USER_SALARY) VALUES(1, 150);
insert into users (USER_ID, USER_SALARY) VALUES(2, 250);

update users set USER_SALARY = USER_SALARY * 1.5;

select *
from users;

insert into users (USER_ID, USER_SALARY) VALUES(3, 500);
update users set USER_SALARY = USER_SALARY * 1.25 where USER_ID = 3;
DELETE FROM USERS WHERE USER_ID = 3;