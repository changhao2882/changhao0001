#filter()
#原型 map(fn,lsd)  fn:函数 lsd:列表
#功能：用于过滤序列
#功能：将传入的函数依次作用在序列中的每一个元素，根据返回的true/false决定是否保留该元素

#筛选的条件
def func(num):
    if num % 2 ==0:
        return True
    return False
list1 = [1,2,3,4,5,6,7,8,9]
l = filter(func,list1)
print(list(l))

data = [["姓名","性别","爱好"],["tom","男",],["jack","女","乒乓球"]]
def func0(num):
    def func1(num1):
        if num == None:
            return False
        return True
    return filter(func1,num)
l1 = filter(func0,data)
print(list(l1))


