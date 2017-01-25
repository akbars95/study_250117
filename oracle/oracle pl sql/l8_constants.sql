set serveroutput on;

declare
  --constant declaration
  PI CONSTANT number := 3.141592654;
  --other declarations
  radius number(5, 2);
  dia number(5, 2);
  circumference number(7, 2);
  area number (10, 2);
  message VARCHAR2(30) := 'That''s great!';
begin

  --processing
  radius := 9.5;
  dia := radius * 2;
  circumference := 2.0 * PI * radius;
  area := PI * radius * radius;
  
  --output
  dbms_output.put_line('Radius = ' || radius);
  dbms_output.put_line('Diameter = ' || dia);
  dbms_output.put_line('Circumference = ' || circumference);
  dbms_output.put_line('Area = ' || area);
  dbms_output.put_line(message);

end;