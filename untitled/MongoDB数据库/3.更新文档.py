from pymongo import MongoClient

#连接服务器
conn = MongoClient("localhost",27017)
#连接数据库
db = conn.qq
#获取集合
collection = db.student
#更新文档
collection.update_one({"name":"tom111"},{"$set":{"age":65}})
#断开
conn.close()
