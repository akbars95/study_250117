create or replace procedure greetings
as
begin
  SYS.DBMS_OUTPUT.PUT_LINE('Hello!');
end;