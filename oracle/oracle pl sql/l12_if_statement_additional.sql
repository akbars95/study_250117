set SERVEROUTPUT ON;
declare
  package_level number(2, 0) := 3;
  cur_in_param number(2, 0) := 1;
begin
  if(cur_in_param > 0 and cur_in_param <= package_level) then
    DBMS_OUTPUT.PUT_LINE(cur_in_param);
  end if;
end;