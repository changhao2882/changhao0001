#析构函数__del__() 释放对象时自动调用
#构造函数__init__()  self 不是关键字
class Person(object):
    def run(self):
        print("run")
        print(self.__class__)
        p = self.__class__("tt",30,10,30)
        print(p)
    def eat(self,foot):
        print("eat："+foot)
    def say(self):
        print("my name is {},i am {} years old.".format(self.name,self.age))
    def play(a):
        print("play"+a.name)
    def __init__(self,name,age,height,weight):
        self.name = name
        self.age = age
        self.height = height
        self.weight = weight
    def __del__(self):
        print("这里是析构函数")
if __name__ == "__main__":
    a = Person("李明",22,120,175)
    print(a.name,a.age,a.height,a.weight)
    a1 = Person("李四", 20, 125, 170)
    print(a1.name, a1.age, a1.height, a1.weight)
    a.say()
    a1.say()
    a.play()
    a.run()
    #释放对象 之后不能再访问
    del a
    # while 1:
    #     pass
    #在函数里定义的对象会在函数结束时自动释放，可以减少内存空间的浪费
    def func():
        a2 = Person("李四", 20, 125, 170)
        print(a2.name)
    func()