set serveroutput on;
declare
  --&cc_id - open popup window
  code users.user_id%type := &cc_id;
begin
  custom_package.find_sal(code);
end;