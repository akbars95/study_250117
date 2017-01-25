set serveroutput on;
declare
  a boolean := true;
  b boolean := false;
begin
  
  if (a and b)then
    dbms_output.put_line('a and b = t');
  else
    dbms_output.put_line('a and b = f');
  end if;
  
  if (a or b)then
    dbms_output.put_line('a or b = t');
  else
    dbms_output.put_line('a or b = f');
  end if;
  
  if (not b)then
    dbms_output.put_line('not b = t');
  else
    dbms_output.put_line('not b = f');
  end if;
  
end;