--CREATE TYPE
CREATE OR REPLACE TYPE AQ_TYPE_BOOK AS OBJECT(
  BOOK_NAME VARCHAR2(100),
  SUBJECT VARCHAR2(250),
  YEAR_PUBLISH NUMBER(4)
);

--SETUP
BEGIN
  --CREATE QUEUE TABLE
  /*EXECUTE*/ DBMS_AQADM.CREATE_QUEUE_TABLE(
    QUEUE_TABLE => 'T_AQ_BOOKS',
    QUEUE_PAYLOAD_TYPE => 'AQ_TYPE_BOOK'
  );
  
  --CREATE QUEUE
  /*EXEC*/ DBMS_AQADM.CREATE_QUEUE(
    QUEUE_NAME => 'MSG_BOOK',
    QUEUE_TABLE => 'T_AQ_BOOKS'
  );
  
  /*EXECUTE*/ DBMS_AQADM.START_QUEUE(
    QUEUE_NAME => 'MSG_BOOK'
  );
END;

--CLEANUP
BEGIN
  DBMS_AQADM.STOP_QUEUE(
    QUEUE_NAME => 'MSG_BOOK'
  );
  
  DBMS_AQADM.DROP_QUEUE(
    QUEUE_NAME => 'MSG_BOOK'
  );
  
  DBMS_AQADM.DROP_QUEUE_TABLE(
    QUEUE_TABLE => 'T_AQ_BOOKS'
  );
  
  EXECUTE IMMEDIATE 'DROP TYPE AQ_TYPE_BOOK';
  
END;

SELECT *
FROM USER_QUEUE_TABLES;

SELECT *
FROM USER_QUEUES;