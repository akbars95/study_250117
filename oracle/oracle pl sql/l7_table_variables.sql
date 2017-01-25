set serveroutput on;

declare
  c_id customers.id%TYPE := 1;
  c_name customers.name%TYPE;
  c_addr customers.address%TYPE;
  c_sal CUSTOMERS.SALARY%TYPE;
begin

  select name, address, salary into c_name, c_addr, c_sal
  from CUSTOMERS
  where ID = c_id;
  
  dbms_output.put_line('Customer ' || c_name || ' from ' || c_addr || ' earns ' || c_sal);

end;