--my created table
select *
from EX_QUEUE_TABLE;

--oracle auto create view(AQ$*(* - table name)), for exaple AQ$EX_QUEUE_TABLE
select *
from AQ$EX_QUEUE_TABLE;

begin
  --create queue
  DBMS_AQADM.CREATE_QUEUE(
    queue_name => 'EX_QUEUE_Q',
    queue_table => 'EX_QUEUE_TABLE'
  );
end;

begin
--start queue
  DBMS_AQADM.START_QUEUE(
    queue_name => 'EX_QUEUE_Q'
  );
end;

--check
select *
from AQ$EX_QUEUE_TABLE;



