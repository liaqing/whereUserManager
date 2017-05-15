--用户表创建

create  table users(
	id number(9) primary key, 
	username varchar2(20) not null,
	password varchar2(40) not null,
	salt varchar2(40),
	isLocked number(1)  default 1 not null,
	birthday date ,
	sex number(1),
	registration_time date  default to_date(to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),'yyyy-mm-dd hh24:mi:ss') not null,
	phone varchar2(20),
	email varchar2(30),
	address varchar2(100)
);
--用户表序列
create sequence seq_users
	increment by 1
	start with 1
	maxvalue 999999999;
--用户表触发器
create or replace trigger tri_users
	before insert on users for each row
	begin
		if :new.id is null then
		select seq_users.nextval into :new.id from dual;
		end if;
	end;
	/


create table Administrator(
	id number(9) primary key, 
	username varchar2(20) not null,
	password varchar2(40) not null,
	salt varchar2(40),
	isLocked number(1)  default 1 not null,
	birthday date ,
	sex number(1),
	registration_time date  default to_date(to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),'yyyy-mm-dd hh24:mi:ss') not null,
	phone varchar2(20),
	email varchar2(30),
	address varchar2(100)
);


create sequence seq_administrator
	increment by 1
	start with 1
	maxvalue 999999999;
	
create or replace trigger tri_administrator
	before insert on administrator for each row
	begin
		if :new.id is null then
		select seq_administrator.nextval into :new.id from dual;
		end if;
	end;
	/
	
	
create table Business(
	id number(9) primary key, 
	username varchar2(20) not null,
	password varchar2(40) not null,
	salt varchar2(40),
	isLocked number(1)  default 1 not null,
	birthday date ,
	sex number(1),
	registration_time date  default to_date(to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),'yyyy-mm-dd hh24:mi:ss') not null,
	phone varchar2(20),
	email varchar2(30),
	address varchar2(100)
);


create sequence seq_Business
	increment by 1
	start with 1
	maxvalue 999999999;
	
create or replace trigger tri_Business
	before insert on Business for each row
	begin
		if :new.id is null then
		select seq_Business.nextval into :new.id from dual;
		end if;
	end;
	/

create table Delivery_address(
	id number(10) primary key,
	area varchar2(30) not null,
	street_address varchar2(100) not null,
	consignee_name varchar2(20) not null,
	phone varchar2(20) not null,
	users_id number(10) not null,
	constraint fk_u_da  foreign key(users_id) references users(id) on delete cascade --把users表的id当作外键引用，
	                                                                                 --并设置了级联删除
);


create sequence Delivery_address
	increment by 1
	start with 1
	maxvalue 999999999;
	
create or replace trigger tri_Delivery_address
	before insert on Delivery_address for each row
	begin
		if :new.id is null then
		select seq_Delivery_address.nextval into :new.id from dual;
		end if;
	end;
	/