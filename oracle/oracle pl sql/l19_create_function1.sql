create or replace FUNCTION totalCustomers
RETURN number is
  total number(3) := 0;
begin
  select count(*) into total
  from CUSTOMERS;
  
  RETURN total;
end;