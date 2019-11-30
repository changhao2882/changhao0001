import itertools #讲可迭代的对象转成迭代器
from functools import reduce
myList = list(itertools.permutations([1,2,3,4,5,6,7,8,9,0],6))
print(myList)
print(type(myList[0]))

def str2int(str):
    def fc(x,y):
        return x*10+y
    return reduce(fc,map(int,list(str)))
print(type(list(str(map(str2int,myList)))[0]))
