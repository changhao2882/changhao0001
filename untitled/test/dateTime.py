import datetime
#获取当前时间
d1 = datetime.datetime.now()
print(d1)
#获取指定时间
d2 = datetime.datetime(1999,10,1,10,28,25,123456)
print(d2)
print("*********")
#将时间转换为时间元组
print(d2.timetuple())
#将时间转为字符串
d3 = d1.strftime("%y-%m-%d %X")
print(d3)
#将字符串转为datetime(与string格式要一致)
d4 = datetime.datetime.strptime(d3,"%y-%m-%d %X")
print(d4)
d5 = datetime.datetime(1999,10,1,10,28,25,123456)
d6 = datetime.datetime.now()
d7 = d6-d5
print(d7)
print(type(d7))
print(d7.days)
print(d7.seconds//3600)#间隔天数额外的小时
print(d7.seconds%3600//60)#间隔天数额外的分钟
print(d7.seconds%3600%60)#间隔天数额外的秒数
print(d7.microseconds)
print(d5)
print(d6)




