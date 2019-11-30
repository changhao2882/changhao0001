#析构函数__del__() 释放对象时自动调用
#构造函数__init__()  self 不是关键字
#__str__():在调用print打印对象时自动调用，是给用户用的，是一个描述对象的方法。
#__repr__():是给机器用的,在python解释器里面直接敲对象名再回车后调用的方法
#在没有str时，且有repr，str=repr
class Person(object):
    def __init__(self,name,age,height,weight):
        self.name = name
        self.age = age
        self.height = height
        self.weight = weight
    def __str__(self):
        return "{} {} {} {}".format(self.name,self.age,self.height,self.weight)
if __name__ == "__main__":
    a = Person("李明",22,120,175)
    print(a)
    a1 = Person("李四", 20, 125, 170)
    print(a1.name, a1.age, a1.height, a1.weight)

