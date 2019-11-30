import pymysql

#连接数据库 本机，用户名，密码，数据库名
db = pymysql.connect("localhost","root","123456","qq")
#创建一个cursor对象
cursor = db.cursor()
#SQL语句
sql = "insert into bandcard values(0,100)"
try:
    # 执行SQL语句
    cursor.execute(sql)
    db.commit()
except:
    #如果提交失败回滚到上一次数据
    db.rollback()
finally:
    #断开
    cursor.close()
    db.close()