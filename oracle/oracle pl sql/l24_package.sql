--create package specification(interface)
create PACKAGE custom_package as
  PROCEDURE find_sal(c_id users.user_id%type);
end custom_package;


--create package body
create or replace package body custom_package as
  PROCEDURE find_sal(c_id users.user_id%type) is
    c_sal users.user_salary%type;
    begin
      select user_salary into c_sal
      from USERS
      where USER_ID = c_id;
      DBMS_OUTPUT.put_line(c_sal);
  end find_sal;
end custom_package;