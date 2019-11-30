'''
fetchone()：获取下一个查询结果集，是一个对象
fetchall():接收全部的返回的行
rowcount:是一个只读属性，返回exexute()方法影响的行数
'''
import pymysql

#连接数据库 本机，用户名，密码，数据库名
db = pymysql.connect("localhost","root","123456","qq")
#创建一个cursor对象
cursor = db.cursor()
#SQL语句
sql = "select * from bandcard"
try:
    # 执行SQL语句
    cursor.execute(sql)
    # 获取返回的信息
    data = cursor.fetchall()
    for row in data:
        print(row[0],row[1])
except:
    #如果提交失败回滚到上一次数据
    db.rollback()
finally:
    #断开
    cursor.close()
    db.close()