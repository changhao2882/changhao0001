#进阶8：分页查询 ★
/*
应用场景：当要显示的数据，一页显示不全，需要分页提交sql请求
语法：
	select 查询列表
	from 表
	【join type join 表2
	on 连接条件
	where 筛选条件
	group by 分组字段
	having 分组后的筛选
	order by 排序的字段】
	limit 【offset,】size;
	
	offset要显示条目的起始索引（起始索引从0开始）
	size 要显示的条目个数
特点：
	①limit语句放在查询语句的最后
	②公式
	要显示的页数 page，每页的条目数size
	
	select 查询列表
	from 表
	limit (page-1)*size,size;
	
	size=10
	page  
	1	0
	2  	10
	3	20
	
*/
#案例1：查询前五条员工信息

SELECT * FROM  employees LIMIT 0,5;
SELECT * FROM  employees LIMIT 5;

#案例2：查询第11条——第25条
SELECT * FROM  employees LIMIT 10,15;

#案例3：有奖金的员工信息，并且工资较高的前10名显示出来
SELECT 
    * 
FROM
    employees 
WHERE commission_pct IS NOT NULL 
ORDER BY salary DESC 
LIMIT 10 ;

#练习
/*已知表 stuinfo
id 学号
name 姓名
email 邮箱 john@126.com
gradeId 年级编号
sex 性别 男 女
age 年龄

已知表 grade
id 年级编号
gradeName 年级名称
*/
#一、查询 所有学员的邮箱的用户名（邮箱中@前面的字符）
SELECT SUBSTR(email,1,INSTR(email,'@')-1) FROM stuinfo
#二、查询男生和女生的人数
SELECT COUNT(*) 人数,sex FROM stuinfo GROUP BY sex;
#三、查询年龄>18岁的所有学生的姓名和年级名称
SELECT s.name,g.gradename FROM stuinfo s INNER JOIN grade g ON s.gradeId=g.id WHERE s.age>18
#四、查询哪个年级的学生最小年龄>20岁
SELECT MIN(age),gradeId FROM stuinfo GROUP BY gradeId HAVING MIN(age)>20;
#五、试说出查询语句中涉及到所有的关键字，以及执行先后顺序
SELECT 查询列表        7
FROM 表		       1
连接类型 JOIN 表2      2
ON 连接条件            3
WHERE 筛选条件         4
GROUP BY 分组列表      5
HAVING 分组后的筛选    6
ORDER BY 排序列表      8
LIMIT 偏移,条目数      9









