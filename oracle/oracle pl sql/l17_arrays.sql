set serveroutput on;
declare
  type namesArray IS VARRAY(7) of varchar2(10);
  type grades is varray(7) of integer;
  names namesArray;
  marks grades;
  total integer;
  
  cursor c_customers is
  select name from CUSTOMERS;
  type c_list is varray(6) of CUSTOMERS.NAME%type;
  name_list c_list := c_list();
  counter integer := 0;
begin
  names := namesarray('Ivanov', 'Sergeev', 'Vasiliev', 'Egorov', 'Petrov');
  marks := grades(100, 85, 35, 25, 34);
  total := names.count;
  sys.dbms_output.put_line('Total ' || total || ' students');
  
  for i in 1 .. total loop
    sys.dbms_output.put_line(i || '.Student ' || names(i) || ' his mark is ' || marks(i));
  end loop;
  
  sys.dbms_output.put_line('========================');
  
  --row type
  for n in c_customers loop
    counter := counter + 1;
    name_list.extend;
    name_list(counter) := n.name;
    sys.dbms_output.put_line('Customer(' || counter || '):' || name_list(counter));
  end loop;
  
end;