set serveroutput on;
declare
  num1 integer;
  num2 real;
  num3 double precision;
  
  subtype name is char(20);
  subtype message is VARCHAR2(100);
  salutation name;
  greetings message;
  
begin

salutation := 'Reader ';
greetings := 'Welcome to the world of PL/SQL';
dbms_output.put_line('Hello ' || salutation || greetings);

--null;

end;