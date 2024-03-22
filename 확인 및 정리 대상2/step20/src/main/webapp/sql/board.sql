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