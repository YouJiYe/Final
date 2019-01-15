drop table penpa_member;
create table penpa_member(
	code number(38) unique not null
,	id varchar2(20) primary key 		/*회원 아이디*/
,	pass varchar2(20) not null 			/*회원 비번*/
,	name varchar2(50) not null			/*회원 이름*/
,	gender	varchar2(5)not null			/*성별*/
,	birth	varchar2(20)not null		/*생년월일*/
, 	zip varchar2(5) not null			/*5자리 우편번호*/
,	addr1 varchar2(100) not null 		/* 주소*/
,   addr2 varchar2(100) not null		/*나머지 주소*/
,	tel varchar2(20) not null			/*전번*/
,	phone varchar2(20) not null			/*폰번호*/
,	email varchar2(100) not null		/*전자 우편 주소*/
,	profile	varchar2(100)				/*프로필*/
,	n_name	varchar2(50)not null		/*닉네임*/
,	gugga	varchar2(50)not null		/*국가*/
,	city	varchar2(50)not null		/*도시*/
,	practice	varchar2(50)not null	/*연습언어*/	
,	native	varchar2(50)not null		/*모국어*/
,	hobby	varchar2(10)not null		/*취미*/
,	original	varchar2(20)			/*원래파일명*/
, 	state 		number(10)				/*가입회원1, 탈퇴회원2*/
,	declarcount number(10)				/*신고횟수*/
);


insert into PENPA_MEMBER (code, id, pass, name, gender, birth, zip, addr1, addr2,
tel, phone, email, profile, n_name, gugga, city, practice, native, hobby, original, state, declarcount)
VALUES (1,'bae9176','1234','배희주','여','1997/11/26','12345','서울시','은평구','02-354-0843'
,'010-7144-9176','bae1123@naver.com','연석.png','싯주','한국','서울','영어','한국어','자전거','original.png',1,0);

insert into PENPA_MEMBER (code, id, pass, name, gender, birth, zip, addr1, addr2,
tel, phone, email, profile, n_name, gugga, city, practice, native, hobby, original, state, declarcount)
VALUES (2,'bae9177','1234','자바','여','1997/11/26','12345','서울시','은평구','02-354-0843'
,'010-7144-9176','bae1123@naver.com','연석.png','싯주','한국','서울','영어','한국어','자전거','original.png',1,0);

select*from penpa_member;

/******* penpa_member 테이블의 시퀀스 생성 *****/
create sequence penpa_member_code_seq