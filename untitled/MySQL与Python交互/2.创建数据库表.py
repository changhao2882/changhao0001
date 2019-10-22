import pymysql

#连接数据库 本机，用户名，密码，数据库名
db = pymysql.connect("localhost","root","123456","qq")
#创建一个cursor对象
cursor = db.cursor()
#SQL语句
cursor.execute("drop table if exists bandcard")
sql = "create table bandcard(id int auto_increment primary key,money int not null)"
#执行SQL语句
cursor.execute(sql)
#断开
cursor.close()
db.close()