create table score1 (
  studNo varchar2(30) primary key,
  name varchar2(30) not null,
  kor number,
  eng number,
  mat number,
  tot number,
  avg number(4, 1),
  logtime date
);
drop table score1 purge;  -- ±ú²ýÈ÷ Áö¿ì¶ó°í purge¸¦ ¾¸
insert into score1 values ('2018001', 'È«±æµ¿', 90, 80, 70, 240, 80.0, sysdate);
insert into score1 values ('2018005', 'È«±æµ¿', 100, 100, 100, 300, 100.0, sysdate);
select * from score1;
delete score1 where studNo = '2018005';
commit;