-- 숫자 관련 함수

select @@version;

-- 1. 절대값
select abs(-5), abs(5), abs(+5)
from dual
;

-- 2. 올림, 내림
select ceil(12.912), ceiling(12.912), ceil(-12.912), ceiling(-12.912)
from dual;

select floor(12.912), floor(-12.912)
from dual;

-- 3. 반올림, 버림
select round(1823.9173), round(1823.9173,1), round(1823.9173,2)
from dual;

select truncate(1823.9173,0), truncate(1823.9173,1), truncate(1823.9173,2)
from dual;

-- 4. 제곱승, 나머지, 최대, 최소
select pow(2,3), power(2,3);
select mod(10,4), 10%4;
select greatest(1,4,8,2,6), least(1,4,8,2,6);

-- 날짜 관련 함수
select sysdate(), sleep(5), sysdate();
select now(), sysdate();

-- groupby, having
use ssafydb;

select any_value(department_id), count(department_id), count(employee_id)
from employees
;

select @@sql_mode;

-- 부서별 최대 최소 급여 구하기
select department_id, max(salary), min(salary)
from employees
group by department_id
;

select job_id, avg(salary)
from employees
where department_id in (40, 50, 60)
group by job_id
having sum(salary) > 5000
order by avg(salary) desc
;

create table ssafy_member
(
	idx int 	auto_increment primary key,
    userid 		varchar(16) not null,
    username 	varchar(20),
    userpwd 	varchar(16),
    emailid 	varchar(20),
    emaildomain varchar(50),
    joindata 	timestamp default current_timestamp
);

-- 회원 정보 등록
insert into ssafy_member (userid, username, userpwd, emailid, emaildomain, joindata)
values ('kimssafy', '김사피', '1234', 'kimssafy', 'ssafy.com', now())
;
insert into ssafy_member (userid, username, userpwd, emailid, emaildomain)
values ('kimssafy2', '김사피2', '1234', 'kimssafy2', 'ssafy.com')
;
insert into ssafy_member ( username, userid, userpwd)
values ('김사피3', 'kimssafy2', '1234')
;
insert into ssafy_member (userid, userpwd)
select employee_id, first_name
from employees
where employee_id = 100
;

-- 회원 정보 변경
update ssafy_member
set userpwd = 9876
where username = '김사피'
;

-- 오프라인 수업 ------------------------------------
select * from employees;

select department_id, sum(salary), sum(commission_pct)
from employees
group by department_id
;

-- primary key
-- 값이 무조건 들어와야함 (not null)
-- 중복불가 (unique)
create table tb_group (
	-- 이름 타입 컬럼레벨제약조건 
    -- [테이블레벨제약조건 : 컬럼 설정 다 끝나고 primary key(id) 로 설정해주는것.]
    -- 테이블레벨제약조건을 사용하는이유 : 여러 컬럼을 묶어서 기본키로 설정 가능.
    -- not null은 컬럼레벨제약조건밖에 안됨
	
    id int,
    job char(1) not null,
    dept_no int not null,
    sal int,
    primary key(id)
    
);

insert into tb_group (id, job, dept_no, sal)
values 
	(2, 'b', 30, 1050),
	(3, 'b', 30, 1550),
	(4, 'b', 20, 2550),
	(5, 'a', 30, 1200)
;
select * from tb_group;

select dept_no, sum(sal), min(sal), max(sal)
from tb_group
group  by dept_no
;
select dept_no, job, sum(sal), min(sal), max(sal)
from tb_group
group  by dept_no, job
order by dept_no, job
;


create table tb_tran(
	val varchar(10)
);

start transaction;
insert into tb_tran(val) values('a');
insert into tb_tran(val) values('b');
select *
	from tb_tran;
rollback;
delete from tb_tran;