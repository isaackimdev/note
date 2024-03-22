create table board2 (
	board_num number,						-- 글번호
	board_name varchar2(20) not null,		-- 글작성자
	board_pass varchar2(15) not null,		-- 글비밀번호
	board_subject varchar2(50) not null,	-- 글제목
	board_content varchar2(2000) not null,	-- 글내용
	board_file varchar2(50) not null,		-- 첨부파일
	board_re_ref number not null,			-- 관련글번호
	board_re_lev number not null,			-- 답글레벨
	board_re_seq number not null,			-- 관련글중출력순서
	board_readcount number default 0,		-- 조회수	
	board_date date,						-- 작성일
	primary key(board_num)
);
-- table 삭제
drop table board2 purge;

-- 시퀀스
create sequence seq_num nocycle nocache;
drop sequence seq_num;

-- insert
insert into board2 values
(seq_num.nextval, '홍길동', '1234', '내일은','웃으리', 'aa.png', 
 seq_num.currval, 0, 0, 0, sysdate);
-- select
select * from board2;

select * from
(select rownum rn, tt.* from 
(select * from board2 order by board_num desc) tt)
where rn>=1 and rn<=10;
-- delete
delete board2 where board_num=1;
-- db 저장
commit;
-- 총갯수 구하기
select count(*) from board2;

-----------------------------------
-- 테이블 생성
create table imageboard (
	seq number not null,					-- 글번호
	imageId varchar2(20) not null, 			-- 상품코드
	imageName varchar2(40) not null,		-- 상품명
	imagePrice number not null,				-- 단가
	imageQty number not null, 				-- 개수
	imageContent varchar2(4000) not null,	-- 상품 설명
	image1 varchar2(200),					-- 파일명
	logtime date default sysdate			-- 작성일
);
-- table 없애기
drop table imageboard purge;
-- table 구조 확인
desc imageboard;

-- 시퀀스 객체 생성
create sequence seq_imageboard nocache nocycle;
-- 시퀀스 객체 삭제
drop sequence seq_imageboard;

-- 데이터 저장하기
insert into imageboard values (seq_imageboard.nextval, 
	'img_cupra', '컵라면', 1000, 5, '맛있는 컵라면','cupra.jpg', sysdate);
-- DB 저장하기
commit;	
-- table 내용 확인
select * from imageboard;
select * from imageboard where seq=2;
-- 인덱스 뷰
-- hidden column - rownum
select * from
(select rownum rn, tt.* from 
(select * from imageboard order by seq desc) tt)
where rn>=1 and rn<=5;

-- 삭제하기
delete imageboard where seq=2;
-- 총 글수 얻어오기
select count(*) from imageboard;
-- 글 수정하기
update imageboard set imageName='진라면', imageContent='맛있을까?' where seq=2;
-----------------------------------------------
-- 테이블 생성
create table board (
	seq number not null,				--글번호
	id varchar2(20) not null,			--아이디
	name varchar2(40) not null,			--이름
	subject varchar2(255) not null,		--제목
	content varchar2(4000) not null,	--내용 
	hit number default 0,				--조회수
	logtime date default sysdate		--작성일
);
-- table 없애기
drop table board purge;
-- table 구조 확인
desc board;
-- 시퀀스 객체 생성
create sequence seq_board nocache nocycle;
-- 시퀀스 객체 삭제
drop sequence seq_board;
-- table 내용 확인
select * from board;
-- 데이터 저장하기
insert into board values (seq_board.nextval, 
	'num1', '홍길동', '내일은', '웃으리', 0, sysdate);
-- DB 저장하기
commit;	

select * from board where seq=1;
-- 인덱스 뷰
-- hidden column - rownum
select * from board order by seq desc;
select rownum rn, tt.* from 
(select * from board order by seq desc) tt;

select * from
(select rownum rn, tt.* from 
(select * from board order by seq desc) tt)
where rn>=6 and rn<=10;


select seq, id, name, subject, content, hit, to_char(logtime, 'YYYY.MM.DD') as logtime 
from
(select rownum rn, tt.* from 
(select * from board order by seq desc) tt)
where rn>=1 and rn<=5;
-- 조회수 증가시키기
update board set hit = hit+1 where seq=54;
-- 삭제하기
delete board where seq=53;
-- 총 글수 얻어오기
select count(*) from board;
-- 글 수정하기
update board set subject='오늘도', content='열심히 살았다...' where seq=54;
--------------------------------------
select * from tab;
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

