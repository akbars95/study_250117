set serveroutput on;
declare
  c_id CUSTOMERS.ID%type := 1;
  c_sal CUSTOMERS.SALARY%type;
  c_name CUSTOMERS.NAME%TYPE;
  
  note_current number := 0;
  
  PROCEDURE getNoteWord(noteValue number) is
  begin
    /*if(note < 0 and note > 100) then
      dbms_output.put_line('ERROR! note should be between 0 and 100! current note is ' + note);
    end if;*/
    
    
    if (noteValue <= 0) then
      dbms_output.put_line('ERROR! cannot be less than 0, current is ' + noteValue);
    elsif(noteValue <= 50)then
      dbms_output.put_line('Very BAD!');
    elsif(noteValue <= 70) then
      dbms_output.put_line('BAD!');
    elsif(noteValue <= 80) then
      dbms_output.put_line('SATISFIED!');
    elsif(noteValue <= 90) then
      dbms_output.put_line('very SATISFIED!');
    elsif(noteValue <= 100) then
      dbms_output.put_line('EXCELENT!');
    else
      dbms_output.put_line('ERROR! cannot be more than 100, current is ' + noteValue);
    end if;
    dbms_output.put_line('-----/////-----(' || noteValue || ')');
  end;
  
begin
--  select c.salary into c_sal
--  from CUSTOMERS c
--  where c.ID = c_id;
--  
--  select c.name into c_name
--  from CUSTOMERS c
--  where c.ID = c_id;
--  
--  if(c_sal <= 9000) then
--    update CUSTOMERS
--    set salary = salary + 1000
--    where id = c_id;
--    dbms_output.put_line(c_name || ' raised salary to 1000 lei');
--  ELSE
--    dbms_output.put_line(c_name || ' do not raise salary');
--  end if;
--  
--  dbms_output.put_line('_____________________________');
  getNoteWord(-1);
  getNoteWord(0);
  getNoteWord(30);
  getNoteWord(55);
  getNoteWord(70);
  getNoteWord(170);
end;