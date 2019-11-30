from types import MethodType
class Person(object):
    __slots__ = ("name","age","speak")#只允许添加特定属性
    pass
per = Person()
per.name = "tom"
print(per.name)

def say(self):
    print("my name is {}".format(per.name))
per.speak = MethodType(say,per)
per.speak()

per.height = 170
print(per.height)