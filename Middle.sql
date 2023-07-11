-- AndMember
-- id, password, name, phonenumber, address, profileimg, gender

create table AndMember (
id          varchar2(100) primary key,
password    varchar2(100) not null,
name        nvarchar2(20) not null,
gender      nvarchar2(1) default '��' check (gender in ('��', '��')) enable,
phonenumber nvarchar2(20),
address     varchar2(500),
profileimg  varchar2(500)
);

insert into andmember (ID, PASSWORD, NAME, GENDER, PHONENUMBER, ADDRESS, PROFILEIMG)
values ('dev', 'dev', '������', '��', '010-1234-5678', '���ֱ����� ���� �󼺵�', 'https://cdn.travie.com/news/photo/first/201611/img_19431_1.jpg');

commit;

select * from andmember;

