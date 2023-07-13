-- AndMember(hanul)
-- id, password, name, phonenumber, address, profileimg, gender

create table AndMember (
id          varchar2(100) primary key,
password    varchar2(100) not null,
name        nvarchar2(20) not null,
gender      nvarchar2(1) default '여' check (gender in ('남', '여')) enable,
phonenumber nvarchar2(20),
address     varchar2(500),
profileimg  varchar2(500)
);

insert into andmember (ID, PASSWORD, NAME, GENDER, PHONENUMBER, ADDRESS, PROFILEIMG)
values ('dev', 'dev', '개발자', '여', '010-1234-5678', '광주광역시 서구 농성동', 'https://cdn.travie.com/news/photo/first/201611/img_19431_1.jpg');

commit;

select * from andmember;


-- hr
select e.employee_id, e.first_name || ' ' || e.last_name name, 
       case when mod(e.employee_id, 2)=0 then e.email || '@gmail.com'
            else e.email || '@naver.com' end as email,
            replace(e.phone_number, '.', '-') as phone_number,
            to_char(e.hire_date, 'YYYY-MM-DD') as hire_date, j.job_title, d. department_name,
            case when e.commission_pct is null then to_char((e.salary * 1289) + nvl((e.commission_pct*e.salary*1289),0), '999,999,999') || '원'
            else to_char((e.salary * 1289) + nvl((e.commission_pct*e.salary*1289),0), '999,999,999') || '원' || 
            '(' || to_char(nvl((e.commission_pct * e.salary * 1289), 0), '999,999,999') || ')' end as salary
from employees e, jobs j, departments d
where e.department_id = d.department_id(+)
and e.job_id = j.job_id(+)
order by 1;

