--create queue type
create or replace type EX_QUEUE_TYPE is object(
  text_message VARCHAR2(100)
)

begin
--create table for queue
DBMS_AQADM.CREATE_QUEUE_TABLE(
  queue_table => 'EX_QUEUE_TABLE',
  queue_payload_type => 'EX_QUEUE_TYPE'
);

end;