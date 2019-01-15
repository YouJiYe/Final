drop table letter;

create table letter(
	le_inx number primary key,				/*구분키값*/
	le_fromUser varchar2(100),		/*받는사람*/
	le_toUser varchar2(100),		/*보내는 사람*/
	le_date date,						/*날짜*/
	le_contents varchar2(4000),		/*쪽지내용*/
	le_state number,					/*쪽지 상태 여부(받은사람이 읽었는지 안읽었는지 확인)*/
	le_fromdel varchar2(100),				/*받는 사람이 받는 쪽지함에 삭제 여부 판단*/
	le_todel varchar2(100)					/*보내는 사람이 보낸 쪽지함에 삭제 여부 판단*/
);

select * from letter; /*쪽지 전체 확인하기*/

insert into letter
values le_inx = 1, le_fromUser = 'bae9176';   

create sequence le_inx_seq

select le_inx_seq.nextval from dual 

select * from letter le_inx_sequence; /*시퀀스 확인하기*/

column le_inx format 9999; /*인덱스 컬럼 포맷*/
 
column le_state format 9999; /*쪽지 상태 컬럼 포맷*/

delete from letter where le_inx>20 
	
select * from letter 
where le_inx = '3';
	
delete letter
where le_inx = '32';
	
TRUNCATE table letter;


select * from letter le_inx_sql;

update letter
set le_state = le_state
where le_inx = '31';

select * from 
		(select rownum rnum, le_inx, le_fromUser, le_toUser,
				le_contents, le_state, le_date
	from
		(select * from letter le_inx_sql))/*le_inx_seq*/
	where
	le_tUser ='bae9176';