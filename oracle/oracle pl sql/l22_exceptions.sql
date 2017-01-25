declare
  c_id CUSTOMERS.ID%type := 1;
  c_name CUSTOMERS.NAME%type;
  c_addr CUSTOMERS.ADDRESS%type;
  
  your_id int := 0;
  
  --user defained exception
  ex_invalid_id exception;
  
begin
  select name, address into c_name, c_addr
  from CUSTOMERS
  where ID = c_id;
  
  SYS.DBMS_OUTPUT.PUT_LINE('Name is ' || c_name);
  SYS.DBMS_OUTPUT.PUT_LINE('Address is ' || c_addr);
  
  if your_id <= 0 then
    raise ex_invalid_id;
  end if;
  
EXCEPTION
  when ex_invalid_id then
    SYS.DBMS_OUTPUT.PUT_LINE('User defined error!');
  when no_data_found then
    SYS.DBMS_OUTPUT.PUT_LINE('No such customers!');
  when others then
    SYS.DBMS_OUTPUT.PUT_LINE('ERROR!');
end;