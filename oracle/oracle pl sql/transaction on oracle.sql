set serveroutput on;
begin
  dbms_output.put_line('begin transaction');
  insert into T_ROLES(ROLE_NAME) values('ROLE_NAME20');
  dbms_output.put_line('1 insert');
  insert into T_ROLES(ROLE_ID, ROLE_NAME) values(5, 'ROLE_NAME21');
  dbms_output.put_line('2 insert');
  insert into T_ROLES(ROLE_NAME) values('ROLE_NAME15');
  dbms_output.put_line('3 insert');
  commit;
  dbms_output.put_line('commit');
  EXCEPTION
  WHEN OTHERS THEN
    dbms_output.put_line('rollback');
    ROLLBACK;
end;