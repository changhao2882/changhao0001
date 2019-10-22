from collections.abc import Iterable #迭代器引包
from collections.abc import Iterator #迭代器引包
print(isinstance([], Iterable)) #判断list是否为可迭代对象可[],(),{}    可迭代对象interable
print(isinstance((x for x in range(10)), Iterable))
print(isinstance((x for x in range(10)), Iterator))#迭代器Iterator
# l = (x for x in range(5))
l = (x for x in [12,33,"aa",11,1561])
print(next(l))
print(next(l))
#转成interator对象 []{}()都行
a=iter([1,2,3,4,5,6])
print(next(a))
print(next(a))
#判断转成功
print(isinstance(([]), Iterator))
print(isinstance((iter([])), Iterator))
#案例 可以进行多行输入
endstr="end"
str=""
for line in iter(input,endstr):
    str += line + "\n"
print(str)