import pymysql

#连接数据库 本机，用户名，密码，数据库名
db = pymysql.connect("localhost","root","123456","qq")
#创建一个cursor对象
cursor = db.cursor()
#SQL语句
sql = "select version()"
#执行SQL语句
cursor.execute(sql)
#获取返回的信息
data = cursor.fetchone()
print(data)
#断开
cursor.close()
db.close()