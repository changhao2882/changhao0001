#析构函数__del__() 释放对象时自动调用
#构造函数__init__()  self 不是关键字
#__XX__属于特殊变量，可以直接访问
#_XX变量，外部也是可以访问（当成私有的（伪私有））
class Person(object):
    def setMoney(self,money):
        if money<0:
            money = 0
        self.__money = money
    def getMoney(self):
        return self.__money
    def run(self):
        print(self.__money)
        print("run")
    def eat(self,foot):
        print("eat："+foot)
    def __init__(self,name,age,height,weight,money):
        self.name = name
        self.age = age
        self.height = height
        self.weight = weight
        self.__money = money #不被外部直接访问加 __==private
        #不能直接访问a.__money是因为Python解释器把__money变成了_Person__money，仍然可以用_Person__money去访问，不同版本解释器解释的名字可能不一样
if __name__ == "__main__":
    a = Person("李明",22,120,175,10000)
    # a.age = 10
    # print(a.age)
    # a.__money = 0 相当于添加一个__money属性(类  外部可以添加属性)
    # a.run()
    # print(a.__money)
    #a.setMoney(-1)
    print(a.getMoney())
    a._Person__money = 1
    print(a.getMoney())