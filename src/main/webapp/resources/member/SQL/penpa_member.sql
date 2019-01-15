drop table penpa_member;
create table penpa_member(
	code number(38) unique not null
,	id varchar2(20) primary key 		/*ȸ�� ���̵�*/
,	pass varchar2(20) not null 			/*ȸ�� ���*/
,	name varchar2(50) not null			/*ȸ�� �̸�*/
,	gender	varchar2(5)not null			/*����*/
,	birth	varchar2(20)not null		/*�������*/
, 	zip varchar2(5) not null			/*5�ڸ� �����ȣ*/
,	addr1 varchar2(100) not null 		/* �ּ�*/
,   addr2 varchar2(100) not null		/*������ �ּ�*/
,	tel varchar2(20) not null			/*����*/
,	phone varchar2(20) not null			/*����ȣ*/
,	email varchar2(100) not null		/*���� ���� �ּ�*/
,	profile	varchar2(100)				/*������*/
,	n_name	varchar2(50)not null		/*�г���*/
,	gugga	varchar2(50)not null		/*����*/
,	city	varchar2(50)not null		/*����*/
,	practice	varchar2(50)not null	/*�������*/	
,	native	varchar2(50)not null		/*�𱹾�*/
,	hobby	varchar2(10)not null		/*���*/
,	original	varchar2(20)			/*�������ϸ�*/
, 	state 		number(10)				/*����ȸ��1, Ż��ȸ��2*/
,	declarcount number(10)				/*�Ű�Ƚ��*/
);


insert into PENPA_MEMBER (code, id, pass, name, gender, birth, zip, addr1, addr2,
tel, phone, email, profile, n_name, gugga, city, practice, native, hobby, original, state, declarcount)
VALUES (1,'bae9176','1234','������','��','1997/11/26','12345','�����','����','02-354-0843'
,'010-7144-9176','bae1123@naver.com','����.png','����','�ѱ�','����','����','�ѱ���','������','original.png',1,0);

insert into PENPA_MEMBER (code, id, pass, name, gender, birth, zip, addr1, addr2,
tel, phone, email, profile, n_name, gugga, city, practice, native, hobby, original, state, declarcount)
VALUES (2,'bae9177','1234','�ڹ�','��','1997/11/26','12345','�����','����','02-354-0843'
,'010-7144-9176','bae1123@naver.com','����.png','����','�ѱ�','����','����','�ѱ���','������','original.png',1,0);

select*from penpa_member;

/******* penpa_member ���̺��� ������ ���� *****/
create sequence penpa_member_code_seq