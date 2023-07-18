CREATE SEQUENCE SEQ_CRUD_RETROFIT INCREMENT BY 1;

SELECT SEQ_CRUD_RETROFIT.NEXTVAL FROM DUAL;

DROP TABLE CRUD_RETROFIT;
CREATE TABLE CRUD_RETROFIT(
    COL_NO NUMBER PRIMARY KEY NOT NULL,
    COL1 VARCHAR2(1000),
    COL2 VARCHAR2(1000)
);
-- Spring으로 GET 방식으로 CRUD 만들기

insert into crud_retrofit (col_no, col1, col2)
		values (1, 'a', 'b');
        
update crud_retrofit set col1 = 'aa',  col2 = 'bb' where col_no=1;
select * from crud_retrofit;
delete from crud_retrofit where col_no=1;

commit;