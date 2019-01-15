drop table letter;

create table letter(
	le_inx number primary key,				/*����Ű��*/
	le_fromUser varchar2(100),		/*�޴»��*/
	le_toUser varchar2(100),		/*������ ���*/
	le_date date,						/*��¥*/
	le_contents varchar2(4000),		/*��������*/
	le_state number,					/*���� ���� ����(��������� �о����� ���о����� Ȯ��)*/
	le_fromdel varchar2(100),				/*�޴� ����� �޴� �����Կ� ���� ���� �Ǵ�*/
	le_todel varchar2(100)					/*������ ����� ���� �����Կ� ���� ���� �Ǵ�*/
);

select * from letter; /*���� ��ü Ȯ���ϱ�*/

insert into letter
values le_inx = 1, le_fromUser = 'bae9176';   

create sequence le_inx_seq

select le_inx_seq.nextval from dual 

select * from letter le_inx_sequence; /*������ Ȯ���ϱ�*/

column le_inx format 9999; /*�ε��� �÷� ����*/
 
column le_state format 9999; /*���� ���� �÷� ����*/

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