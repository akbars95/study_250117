--CREATE TYPE
create type msg_type as object(
  msg_id number,
  msg_subject VARCHAR2(50),
  msg_text VARCHAR2(1000)
);

BEGIN
  --DROP TABLE AQ
  SYS.DBMS_AQADM.DROP_QUEUE_TABLE(
    queue_table => 'aq_table'
  );
  
  --CREATE ORACLE AQ TABLE
  DBMS_AQADM.CREATE_QUEUE_TABLE(
    queue_table => 'aq_table',
    queue_payload_type => 'msg_type',
    multiple_consumers => true,
    COMMENT => 'SECOND TABLE ORACLE AQ'
  );
  
  --ALTER AQ TABLE
  SYS.DBMS_AQADM.ALTER_QUEUE_TABLE(
    queue_table => 'aq_table',
    COMMENT => 'SECOND TABLE ORACLE AQ(CHANGE)'
  );
END;

--CREATE QUEUE
begin
  SYS.DBMS_AQADM.CREATE_QUEUE(
    queue_name => 'queue1',
    queue_table => 'aq_table'
  );
  
  SYS.DBMS_AQADM.CREATE_QUEUE(
    queue_name => 'queue2',
    queue_table => 'aq_table'
  );
end;

--ALTER QUEUE
BEGIN
  SYS.DBMS_AQADM.ALTER_QUEUE(
    queue_name => 'queue1',
    COMMENT => 'FIRST QUEUE'
  );
END;

--START QUEUE
BEGIN
  SYS.DBMS_AQADM.START_QUEUE(
    queue_name => 'queue1'
  );
  
  SYS.DBMS_AQADM.START_QUEUE(
    queue_name => 'queue2'
  );
END;

--STOP/DROP QUEUE
BEGIN
  SYS.DBMS_AQADM.STOP_QUEUE(
    queue_name => 'queue1'
  );
  
  SYS.DBMS_AQADM.DROP_QUEUE(
    queue_name => 'queue1'
  );
END;

--ADD SUBSCRIBERS
DECLARE
  subs sys.aq$_agent;
BEGIN
  subs := sys.aq$_agent('SUBSC1', NULL, NULL);
  SYS.DBMS_AQADM.ADD_SUBSCRIBER(
    queue_name => 'queue1',
    subscriber => subs
  );
  
  subs := sys.aq$_agent('SUBSC2', NULL, NULL);
  SYS.DBMS_AQADM.ADD_SUBSCRIBER(
    queue_name => 'queue1',
    subscriber => subs
  );
END;

--DELETE SUBSCRIBER
DECLARE
  subscriber sys.aq$_agent;
BEGIN
  subscriber := sys.aq$_agent('SUBSCRIBER_1', null, null);
  SYS.DBMS_AQADM.REMOVE_SUBSCRIBER(
    queue_name => 'queue1',
    subscriber => subscriber
  );
  
  subscriber := sys.aq$_agent('SUBSCRIBER_2', null, null);
  SYS.DBMS_AQADM.REMOVE_SUBSCRIBER(
    queue_name => 'queue1',
    subscriber => subscriber
  );
  
  subscriber := sys.aq$_agent('SUBSC1', null, null);
  SYS.DBMS_AQADM.REMOVE_SUBSCRIBER(
    queue_name => 'queue1',
    subscriber => subscriber
  );
  
  subscriber := sys.aq$_agent('SUBSC2', null, null);
  SYS.DBMS_AQADM.REMOVE_SUBSCRIBER(
    queue_name => 'queue1',
    subscriber => subscriber
  );

END;


--add to queue messages
DECLARE
  enqueue_options dbms_aq.enqueue_options_t;
  msg_properties dbms_aq.message_properties_t;
  message_handle raw(16);
  message msg_type;
BEGIN
  message := msg_type(1, 'simple subject', 'text content');
  DBMS_AQ.ENQUEUE(
    queue_name => 'queue1',
    enqueue_options => enqueue_options,
    message_properties => msg_properties,
    payload => message,
    msgid => message_handle
  );
END;


select *
from SYS.ALL_QUEUES
where OWNER = 'USER0812U' 
and QUEUE_TYPE = 'NORMAL_QUEUE';

select *
from SYS.USER_QUEUES;

SELECT *
FROM AQ_TABLE;

SELECT *
FROM SYS.USER_QUEUE_SUBSCRIBERS;

--dequeue message
SET serveroutput ON;
DECLARE
  deq_options dbms_aq.dequeue_options_t;
  msg_properties dbms_aq.message_properties_t;
  msg_handle raw(16);
  msg msg_type;
BEGIN
  deq_options.navigation := dbms_aq.first_message;
  deq_options.consumer_name := 'SUBSC1';
  deq_options.wait := DBMS_AQ.no_wait;
  dbms_aq.dequeue(
    queue_name => 'queue1',
    dequeue_options => deq_options,
    message_properties => msg_properties,
    payload => msg,
    msgid => msg_handle
  );
  dbms_output.put_line('msg_id = ' || msg.msg_id);
  dbms_output.put_line('msg_subject = ' || msg.msg_subject);
  dbms_output.put_line('msg_text = ' || msg.msg_text);
END;
