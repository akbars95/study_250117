
  DBMS_OUTPUT.PUT_LINE('L_VAR = ' || L_VAR);
  DBMS_OUTPUT.PUT_LINE('CONST = ' || C_VAR_CONST);
  --C_VAR_CONST := 17;--expression 'C_VAR_CONST' cannot be used as an assignment target
  DBMS_OUTPUT.PUT_LINE('N_NUMBER = ' || N_NUMBER);
  N_NUMBER := 175.2;
  DBMS_OUTPUT.PUT_LINE('N_NUMBER = ' || N_NUMBER);
  N_NUMBER := 175.2235;
  DBMS_OUTPUT.PUT_LINE('N_NUMBER = ' || N_NUMBER);
  N_NUMBER := 175.255;
  DBMS_OUTPUT.PUT_LINE('N_NUMBER = ' || N_NUMBER);
  ----------------------------------------------
  DBMS_OUTPUT.PUT_LINE('N_NUMBER_NEG = ' || N_NUMBER_NEG);
  N_NUMBER_NEG := 100.2358;
  DBMS_OUTPUT.PUT_LINE('N_NUMBER_NEG = ' || N_NUMBER_NEG);
  N_NUMBER_NEG := 10.2358;
  DBMS_OUTPUT.PUT_LINE('N_NUMBER_NEG = ' || N_NUMBER_NEG);
  N_NUMBER_NEG := 1050.2358;
  DBMS_OUTPUT.PUT_LINE('N_NUMBER_NEG = ' || N_NUMBER_NEG);
END;