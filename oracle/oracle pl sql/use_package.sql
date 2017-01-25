declare
  coutry_id countries.country_id%type := 1;
begin
  /*
  COUNTRY_PACKAGE.ADDCOUNTRY('moldova');
  COUNTRY_PACKAGE.ADDCOUNTRY('ucraine');
  COUNTRY_PACKAGE.ADDCOUNTRY('russia');
  COUNTRY_PACKAGE.ADDCOUNTRY('romania');
  COUNTRY_PACKAGE.ADDCOUNTRY('kazahstan');
  */
  --COUNTRY_PACKAGE.REMOVECOUNTRYBYNAME('kazahstan');
  COUNTRY_PACKAGE.ALLCOUNTRIES;
end;