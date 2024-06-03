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
dorp sequence seq_num;

-- insert
insert into board2 values
(seq_num.nextval, '홍길동', '1234', '내일은','웃으리', 'aa.png', 
 seq_num.currval, 0, 0, 0, sysdate);
-- select
select * from board2;
select * from board2 where board_num=1;
-- delete
delete board2 where number=1;
-- db 저장
commit;
-- 총갯수 구하기
select count(*) from board2;















