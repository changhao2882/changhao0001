#进阶2：条件查询
/*
语法：
select 查询列表 from 表名 where 筛选条件;

分类：
	一、按条件表达式筛选
	简单条件运算符：> < = (!= 或者 <>) >= <=
	
	二、按逻辑表达式筛选
	逻辑运算符：
	作用：用于连接条件表达式
		&& || !
		and or not

	&&和and：两个条件都为true，结果为true，反之为false
	||或or： 只要有一个条件为true，结果为true，反之为false
	!或not： 如果连接的条件本身为false，结果为true，反之为false
	
	三、模糊查询
		like
		between and
		in
		is null
*/
USE myemployees;
#一、按条件表达式筛选

#案例1：查询工资>12000的员工信息
SELECT * FROM employees WHERE salary>12000;
	
#案例2：查询部门编号不等于90号的员工名和部门编号
SELECT last_name,department_id FROM employees WHERE department_id!=90;

#二、按逻辑表达式筛选

#案例1：查询工资在10000到20000之间的员工名、工资以及奖金
SELECT last_name,salary,commission_pct FROM employees WHERE salary>=10000 AND salary<=20000;

#案例2：查询部门编号不是在90到110之间，或者工资高于15000的员工信息
SELECT * FROM employees WHERE NOT(department_id>=90 AND  department_id<=110) OR salary>15000;

#三、模糊查询

/*
like	
between and
in
is null|is not null
*/

#1.like
/*
特点：
①一般和通配符搭配使用
	通配符：
	% 任意多个字符,包含0个字符
	_ 任意单个字符
*/

#案例1：查询员工名中包含字符a的员工信息
SELECT * FROM employees WHERE last_name LIKE '%a%';#abc

#案例2：查询员工名中第三个字符为v，第五个字符为e的员工名和工资
SELECT last_name,salary FROM employees WHERE last_name LIKE '__v_e%';

#案例3：查询员工名中第二个字符为_的员工名
SELECT last_name FROM employees WHERE last_name LIKE '_/_%' ESCAPE '/';
SELECT last_name FROM employees WHERE last_name LIKE '_\_%';

#补充 可以判断字符型或数值型
SELECT * FROM `employees` WHERE `manager_id` LIKE '1__';

#2.between and

/*
①使用between and 可以提高语句的简洁度
②包含临界值
③两个临界值不要调换顺序
*/

#案例1：查询员工编号在100到120之间的员工信息
SELECT * FROM employees WHERE employee_id >= 100 AND employee_id<=120;
#----------------------
SELECT * FROM employees WHERE employee_id BETWEEN 100 AND 120;

#3.in

/*
含义：判断某字段的值是否属于in列表中的某一项
特点：
	①使用in提高语句简洁度
	②in列表的值类型必须一致或兼容
	③in列表中不支持通配符
*/
#案例：查询员工的工种编号是 IT_PROG、AD_VP、AD_PRES中的一个员工名和工种编号

SELECT last_name,job_id FROM employees WHERE job_id = 'IT_PROG' OR job_id = 'AD_VP' OR JOB_ID ='AD_PRES';
#------------------
SELECT last_name,job_id FROM employees WHERE job_id IN( 'IT_PROG','AD_VP','AD_PRES');

#4、is null

/*
=或<>不能用于判断null值
is null或is not null 可以判断null值
*/

#案例1：查询没有奖金的员工名和奖金率
SELECT last_name,commission_pct FROM employees WHERE commission_pct IS NULL;

#案例1：查询有奖金的员工名和奖金率
SELECT last_name,commission_pct FROM employees WHERE commission_pct IS NOT NULL;

#----------以下为×
SELECT last_name,commission_pct FROM employees WHERE salary IS 12000;

#安全等于  <=>

#案例1：查询没有奖金的员工名和奖金率
SELECT last_name,commission_pct FROM employees WHERE commission_pct <=> NULL;

#案例2：查询工资为12000的员工信息
SELECT last_name,salary FROM employees WHERE salary <=> 12000;

#is null pk <=>

IS NULL:仅仅可以判断NULL值，可读性较高，建议使用
<=>    :既可以判断NULL值，又可以判断普通的数值，可读性较低

#2.查询员工号为176的员工的姓名和部门号和年薪
SELECT `last_name`,`department_id`,`salary`*12*(1+IFNULL(`commission_pct`,0)) AS 年薪 FROM `employees`;

#练习题
#1.查询没有奖金，且工资小于18000的salary，last_name
SELECT `salary`,`last_name` FROM `employees` WHERE `commission_pct` IS NULL AND `salary`<18000;
#2.查询表中，job_id不为'IT' 或者 工资为12000的员工信息
SELECT * FROM `employees` WHERE `job_id`!='IT' OR `salary`=12000;
#3.查询部门departments表的结构
DESC `departments`;
#4.查询部门departments表中涉及到了哪些位置编号
SELECT `job_id` FROM `employees`;
#5.试问，select * from employees; 和 select * from employees where commission_pct like '%%' and last_name like '%%'; 结果是否一样？并说明原因
不一样!
判断的字段不能有NULL值




