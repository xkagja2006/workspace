create table jdbctest
(
	name varchar(20),
    age int
);

select * from jdbctest;

create table user(
	id varchar(20) not null,
    name varchar(30) not null,
    password varchar(100) not null,
    addr varchar(100) not null,
    primary key(id)
);

select * from user;