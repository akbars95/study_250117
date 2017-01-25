select *
from SYS.USER_CONSTRAINTS
WHERE TABLE_NAME = 'CITIES' AND CONSTRAINT_TYPE = 'P';

INSERT INTO COUNTRIES (COUNTRY_NAME) VALUES('MOLDOVA');
INSERT INTO COUNTRIES (COUNTRY_NAME) VALUES('RUSSIA');
INSERT INTO COUNTRIES (COUNTRY_NAME) VALUES('UCRAINE');
COMMIT;

SELECT *
FROM COUNTRIES
ORDER BY SYS.DBMS_RANDOM.RANDOM;

SELECT SYS.DBMS_RANDOM.RANDOM FROM DUAL;

SELECT SEGMENT_NAME, SEGMENT_TYPE, --BYTES
SUM(BYTES) AS BYTES,
SUM(BYTES) / 1024 AS KB,
SUM(BYTES) / 1024 / 1024 AS MB
FROM SYS.USER_SEGMENTS
GROUP BY SEGMENT_NAME, SEGMENT_TYPE
ORDER BY MB DESC;

select REGEXP_SUBSTR('a=value_1;b=value_2;c=value_3;', 'b=[^;]*')
from dual;

select *
from all_users;

select *
from dba_users;

--priveleges
select *
from user_sys_privs;

select *
from user_tab_privs;

select *
from user_role_privs;