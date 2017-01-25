select *
from CUSTOMERS;


declare
  total_rows number(2);
  
  --explicit cursor
  c_id customers.id%type;
  c_name customers.name%type;
  c_addr CUSTOMERS.ADDRESS%type;
  --create cursor
  cursor c_customers is
    select id, name, address
    from CUSTOMERS;
begin
  update customers
  set salary = salary + 500;
  if sql%notfound then
    sys.dbms_output.put_line('no customers selected');
  elsif sql%found then
    total_rows := sql%rowcount;
    sys.dbms_output.put_line(total_rows || ' customers selected');
  end if;
  
  --explicit cursor
  SYS.DBMS_OUTPUT.PUT_LINE('explicit cursor');
  SYS.DBMS_OUTPUT.PUT_LINE('');
  open c_customers;
  loop
    FETCH c_customers into c_id, c_name, c_addr;
    exit when c_customers%notfound;
    sys.dbms_output.put_line(c_id || ' ' || c_name || ' ' || c_addr);
  end loop;
  close c_customers;
end;