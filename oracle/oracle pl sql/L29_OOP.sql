DROP TYPE CUSTOMER;
DROP TYPE ADDRESS_TYPE;

CREATE OR REPLACE TYPE ADDRESS_TYPE AS OBJECT(
  HOUSE_NO VARCHAR2(10),
  STREET VARCHAR2(10),
  CITY VARCHAR2(20),
  STATE VARCHAR2(20),
  PINCODE VARCHAR2(10)
);

CREATE OR REPLACE TYPE CUSTOMER AS OBJECT(
  CODE NUMBER(5),
  NAME VARCHAR2(30),
  CONTRACT_NO VARCHAR2(12),
  ADDR ADDRESS_TYPE,
  MEMBER PROCEDURE DISPLAY
);

CREATE OR REPLACE TYPE RECTANGLE_TYPE AS OBJECT(
  LENGTH NUMBER,
  WIDTH NUMBER,
  MEMBER FUNCTION ENLARGE(INC NUMBER) RETURN RECTANGLE_TYPE,
  MEMBER PROCEDURE DISPLAY,
  MAP MEMBER FUNCTION MEASURE RETURN NUMBER
);

CREATE OR REPLACE TYPE BODY RECTANGLE_TYPE AS
  
  MEMBER FUNCTION ENLARGE(INC NUMBER) RETURN RECTANGLE_TYPE IS
  BEGIN
    RETURN RECTANGLE_TYPE(SELF.LENGTH + INC, SELF.WIDTH + INC);
  END ENLARGE;
  
  MEMBER PROCEDURE DISPLAY IS
  BEGIN
    DBMS_OUTPUT.PUT_LINE('LENGTH = ' || LENGTH);
    DBMS_OUTPUT.PUT_LINE('WIDTH = ' || WIDTH);
  END DISPLAY;
  
  MAP MEMBER FUNCTION MEASURE RETURN NUMBER IS
  BEGIN
    RETURN SQRT(LENGTH * LENGTH + WIDTH * WIDTH);
  END MEASURE;
  
END;


--CALL
SET SERVEROUTPUT ON;
DECLARE
  RESIDENCE ADDRESS_TYPE;
  R1 RECTANGLE_TYPE;
  R2 RECTANGLE_TYPE;
  R3 RECTANGLE_TYPE;
  INC_FACTOR NUMBER := 5;
BEGIN
  RESIDENCE := ADDRESS_TYPE('10/3', 'PATRIA', 'KISHINEV', 'MOLDOVA', 'MD-2892');
  DBMS_OUTPUT.PUT_LINE('HOUSE NO - ' || RESIDENCE.HOUSE_NO);
  DBMS_OUTPUT.PUT_LINE('STREET - ' || RESIDENCE.STREET);
  DBMS_OUTPUT.PUT_LINE('CITY - ' || RESIDENCE.CITY);
  DBMS_OUTPUT.PUT_LINE('STATE - ' || RESIDENCE.STATE);
  DBMS_OUTPUT.PUT_LINE('PINCODE - ' || RESIDENCE.PINCODE);
  
  DBMS_OUTPUT.PUT_LINE('*******************');
  
  R1 := RECTANGLE_TYPE(3, 4);
  R2 := RECTANGLE_TYPE(7, 5);
  R3 := R1.ENLARGE(INC_FACTOR);
  
  R3.DISPLAY;
  
  IF(R1 > R2) THEN
    DBMS_OUTPUT.PUT_LINE('R1');
    R1.DISPLAY;
  ELSE
    DBMS_OUTPUT.PUT_LINE('R2');
    R2.DISPLAY;
  END IF;
  
  DBMS_OUTPUT.PUT_LINE('R1 = ' || R1.MEASURE);
  
END;