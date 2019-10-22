import datetime
class Person(object):
    def __init__(self, num):
        self.num = num
    #运算符重载
    def __sub__(self, other):
        return Person(self.num - other.num)
    def __str__(self):
        return str(self.num)
per1 = Person(1)
per2 = Person(2)
print(per1 - per2)
#等价于上
#print(per1.__add__(per2))
d2 = datetime.datetime(1999,10,1)
d3 = datetime.datetime(1999,10,3)
print((d3 - d2).days)
per3 = Person(d2)
per4 = Person(d3)
print(per4 - per3)