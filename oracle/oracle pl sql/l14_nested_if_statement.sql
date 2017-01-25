set serveroutput on;
declare
  a number(3) := 100;
  b number(3) := 400;
begin
  if(a = 100) then
    if(b = 200) then
      SYS.DBMS_OUTPUT.PUT_LINE('a = 100 and b = 200');
    elsif(b = 300) then
      SYS.DBMS_OUTPUT.PUT_LINE('a = 100 and b = 300');
    else
      SYS.DBMS_OUTPUT.PUT_LINE('a = 100 and b > 200');
    end if;
  end if;  
end;