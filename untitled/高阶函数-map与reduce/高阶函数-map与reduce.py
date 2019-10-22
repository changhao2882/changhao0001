from functools import reduce
#map()
#原型 map(fn,lsd)  fn:函数 lsd:列表
#功能：将传入的函数依次作用在序列中的每一个元素，并把结果作为新的itereator（迭代那里（可迭代对象简写））返回

#将单个字符转成对应的字面量整数
def charint(chr):
    return {"0": 0, "1": 1, "2": 2, "3": 3, "4": 4, "5": 5, "6": 6, "7": 7, "8": 8, "9": 9}[chr]

list1 = ["2","1","6","5"]
res = map(charint, list1)
print(list(res))

#将整数元素的序列转为字符型串的   [2,1,6,5]    -》   ["2","1","6","5"]
l = map(str,[2,1,6,5])
print(list(l))

#reduce()
#原型 reduce(fn,lsd)  fn:函数 lsd:列表
#功能：一个函数作用在序列上，这个函数必须接受两个函数，reduce把结果继续和序列的下一个元素累计运算
#reduce(f,[a,b,c,d})   f(f(f(a,b),c),d)

#求一个序列的和
def mySum(x,y):
    return x + y
list2 = [1,2,3,4,5]
r = reduce(mySum,list2)
print(r)

#将字符串转成对应字面量数字
def str2int(str):
    def fc(x,y):
        return x*10+y
    def fs(chr):
        return {"0": 0, "1": 1, "2": 2, "3": 3, "4": 4, "5": 5, "6": 6, "7": 7, "8": 8, "9": 9}[chr]
    return reduce(fc,map(fs,list(str)))
print(str2int("13579"))

def str2int(str):
    def fc(x,y):
        return x*10+y
    return reduce(fc,map(int,list(str)))
print(str2int("13579"))












