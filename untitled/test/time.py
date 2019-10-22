import time
#返回当前时间的时间戳，浮点数形式
c = time.time()
print(c)
#将时间戳转为UTC时间元组
t = time.gmtime(c)
print(t)
#将时间戳转为本地时间元组
b = time.localtime(c)
print(b)
#将本地时间元组转为时间戳
m = time.mktime(b)
print(m)
#将时间元组转为字符串
s = time.asctime(b)
print(s)
#将时间戳转为字符串
p = time.ctime(c)
print(p)
#将时间元组转为给定形式的字符串  ,b为时间元组，没有则为当前时间%Y-%m-%d %H:%M:%S = %Y-%m-%d %X
q = time.strftime("%Y-%m-%d %H:%M:%S",b)
print(q)
print(type(q))
#将时间字符串转为时间元组
w = time.strptime(q,"%Y-%m-%d %X")
print(w)
#返回当前时间的cpu时间（unx始终返回全部的运行时间，win从第二次开始，都是以第一次调用此函数的开始间戳作为基数）clock=process_time
#建议使用per_counter(返回系统运行时间)或process_time(返回进程运行时间)(3.8)
y1 = time.clock()
print(y1)
time.sleep(1)
y2 = time.clock()
print(y2)