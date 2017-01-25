declare
  c number(3);
  
  a number;
  b number;
  r number;
  
  num1 number;
  factorial number;
  
  function findMax(x in number, y in number)
  return number
  is
    z number;
  begin
    if x > y then
      z := x;
    else
      z := y;
    end if;
    
    return z;
  end;
  
  --recursive function
  FUNCTION fact(x number)
  return number
  is
    f number;
  begin
    if x = 0 then
      f := 1;
    else
      f:= x * fact(x - 1);
    end if;
    
    return f;
  end;
  
begin
  c := TOTALCUSTOMERS();
  SYS.DBMS_OUTPUT.PUT_LINE('Total no. of customers: ' || c);
  c := c + 1;
  SYS.DBMS_OUTPUT.PUT_LINE('Total no. of customers(more than 1): ' || c);
  
  a := 20;
  b := 30;
  r := findMax(a, b);
  SYS.DBMS_OUTPUT.PUT_LINE('Max(' || a || ', ' || b || '): ' || r);
  
  --fact
  num1 := 5;
  factorial := fact(num1);
  SYS.DBMS_OUTPUT.PUT_LINE('number ' || num1 || '! = ' || factorial);
end;