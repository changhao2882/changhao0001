import redis

#连接
r = redis.StrictRedis(host="localhost",port=6379,password="chang")
#方法1：根据数据类型的不同，调用响应方法
#写
#r.set("list001","good")
#读
#print(r.get("list001"))
#方法2：pipline   缓冲多条命令，然后依次执行，减少服务器-客户端之间的TCP数据包
pipe  = r.pipeline()
#写
pipe.set("list002","good")
pipe.set("list003","good")
pipe.execute()
#读
print(r.get("list002"))
print(r.get("list003"))