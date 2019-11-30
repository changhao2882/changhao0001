'''
fetchone()：获取下一个查询结果集，是一个对象
fetchall():接收全部的返回的行
rowcount:是一个只读属性，返回exexute()方法影响的行数
'''
from changSql import ChangSql

c = ChangSql("localhost","root","123456","qq")
#SQL语句
sql = "select * from bandcard"
data = c.get_all(sql)
for row in data:
    print(row[0], row[1])
