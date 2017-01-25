create or REPLACE PACKAGE BODY country_package as
  --add country
  procedure addCountry(i_country_name countries.country_name%type) is
    begin
      insert into countries(country_name) values(i_country_name);
    end addCountry;
  --remove country by name
  procedure removeCountryByName(i_country_name countries.country_name%type) is
    begin
      delete from countries where COUNTRY_NAME = i_country_name;
    end removeCountryByName;
  --list of countries
  PROCEDURE allCountries is
    begin
      DBMS_OUTPUT.PUT_LINE('allCountries');
    end allCountries;
end country_package;