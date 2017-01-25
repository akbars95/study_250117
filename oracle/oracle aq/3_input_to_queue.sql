--insert data to the queue(input)
declare
  l_msg_id raw(32767);
  l_enq_opt dbms_aq.enqueue_options_t;
  l_msg_prop dbms_aq.message_properties_t;
begin
  for i in 1..9 loop 
    DBMS_AQ.ENQUEUE(
      queue_name => 'EX_QUEUE_Q',
      enqueue_options => l_enq_opt,
      message_properties => l_msg_prop,
      payload => EX_QUEUE_TYPE('TEST ' || to_char(i) || ' _ ' || SYSTIMESTAMP ()),
      msgid => l_msg_id
    );
  end loop;
  commit;
end;