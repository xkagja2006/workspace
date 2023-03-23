-- region : 1 대전, 2 서울, 3 부울경, 4 광주 ,5 구미
-- gender: f 여성, m 남성

create database ssafysix;

use ssafysix;

create table student(
	no int auto_increment,
	name varchar(30) not null,
	gender char(1) not null,
	region varchar(1) not null,
	primary key(no)
);