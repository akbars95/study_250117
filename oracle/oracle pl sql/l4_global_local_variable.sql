set serveroutput on;
declare
  --global variable
  num1 number := 95;
  num2 number := 85;
  num3 number := 90;
begin
  DBMS_OUTPUT.PUT_LINE('Global num1 ' || num1);
  DBMS_OUTPUT.PUT_LINE('Global num2 ' || num2);
  
  declare
    --local variable
    num1 number := 195;
    num2 number := 185;
  begin
    DBMS_OUTPUT.PUT_LINE('Local num1 ' || num1);
    DBMS_OUTPUT.PUT_LINE('Local num2 ' || num2);
    DBMS_OUTPUT.PUT_LINE('Local num3 ' || num3);
  end;
end;