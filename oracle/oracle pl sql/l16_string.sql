set serveroutput on;
declare
  name varchar2(20);
  company varchar2(30);
  introduction clob;
  choice char(1);
  
  ref_flaf char(1) := 'Y';
  ref_flag2 char := ref_flaf;
  
  greeting varchar2(15) := 'hello world';
begin
  name := 'John Smith';
  company := 'IntelSoft';
  introduction := 'Hello! I''m Smith from Infotech.';
  choice := 'y';
  if choice = 'y' then
    sys.dbms_output.put_line(name);
    sys.dbms_output.put_line(company);
    sys.dbms_output.put_line(introduction);
  end if;
  
  --string methods
  sys.dbms_output.put_line(UPPER(greeting));
  sys.dbms_output.put_line(LOWER(greeting));  
  sys.dbms_output.put_line(ASCII('a'));
  sys.dbms_output.put_line(CHR(99));
  sys.dbms_output.put_line(CONCAT(greeting, ', Ion!'));
  sys.dbms_output.put_line(INITCAP(greeting));
  sys.dbms_output.put_line(INSTR(greeting, 'wo'));
  sys.dbms_output.put_line(INSTR(greeting, 'Wo'));
  --sys.dbms_output.put_line(INSTRB(97));
  sys.dbms_output.put_line(LENGTH(greeting));
  sys.dbms_output.put_line(LENGTHB(greeting));
  sys.dbms_output.put_line('LPAD' || LPAD(greeting, 5));
  sys.dbms_output.put_line(LTRIM('   IONEL'));
--  sys.dbms_output.put_line(NANVL('IONEL', 'Not a number'));
--  sys.dbms_output.put_line(NANVL(15, 'Not a number'));
  sys.dbms_output.put_line(NVL('IONEL', 'Not null'));
  sys.dbms_output.put_line(NVL(null, 'IS null'));
--  sys.dbms_output.put_line(NVL2(null, 'val1', 'val2'));
  sys.dbms_output.put_line(REPLACE('London', 'Lond', 'D'));
  sys.dbms_output.put_line(RPAD('London', 4));
  sys.dbms_output.put_line(RTRIM('IONEL   '));
  sys.dbms_output.put_line(RTRIM('IONEL   G'));
  sys.dbms_output.put_line(SUBSTR('Manchester United', 5));
  sys.dbms_output.put_line(SUBSTR('Manchester United', 0, 10));
  sys.dbms_output.put_line(TRIM(' f  IONEL   '));
end;