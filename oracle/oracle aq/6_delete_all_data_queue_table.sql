BEGIN
  --stop queue
  DBMS_AQADM.STOP_QUEUE(
    queue_name => 'EX_QUEUE_Q'
  );
  
  --drop queue
  DBMS_AQADM.DROP_QUEUE(
    queue_name => 'EX_QUEUE_Q'
  );
  
  --drop queue table
  DBMS_AQADM.DROP_QUEUE_TABLE(
    queue_table => 'EX_QUEUE_TABLE'
  );
  
  --drop type
  EXECUTE IMMEDIATE 'drop type EX_QUEUE_TYPE';
END;