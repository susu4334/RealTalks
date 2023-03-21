
create table member
(
  username varchar2(10) not null,
  userid varchar2(10) primary key,
  passwd varchar2(10) not null,
  ybirth varchar2(10) not null,
  mbirth varchar2(10) not null,
  dbirth varchar2(10) not null,
  gender varchar2(20) not null,
  email varchar2(20) not null,
  phone varchar2(20) not null
);


 create sequence member_seq;  

ALTER TABLE MEMBER ADD(num NUMBER(6));