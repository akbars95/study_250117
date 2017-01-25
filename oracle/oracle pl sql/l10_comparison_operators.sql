set serveroutput on;
declare
  
  procedure compare(value varchar2, pattern varchar2) is
  begin
    if value LIKE pattern then
      dbms_output.put_line('true');
    else
      dbms_output.put_line('false');
    end if;
  end;
  
  PROCEDURE isMonth(numberValue int) is
  begin
    if numberValue between 1 and 12 then
      dbms_output.put_line('this is month number, number is ' || numberValue);
    else
      dbms_output.put_line('ERROR! Number is ' || numberValue);
    end if;  
  end;
  
  PROCEDURE first5Letters(valueIn varchar) is
  begin
    if valueIn is null then
      dbms_output.put_line('ERROR! Value is null');
    else
      dbms_output.put_line('Value is NOT null');
      
      if (valueIn in ('a', 'b', 'c', 'd', 'e'))then
        dbms_output.put_line('In this input word is any first 5 letters');
      else
        dbms_output.put_line('ERROR! In input word cannot first any 5 letters');
      end if;
      
    end if;
    dbms_output.put_line('******************');  
  end;
  
begin
  compare('Ivanov', 'iV%');
  compare('Ivanov', 'IV%');
  compare('Ivanov', 'I%');
  compare('Ivanov', 'P%');
  
  dbms_output.put_line('-------------------');
  
  isMonth(0);
  isMonth(1);
  isMonth(12);
  isMonth(20);
  
  dbms_output.put_line('-------------------');
  
  first5Letters('I');
  first5Letters('a');
  first5Letters('A');
  first5Letters('');
  
end;