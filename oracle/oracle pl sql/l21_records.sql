declare
  customer_rec customers%rowtype;
  
  cursor cur_customer is
    select id, name, age
    from CUSTOMERS;
  customer_rec_cur_b cur_customer%rowtype;
  
  type books is record(
    title varchar(50),
    author varchar(50),
    subject varchar(100),
    book_id number
  );
  
  book1 books;
  book2 books;
  
  PROCEDURE printBook(book books) is
  begin
    SYS.DBMS_OUTPUT.PUT_LINE('book:');
    SYS.DBMS_OUTPUT.PUT_LINE('      title - ' || book.title);
    SYS.DBMS_OUTPUT.PUT_LINE('      author - ' || book.author);
    SYS.DBMS_OUTPUT.PUT_LINE('      subject - ' || book.subject);
    SYS.DBMS_OUTPUT.PUT_LINE('      book_id - ' || book.book_id);
    SYS.DBMS_OUTPUT.PUT_LINE('-----');
  end;
  
begin
  --table base record
  select * into customer_rec
  from CUSTOMERS
  where ID = 1;
  
  SYS.DBMS_OUTPUT.PUT_LINE('Customer:');
  SYS.DBMS_OUTPUT.PUT_LINE('          id=' || customer_rec.id);
  SYS.DBMS_OUTPUT.PUT_LINE('          name=' || customer_rec.name);
  SYS.DBMS_OUTPUT.PUT_LINE('          age=' || customer_rec.age);
  SYS.DBMS_OUTPUT.PUT_LINE('          address=' || customer_rec.address);
  SYS.DBMS_OUTPUT.PUT_LINE('          salary=' || customer_rec.salary);
  
  --cursor base record
  open cur_customer;
  LOOP
    FETCH cur_customer into customer_rec_cur_b;
    exit when cur_customer%notfound;
    SYS.DBMS_OUTPUT.PUT_LINE(customer_rec_cur_b.id || ' ' || customer_rec_cur_b.name || ' ' || customer_rec_cur_b.age);
  end loop;  
  close cur_customer;
  
  --user base record
  book1.title := 'Java 8';
  book1.author := 'Oracle press';
  book1.subject := 'Introduction new features java 8';
  book1.book_id := 39234;
  
  book2.title := 'PL/SQL';
  book2.author := 'Oracle press';
  book2.subject := 'Introduction PL/SQL';
  book2.book_id := 39296;
  
  printBook(book1);
  printBook(book2);
  
--  SYS.DBMS_OUTPUT.PUT_LINE('book1:');
--  SYS.DBMS_OUTPUT.PUT_LINE('      title - ' || book1.title);
--  SYS.DBMS_OUTPUT.PUT_LINE('      author - ' || book1.author);
--  SYS.DBMS_OUTPUT.PUT_LINE('      subject - ' || book1.subject);
--  SYS.DBMS_OUTPUT.PUT_LINE('      book_id - ' || book1.book_id);
end;