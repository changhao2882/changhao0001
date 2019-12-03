select database();   --查看所在的数据库名称
desc 表名;   --查看表结构
show tables from 数据库名;
select version();	--查看当前数据库版本（exit后 mysql --version/mysql -V）
exit	--退出





create database test;
use test;
create table stuinfo(
	id int,
	name varchar(20)
);
insert into stuinfo(id,name) values(1,'join');
insert into stuinfo(id,name) values(2,'rose');
select * from stuinfo;
update stuinfo set name='lilei' where id=1;
delete from stuinfo where id=1;