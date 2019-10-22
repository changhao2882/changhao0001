from pymongo import MongoClient
from bson.objectid import ObjectId
import pymongo

#连接服务器
conn = MongoClient("localhost",27017)
#连接数据库
db = conn.qq
#获取集合
collection = db.student
# #查询部分文档
# res = collection.find({"name":"lilei"})
# for row in res:
#     print(row)
# #查询所有文档
# res = collection.find().count()
# for row in res:
#     print(row)
# #统计查询
# res = collection.find().count()
#print(res)
# #ID查询
# res = collection.find({"_id":ObjectId("5d8e04e85c017680745376f2")})
# for row in res:
#     print(row)
# #排序
# res = collection.find().sort("age",pymongo.DESCENDING)
# for row in res:
#     print(row)
#分页
res = collection.find().skip(2).limit(2)
for row in res:
    print(row)
#断开
conn.close()
