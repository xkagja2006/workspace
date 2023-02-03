select *
from employees
where 1;  -- 1 : 모든 결과 조회, 0, null: 결과 조회 안됨

select 'abcde', reverse('abcde'), concat('abcde', 'ggg');

select (true);
select 1>2;

select not true, not false, not null;
select 1 and 1, 1 and 0, 1 and null;
select 1 or 1, 1 or 0, 1 or null;
select 0 or null;
select 1 != null;