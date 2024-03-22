-- 전체 테이블 보기
select * from tab;
-- Table name : guestbook
create table guestbook (
  guest_num number,                     -- 글 번호
  guest_writer varchar2(20) not null,   -- 작성자
  guest_email varchar2(30),             -- 이메일
  guest_subject varchar2(20) not null,  -- 글제목
  guest_content varchar2(60) not null,  -- 글내용
	logtime date default sysdate		      -- 작성일 
);

-- CRUD / 글쓰기, 목록보기 등
-- 테이블 삭제
drop table guestbook purge;
-- 시퀀스	객체
create sequence guest_num nocycle nocache;
drop sequence guest_num;  -- 시퀀스 삭제
-- insert
insert into guestbook values
(guest_num.nextval, '홍길동', 'hong@naver.com', '오늘은', '축구하는 날', sysdate);
-- select
select * from guestbook;
select * from guestbook where guest_num=1;
-- delete
delete guestbook where guest_num=1;
-- db 저장
commit;
-- 총갯수 구하기
select count(*) from guestbook;

-- 인덱스 뷰
-- hidden column - rownum
select * from
(select rownum rn, tt.* from 
(select * from guestbook order by guest_num desc) tt)
where rn>=1 and rn<=10;

-- column 크기 변경
column guest_content format a70;