set serveroutput on;
execute greetings;/*if not in block(begin/end)*/

declare
  a NUMBER;
  b NUMBER;
  c NUMBER;
  
  PROCEDURE findMin(x in number, y in number, z out number)is
  begin
    if x < y then
      z := x;
    else
      z := y;
    end if;
  end;
  
  PROCEDURE squareNum(x in out number) is
  begin
    x := x * x;
  end;
  
begin
  --GREETINGS;
  
  a := 25;
  b := 20;
  findMin(a, b, c);
  sys.dbms_output.put_line('Min value (' || a || ', ' || b || ') = ' || c);
  
  a := 3;
  sys.dbms_output.put('a = ' || a);
  squareNum(a);
  sys.dbms_output.put_line(', a square = ' || a);
  
--  findMin(x=>a, b, c);
  
end;