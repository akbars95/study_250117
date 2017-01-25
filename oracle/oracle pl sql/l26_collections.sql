--index by table
DECLARE
  TYPE salary is table of number index by VARCHAR2(20);
  salary_list salary;
  name VARCHAR2(20);
begin
  salary_list('Ivanov') := 5000;
  salary_list('Sidorov') := 4000;
  salary_list('Mozgov') := 15000;
  salary_list('Petrov') := 35000;
  salary_list('Klimov') := 95000;
  
  name := salary_list.first;
  while name is not null loop
    DBMS_OUTPUT.PUT_LINE('Salary of ' || name || ' is ' || to_char(salary_list(name)));
    name := salary_list.next(name);
  end loop;
  
end;


--nested table
declare
  type names_table is table of varchar2(10);
  type grades is table of integer;
  names names_table;
  marks grades;
  total integer;
BEGIN
  names := names_table('Ion', 'Vasile', 'Dumitru', 'Dan', 'Sorin');
  marks := grades(95, 21, 75, 24, 68, 96);
  total := names.count;
  DBMS_OUTPUT.PUT_LINE('Total = ' || total || ' students');
  for i in 1 .. total loop
    DBMS_OUTPUT.PUT_LINE('Student: ' || names(i) || ', marks: ' || marks(i));
  end loop;
end;