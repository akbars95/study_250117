set serveroutput on;
declare
  
  PROCEDURE defineGrade(current_grade char) is
  begin
    dbms_output.put_line(current_grade);
    case current_grade
      when 'A' then dbms_output.put_line('Excellent');
      when 'B' then dbms_output.put_line('Very good');
      when 'C' then dbms_output.put_line('Well done');
      when 'D' then dbms_output.put_line('Your passed');
      when 'F' then dbms_output.put_line('Better try again');
      else dbms_output.put_line('No such grade!');
    end case;
  end;
  
begin
  defineGrade('a');
  defineGrade('A');
  defineGrade('F');
end;