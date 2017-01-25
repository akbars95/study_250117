set serveroutput on;

declare
  a int := 10;
  b int := 5;
  
  c int := a * 2;
  d int := c + b;
begin

  dbms_output.put_line(a + b);
  dbms_output.put_line(a - b);
  dbms_output.put_line(a / b);
  dbms_output.put_line(a * b);
  --exponentiation
  dbms_output.put_line(a ** b);
  dbms_output.put_line(a ** 2);
  
  
  dbms_output.put_line('relational');
  dbms_output.put_line(c);
  dbms_output.put_line(d);
  
  if(d = 25) then
    dbms_output.put_line('d = 25');
  else
    dbms_output.put_line('d NOT = 25');
  end if;

  if(d = C) then
    dbms_output.put_line('d = C');
  else
    dbms_output.put_line('d NOT = c');
  end if;
  
  --not equals !=, <>, ~=
  if(d ~= 20) then
    dbms_output.put_line('d != 20');
  else
    dbms_output.put_line('d = 20');
  end if;
    
end;