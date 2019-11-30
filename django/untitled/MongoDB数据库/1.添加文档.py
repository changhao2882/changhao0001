from pymongo import MongoClient

#连接服务器
conn = MongoClient("localhost",27017)
#连接数据库
db = conn.qq
#获取集合
collection = db.student
#添加文档
collection.insert_one({"name":"tom111", "age":18, "genger":1, "address":"北京", "isDelete":0})
#断开
conn.close()
