set serveroutput on;
--get data from queue(output)
declare
  l_msg_id raw(16);
  l_deq_opt dbms_aq.dequeue_options_t;
  l_msg_prop dbms_aq.message_properties_t;
  l_payload EX_QUEUE_TYPE;
begin
  for i in 1..8 loop 
    dbms_aq.dequeue(
      queue_name => 'EX_QUEUE_Q',
      dequeue_options => l_deq_opt,
      message_properties => l_msg_prop,
      payload => l_payload,
      msgid => l_msg_id
    );
    dbms_output.put_line('GOT MESSAGE - ' || l_payload.text_message);
  end loop;
  commit;
end;

