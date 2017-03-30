select sysdate from dual;

select trunc(sysdate, 'yyyy') from dual;
select trunc(sysdate, 'yyy') from dual;
select trunc(sysdate, 'SYYYY') from dual;

select trunc(sysdate, 'Q') from dual;

select trunc(sysdate, 'MM') from dual;

select trunc(sysdate, 'DD') from dual;

select trunc(sysdate, 'HH') from dual;

SELECT TO_CHAR(SYSDATE, 'DD.MM.YYYY') FROM DUAL;