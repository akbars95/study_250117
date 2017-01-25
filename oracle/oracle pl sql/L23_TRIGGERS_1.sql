create or replace trigger display_salary_changes
before INSERT OR UPDATE OR DELETE ON users
for EACH ROW
when (NEW.user_id > 0)
declare
  sal_diff number;
begin
  sal_diff := :NEW.user_salary - :OLD.user_salary;
  dbms_output.put_line('OLD sal = ' || :OLD.user_salary);
  dbms_output.put_line('NEW sal = ' || :NEW.user_salary);
  dbms_output.put_line('diff sal = ' || sal_diff);
end;

