create table score (
	score_num number not null,			-- 학번
	score_name varchar2(20) not null,	-- 이름
	score_kor number not null,			-- 국어
	score_eng number not null,			-- 영어
	score_mat number not null,			-- 수학
	score_tot number not null,			-- 총점
	score_avg number not null,			-- 평균
	primary key(score_num, score_name)
);
-- table 삭제
drop table score purge;
-- insert
insert into score values
('2018001', '홍길동','95','80','100','275','92.5');
-- db저장 
commit;
-- table 구조 확인
desc score;
-- select
select * from score;

select * from score where score_num='2018001';

select * from (select rownum rn, tt.* from "  
		+ "(select * from score order by score_avg desc) tt) "  
		+ "where rn>=1 and rn<=10;
-- 갯수 세기
select count(*) from score;
