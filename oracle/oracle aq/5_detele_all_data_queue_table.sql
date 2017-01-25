--delete all data from created queue table
declare
  po dbms_aqadm.aq$_purge_options_t;
begin
  po.block := false;
  DBMS_AQADM.PURGE_QUEUE_TABLE(
    queue_table => 'EX_QUEUE_TABLE',
    purge_condition => NULL,
    purge_options => po
  );
end;