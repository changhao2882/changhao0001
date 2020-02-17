#TCL   set names gbk;  修改字符集
/*
Transaction Control Language 事务控制语言

事务：
一个或一组sql语句组成一个执行单元，这个执行单元要么全部执行，要么全部不执行。

案例：转账

张三丰  1000
郭襄	1000

update 表 set 张三丰的余额=500 where name='张三丰'
意外
update 表 set 郭襄的余额=1500 where name='郭襄'


事务的特性：
ACID
原子性：一个事务不可再分割，要么都执行要么都不执行
一致性：一个事务执行会使数据从一个一致状态切换到另外一个一致状态
隔离性：一个事务的执行不受其他事务的干扰
持久性：一个事务一旦提交，则会永久的改变数据库的数据.

事务的创建
隐式事务：事务没有明显的开启和结束的标记
比如insert、update、delete语句

delete from 表 where id =1;

显式事务：事务具有明显的开启和结束的标记
前提：必须先设置自动提交功能为禁用

set autocommit=0;

步骤1：开启事务
set autocommit=0;
start transaction;可选的
步骤2：编写事务中的sql语句(select insert update delete)
语句1;
语句2;
...
步骤3：结束事务
commit;提交事务 或者 rollback;回滚事务

savepoint 节点名;设置保存点

 对于同时运行的多个事务, 当这些事务访问数据库中相同的数据时, 如果没 有采取必要的隔离机制, 就会导致各种并发问题:  
 脏读: 对于两个事务 T1, T2, T1 读取了已经被 T2 更新但还没有被提交的字段. 之后, 若 T2 回滚, T1读取的内容就是临时且无效的.  
 不可重复读: 对于两个事务T1, T2, T1 读取了一个字段, 然后 T2 更新了该字段. 之后, T1再次读取同一个字段, 值就不同了.  
 幻读: 对于两个事务T1, T2, T1 从一个表中读取了一个字段, 然后 T2 在该表中插 入了一些新的行. 之后, 如果 T1 再次读取同一个表, 就会多出几行.  
 数据库事务的隔离性: 数据库系统必须具有隔离并发运行各个事务的能力, 使它们不会相互影响, 避免各种并发问题.  
 一个事务与其他事务隔离的程度称为隔离级别. 
 数据库规定了多种事务隔 离级别, 不同隔离级别对应不同的干扰程度, 隔离级别越高, 数据一致性就 越好, 但并发性越弱.
事务的隔离级别：
		  脏读		不可重复读	幻读
（读未提交）read uncommitted：√		√		√
（读已提交）read committed：  ×		√		√
（可重复读）repeatable read： ×		×		√
（串行化）serializable	  ×             ×               ×


mysql中默认 第三个隔离级别 repeatable read
oracle中默认第二个隔离级别 read committed
查看隔离级别
select @@tx_isolation;  8.0(select @@TRANSCATION_isolation; )
设置隔离级别
set session|global transaction isolation level 隔离级别;

开启事务的语句;
update 表 set 张三丰的余额=500 where name='张三丰'

update 表 set 郭襄的余额=1500 where name='郭襄' 
结束事务的语句;
*/

SHOW VARIABLES LIKE 'autocommit';   #查看自动提交功能是否开启
SHOW ENGINES;  #查看所支持的存储引擎


DROP TABLE IF EXISTS account;

CREATE TABLE account(
	id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(20),
	balance DOUBLE
);
INSERT INTO account(username,balance) VALUES('张无忌',1000),('赵敏',1000);
SELECT * FROM account;
#1.演示事务的使用步骤

#开启事务
SET autocommit=0;
START TRANSACTION;
#编写一组事务的语句
UPDATE account SET balance = 500 WHERE username='张无忌';
UPDATE account SET balance = 1500 WHERE username='赵敏';
#结束事务
#ROLLBACK;
COMMIT;

SELECT * FROM account;


#2.演示事务对于delete和truncate的处理的区别

SET autocommit=0;
START TRANSACTION;

DELETE FROM account;
ROLLBACK;



#3.演示savepoint 的使用
SET autocommit=0;
START TRANSACTION;
DELETE FROM account WHERE id=25;
SAVEPOINT a;#设置保存点
DELETE FROM account WHERE id=28;
ROLLBACK TO a;#回滚到保存点

SELECT * FROM account;

