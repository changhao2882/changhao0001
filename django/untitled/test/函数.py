#匿名函数
f = lambda x,y:x*y
print(f(10,12))
def aaa(a):
    return a
print(aaa("123"))
#set()  {}无键值为set有为字典
s=set([1,2,3,4])
# add()方法只能加元组，因为元组不可变  添加其他可以用update()方法
# 删除用remove(【具体的值】)
for sss in s:   # set没有索引
    print(sss)
print(s)
def aa(sum): #[]{}set可变 String () number 不可变
    print(id(sum))
    sum=10
    print(id(sum))
sum=20
print(id(sum))
aa(sum)
print(sum)
print(aa(sum))

#允许函数调用时参数的顺序与定义时不一致
def my1( str , age):
    print(str,age)
my1(age=10,str="123")

def my0( str="123" , age=10):
    print(str,age)
my0()
print("-----------")
def my4( str , age=10):
    print(str,age)
my4("aaa")
#能处理比定义时更多的参数，加*的变量存放所有未命名的变量参数，若调用时没给定参数，则为空的元组
def my( str ,*arr):
    print(str)
    print(type(arr))
    #元组遍历
    # for x in arr:
    #     print(x)
    for x in range(len(arr)):
        print(arr[x])
my("12" , "23","34")
print("**************")#代表键值对的参数字典，和*意义类似
def my2(**arr):
    print(arr)
    for xx in arr:
        print(xx)
    print(type(arr))
my2(x="12" , y="23",z="34")
def my3(*aaa,**arr):  #可以接受任意类型的参数
    pass #空语句
#list 遍历
# list=[1,2,3,4]
# for i in range(len(list)):
#     print(list[i])
list=[1,2,3,4]
for i in list:
    print(i)

