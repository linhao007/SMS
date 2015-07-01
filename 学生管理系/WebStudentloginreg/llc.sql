create database studentmanage;
use studentmanage;
create table t_student{
   stu_id varchar(8) primary key,
   stu_name varchar(15) not null,
   password varchar(20) not null,
   sex char(2) not null;
   email varchar(15)
}

create table t_teacher{
tea_id varchar(8) primary key,
tea_name varchar(15) not null,
password varchar(20) not null,
}
