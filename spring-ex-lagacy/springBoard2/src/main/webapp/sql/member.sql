-- 테이블 생성
create table member (
  name varchar2(30) not null,
  id varchar2(30) primary key,  --기본키, unique, not null - 무결성 제약 조건
  pwd varchar2(30) not null,
  gender varchar2(3),
  email1 varchar2(20),
  email2 varchar2(20),
  tel1 varchar2(10),
  tel2 varchar2(10),
  tel3 varchar2(10),
  addr varchar2(100),
  logtime date
);
-- 테이블 구조 확인
desc member;
-- 데이블 삭제
drop table member purge;

-- 데이터 추가
insert into member values ('홍길동', 'hong','1234','남','hong','naver.com',
      '010','1234','5678','경기도 수원시', sysdate);
-- 데이터 검색
select * from member;
select * from member where id='num1' and pwd='1234';
select * from member where id='num1';

-- 데이터 수정
update member set tel2='2345' where id = 'hong';

-- 데이터 삭제
delete member where id='hong';

-- 데이터 저장
commit;