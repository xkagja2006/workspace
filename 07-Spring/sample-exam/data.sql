create database sampledb;
use sampledb;
create table user(
	id varchar(10) primary key,
    password varchar(10),
    name varchar(30)
);

create table board(
	no int auto_increment,
    title varchar(200) not null,
    content varchar(1000),
    writer varchar(10),
    primary key(no),
    foreign key(writer) references user(id)
);

insert into user(id, password, name)
values
('a', 'a', '에이'),
('b', 'b', '비');

insert into board(title, writer, content)
values
('a', 'a', '에이'),
('b', 'b', '비');

commit;
