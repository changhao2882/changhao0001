import bs4
import keyword
from math import *
from random import * #封装随机数方法
print(bs4)
print(keyword.kwlist)
age = 20
#del age删除age
print(type(age))#age的类型
print(id(age))# age的地址

print(abs(-3))#-3的绝对值
print(max(1, 2, 3, 4))#求最大数
print(min(1, 2, 3, 4))#求最小数
print(pow(2, 5))#2的5次幂
print(round(2.156, 2))#保留2位小数，四舍五入
print(round(2.156))
print(ceil(1.8))#向上取整
print(floor(1.8))#向下取整
#比较b1,b2的大小
b1, b2 = 3, 6
a1 = (b1 > b2)-(b1 < b2)
a2 = (b1 < b2)-(b1 > b2)
print(a1, a2)
print("123{}56".format(4))
for i in range(1, 10):
    for j in range(1, i+1):
        print("   {}*{}={}".format(j, i, j*i), end="")
    print()
flag = 1

str1 = input("请输入一个字符串：")
for i in range(len(str1)):
    if str1[i] == str1[-(i+1)]:
        flag = 1
    else:
        flag = -1
        break
if flag == 1:
    print("回文")
else:
    print("不是")

x1 = 7
i = 0
for i in range(2, x1+1):
    if x1 % i == 0:
        break
if i == x1:
    print("是素数")
else:
    print("不是")
'''
t = 0
shuzu = [0 for i in range(5)]
for i in range(0, len(shuzu)):
    shuzu[i] = eval(input("请输入一个数字"))
for i in range(0, len(shuzu)-1):
    for j in range(0, len(shuzu)-1-i):
        if shuzu[j] > shuzu[j+1]:
           t = shuzu[j]
           shuzu[j] = shuzu[j+1]
           shuzu[j+1] = t
for i in range(0, len(shuzu)):
    print(shuzu[i])

 0 1 2 3 4
 1 3 4 2 5

 1 3 2 4 5
 1 2 3 4 5
 1 2 3 4 5
 1 2 3 4 5
'''
print(modf(3.4))#取整数和小数部分
print(sqrt(16))#取开根号

#产生随机数
print(choice([1, 2, 3, 4, 5]))
print(choice(range(5)))
print(choice("changhao"))
#产生1-5之间的随机数
print(choice(range(5))+1)
#1-100，间隔为2
print(randrange(1, 100, 2))
#1-100随机数
print(randrange(100))
#0-1浮点数
print(random())
#随机产生一个实数
print(uniform(3, 9))
#随机排序     sort()排序
list = [1,2,3,4,5]
shuffle(list)
print(list)