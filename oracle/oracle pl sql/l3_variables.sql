set serveroutput on;
declare

sales number(10, 2);
pi CONSTANT double precision := 3.1415;
name VARCHAR2(25);
address VARCHAR2(100);

counter binary_integer := 0;
greetings VARCHAR2(20) default 'Have a Good day';

a integer := 10;
b integer := 20;
c integer;
f real;
  
begin
c := a + b;
dbms_output.put_line('Value of c = ' || c);
f := 70.0 / 3.0;
dbms_output.put_line('Value of f = ' || f);

end;