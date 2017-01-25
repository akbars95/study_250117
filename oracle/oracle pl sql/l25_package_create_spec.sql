create or replace package country_package as
  --add country
  procedure addCountry(i_country_name countries.country_name%type);
  --remove country by name
  procedure removeCountryByName(i_country_name countries.country_name%type);
  --list of countries
  PROCEDURE allCountries;
end country_package;