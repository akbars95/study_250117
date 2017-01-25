set serveroutput on;
declare
  x number := 10;
  y number := 100;
begin
  --first loop
  --simple loop exit via if
  loop
    DBMS_OUTPUT.PUT_LINE(x);
    x := x - 10;
    if x < -50 then
      exit;
    end if;
  end loop;
  DBMS_OUTPUT.PUT_LINE('After 1 loop');
  
  --second loop
  --exit via when
  x := 10;
  loop
    DBMS_OUTPUT.PUT_LINE(x);
    x := x + 10;
    exit when x > 50;
  end loop;
  DBMS_OUTPUT.PUT_LINE('After 2 loop');
  
  x := 10;
  --third loop
  --while loop
  while x <= 25 loop
    DBMS_OUTPUT.PUT_LINE('value is ' || x);
    x := x + 5;
  end loop;
  
  x := 10;
  --for loop
  for x in 10 .. 20 loop
    DBMS_OUTPUT.PUT_LINE('val = ' || x);
  end loop;  
  
  x := 10;
  --for reverse loop
  for x in reverse 15 .. 20 loop
    DBMS_OUTPUT.PUT_LINE('val1 = ' || x);
  end loop;
  
  x := 5;
  --nested loops
  for x in 5 .. 10 loop
    DBMS_OUTPUT.PUT_LINE('NES_OUT = ' || x);
    while y < 200 loop
      DBMS_OUTPUT.PUT_LINE('   NES_IN = ' || y);
      y := y + 25;
    end loop;
    y := 100;
  end loop;
  
  DBMS_OUTPUT.PUT_LINE('-----labeled loops-----');
  --labeled loops
  x := 1;
  y := 1;
  << out_loop >>
  for x in 1 .. 3 loop
    << in_loop >>
    for y in 1 .. 2 loop
      DBMS_OUTPUT.PUT_LINE('x = ' || x || ', y = ' || y);
    end loop in_loop;
  end loop out_loop;  
  
  --exit statement
  x := 10;
  while x < 15 loop
    DBMS_OUTPUT.PUT_LINE('val x = ' || x);
    x := x + 1;
    if x > 15 then
      exit;
    end if;
  end loop;
  
  --exit when
  x := 2;
  while x < 5 loop
    SYS.DBMS_OUTPUT.PUT_LINE('x - ' || x);
    x := x + 1;
    exit when x > 3;
  end loop;
  
  --continue
  while x < 10 loop
    x := x + 1;
    if x = 7 then
      continue;
    end if;
    SYS.DBMS_OUTPUT.PUT_LINE('x = _ ' || x);
  end loop;  
  
end;