--cursor without params
create or replace function findCountry(name_in IN VARCHAR2)
return number
is
  cnumber number;
  cursor cursorWithoutParam
  is
    select c.COUNTRY_ID
    from COUNTRIES c
    where c.COUNTRY_NAME = name_in;
begin
  open cursorWithoutParam;
  fetch cursorWithoutParam into cnumber;
  if cursorWithoutParam%notfound then
    cnumber := 999;
  end if;
  close cursorWithoutParam;
return cnumber;
end;

--cursor with params
create or replace function findByIdCountry(id_countryIN IN number)
return COUNTRIES.COUNTRY_NAME%type
is
  cname COUNTRIES.COUNTRY_NAME%type;
  cursor cursorWithParams(id_country number)
  is
    select c.COUNTRY_NAME
    from COUNTRIES c
    where c.COUNTRY_ID = id_country;

begin
  cname := 'JJJJ';
  open cursorWithParams(id_countryIN);
  fetch cursorWithParams into cname;
  if cursorWithParams%notfound then
    cname := 'Not found!';
  end if;
  close cursorWithParams;
  return cname;
end;

declare
  cursor getAll is
    select * from COUNTRIES;
    
  cursor return_all_countries 
  return COUNTRIES%rowtype is
    select * from COUNTRIES;
    
  country_rowtype getAll%rowtype;
  country_row_type COUNTRIES%rowtype;
begin
  dbms_output.put_line(FINDCOUNTRY('Moldova') || '');
  dbms_output.put_line(FINDCOUNTRY('moldova') || '');
  dbms_output.put_line('_____________________________');
  dbms_output.put_line(FINDBYIDCOUNTRY(2) || '');
  dbms_output.put_line(FINDBYIDCOUNTRY(10) || '');
  dbms_output.put_line('_____________________________');
  open getAll;
  loop
    exit when getAll%notfound;
    fetch getAll into country_rowtype;
    dbms_output.put_line(country_rowtype.COUNTRY_ID || 
    ' _ ' || country_rowtype.COUNTRY_NAME);
  end loop;
  close getAll;
  
  dbms_output.put_line('/*/*/*/*/*/*/*/*/*///**/*/*/*/');
  open return_all_countries;
  fetch return_all_countries into country_row_type;
  dbms_output.put_line(country_row_type.COUNTRY_ID || ' ' || country_row_type.COUNTRY_NAME);
  close return_all_countries;
end;