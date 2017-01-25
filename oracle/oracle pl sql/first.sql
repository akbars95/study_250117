set serveroutput on;--for enable in sql developer output console

declare
  message VARCHAR2(20) := 'Hello, world!';
begin
  /*
  output message variable value
  */
  DBMS_OUTPUT.PUT_line(message);
end;