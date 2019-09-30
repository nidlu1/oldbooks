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
	
--good_db
drop table good_db;
CREATE TABLE good_db
(
  good_no number(10) CONSTRAINT good_pk primary key,
  idcheck char(1),
  users_id varchar2(50) CONSTRAINT goods_fk_users REFERENCES users_db(id) ON DELETE CASCADE,
  board_no number(10) CONSTRAINT goods_fk_board REFERENCES board_db(no) ON DELETE CASCADE
); 
alter table GOOD_DB
add comentno number(10) CONSTRAINT good_fk_coment REFERENCES comment_db(comentno) ON DELETE CASCADE;


drop SEQUENCE seq_good_no;
create SEQUENCE seq_good_no
start with 1;

insert into GOOD_DB (good_no, idcheck, users_id, board_no)
values(seq_board_no.nextval, 0, 'z', 7);

select good_no, idCheck, users_id, board_no, good as goods
from good_db gg join board_db bb
on gg.BOARD_NO = bb.NO
and users_id = 'dd' and board_no = 5;

--coment_db
drop table comment_db;
CREATE TABLE comment_db
(
  comentno number (10) CONSTRAINT coment_pk primary key,
  users_id varchar2(50) CONSTRAINT coment_fk_board REFERENCES users_db(id) ON DELETE CASCADE,
  board_no number(10) CONSTRAINT coment_fk_user REFERENCES board_db(no) ON DELETE CASCADE,
  group_no number(3) ,
  group_order number(3) ,
  depth number(3) ,
  content varchar2(500) ,
  good number(3)
); 
alter table comment_db
add writeday date;


drop SEQUENCE seq_coment_no;
create SEQUENCE seq_coment_no
start with 1;

insert into comment_db (comentno, users_id, board_no, group_no, group_order, depth, content, good, writeday)
values(seq_coment_no.nextval, 'x', 21, seq_coment_no.nextval, 0, 0, '댓글임6', 2, sysdate);

select comentno,board_no, username, group_no, group_order, depth, content, good, writeday 
from comment_db aa join USERS_DB bb
on (aa.USERS_ID = bb.ID)
where board_no = 21;


--product db, pco db

drop table product_board_db CASCADE CONSTRAINTS;
CREATE TABLE product_board_db
(
  pboard_no number(10) CONSTRAINT product_board_db_pk primary key,
  resistdate date ,
  title varchar2(100) ,
  pcontents varchar2(1000) ,
  pview number(10),
  id VARCHAR2(50) CONSTRAINT product_board_db_users_db_fk REFERENCES users_DB(id) ON DELETE CASCADE
);
drop SEQUENCE seq_pboard_no;
create SEQUENCE seq_pboard_no
start with 1;


drop table product_db;
CREATE TABLE product_db
(
  productno number(10) CONSTRAINT product_db_pk primary key,
  resist date ,
  issell char(1) ,
  price number(10),
  pboard_no number(10) CONSTRAINT product_db_product_board_db_fk references product_board_db(pboard_no) ON DELETE CASCADE,
  productType varchar2(50),
  product_Location varchar2(50),
  productImage varchar2(200)
); 
drop SEQUENCE seq_pno;
create SEQUENCE seq_pno
start with 1;

drop table pcoment_db;
CREATE TABLE pcoment_db
(
  pcno number(10) CONSTRAINT pcoment_db_pk primary key,
  resistdate date ,
  pcoment varchar2(500) ,
  id VARCHAR2(50) CONSTRAINT product_board_db_pcoment_db_fk REFERENCES users_DB(id) ON DELETE CASCADE,
  pboard_no number(10) CONSTRAINT product_db_pcoment_db_fk references product_board_db(pboard_no) ON DELETE CASCADE
); 

drop SEQUENCE seq_pcno;
create SEQUENCE seq_pcno
start with 1;


--image
drop table image_db;
CREATE TABLE image_db
(
  imageNo number(10) CONSTRAINT image_db_pk primary key,
  imageName varchar2(100),
  PBOARD_NO number(10) CONSTRAINT image_db_PRODUCT_BOARD_DB_fk references PRODUCT_BOARD_DB(PBOARD_NO) ON DELETE CASCADE
); 
drop SEQUENCE seq_image;
create SEQUENCE seq_image
start with 1;