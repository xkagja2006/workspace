create database ssafy_mybatis;

use ssafy_mybatis;

create table member(
    id      varchar(20) not null,
    name    varchar(20),
    area    varchar(100),
	tel		varchar(13),
    join_date timestamp default current_timestamp,
    primary key(id)
);

insert into member(id, name, area, tel) values
('member1', '박보검', '서울', '02-1231-1234'),
('member2', '이동욱', '부울경', '052-2222-3333'),
('member3', '정인', '대전', '042-3333-4444'),
('member4', '아이유', '대전', '042-4444-5555'),
('member5', '박서준', '광주', '062-6666-7777'),
('member6', '카리나', '구미', '054-8888-9999');

commit;

select * from member;