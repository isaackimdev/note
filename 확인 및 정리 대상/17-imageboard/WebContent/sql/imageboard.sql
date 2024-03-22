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
select * from board where seq=1;
-- 인덱스 뷰
-- hidden column - rownum
select * from
(select rownum rn, tt.* from 
(select * from imageboard order by seq desc) tt)
where rn>=6 and rn<=10;

-- 삭제하기
delete imageboard where seq=1;
-- 총 글수 얻어오기
select count(*) from imageboard;
-- 글 수정하기
update imageboard set imageName='진라면', imageContent='맛있을까?' where seq=2;










