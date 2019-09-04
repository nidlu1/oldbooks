--관리자
-- 1. DBA권한으로 접속하여 loglog USER를 생성 한다. 
CREATE USER oldbooks IDENTIFIED BY oldbooks
      DEFAULT TABLESPACE users
      TEMPORARY TABLESPACE temp;
  
-- 2. 권한 부여
GRANT connect, resource TO oldbooks;

--oldbooks 계정
--users_DB
DROP TABLE USERS_DB;
CREATE TABLE USERS_DB
(
    id VARCHAR2(50) CONSTRAINT PK_USERS PRIMARY KEY,
    pw VARCHAR2(50) NOT NULL,
    username VARCHAR2(50) NOT NULL,
    email VARCHAR2(50) NOT NULL,
    phone VARCHAR2(50) NOT NULL,
    post VARCHAR2(6),
    addr1 VARCHAR2(50),
    addr2 VARCHAR2(50)
);
--board_DB
drop table board_db;
CREATE TABLE board_db
(
  no number(10) CONSTRAINT board_pk primary key,
  group_no number(3) ,
  group_order number(3) ,
  depth number(3) ,
  type varchar2(30) ,
  title varchar2(50) ,
  content varchar2(1000) ,
  good number(3) ,
  views number(3) ,
  writedate varchar2(50) ,
  id varchar2(50) CONSTRAINT fk_users_db REFERENCES users_db(id) ON DELETE CASCADE
); 
drop SEQUENCE seq_board_no;
create SEQUENCE seq_board_no
start with 1;

drop index pk_board;
create INDEX pk_board ON BOARD_DB (type);

SELECT * from BOARD_DB;
SELECT * from users_db;

insert into BOARD_DB(no, group_no, group_order, depth, type, title, content, good, views, writedate, id)
values (seq_board_no.nextval, seq_board_no.nextval, 0, 1, '감상', '동방감상', '하하이',2,9,sysdate,'z');
commit;


select b.no, b.group_no, b.group_order, b.depth, b.type, b.title, b.content, b.good, b.views, b.writedate, id, u.username
from
BOARD_DB b
NATURAL join
USERS_DB u
order by b.no desc;


	select 	b.no, b.group_no, b.group_order, b.depth, b.type, b.title,
			b.content, b.good, b.views, b.writedate, id, u.username
	from 	BOARD_DB b NATURAL join USERS_DB u
	order by b.no desc;
    
--페이징처리 6이상 10이하의 글
select b2.no, b2.group_no, b2.group_order, b2.depth, b2.type, b2.title, b2.content, b2.good, b2.views, b2.writedate, id, u.username
from(
    select /*+ index_desc(b board_pk)*/ rownum rn, b.no, b.group_no, b.group_order, b.depth, b.type, b.title, b.content, b.good, b.views, b.writedate
    from( select c.no, c.group_no, c.group_order, c.depth, c.type, c.title, c.content, c.good, c.views, c.writedate
            from BOARD_DB c
            order by no desc )b
    where rownum <= 5) b2
    NATURAL join USERS_DB u
where b2.rn >= 1 ;

	select 	b.no, b.group_no, b.group_order, b.depth, b.type, b.title,
			b.content, b.good, b.views, b.writedate, id, u.username
	from 	BOARD_DB b NATURAL join USERS_DB u
	order by b.no desc;
