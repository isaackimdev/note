-- 테이블 생성
create table member2 (
  id varchar2(20) primary key, -- 기본키, unique, not null - 무결성 제약 조건: 아이디
  pwd varchar2(30) not null,  -- 비밀번호
  name varchar2(10) not null, -- 이름
  birth number,               -- 생년월일
  gender varchar2(10),       -- 성별
  email1 varchar2(20),      -- 이메일1
  email2 varchar2(20),      -- 이메일2
  tel1 varchar2(10),    -- 연락처 1
  tel2 varchar2(10),    -- 연락처 2
  tel3 varchar2(10),    -- 연락처 3
  addr varchar2(100),   -- 주소
  logtime date        -- 가입일
);
-- table 삭제
drop table member2 purge;
-- db 저장
commit;
-- table 구조 확인
desc member2;
-- select
select * from member2;
-- insert 회원생성
insert into member2 values
('id', 'pwd', 'name', 911215, 'gender','email1', 'email2','tel1', 'tel2', 'tel3','addr', sysdate);
-- ID, PWD 를 통한 대조
-- 데이터 검색
select * from member2;
select * from member2 where id='abc' and pwd='123';
select * from member2 where id='num1';