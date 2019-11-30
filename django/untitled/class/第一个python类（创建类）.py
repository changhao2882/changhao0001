'''class 类名（父类列表）：'''
class Person(object):
    name = ""
    age = 0
    height = 0
    weight = 0
    #self代表类的实例（某个对象）
    def run(self):
        print("run")
    def eat(self,foot):
        print("eat"+foot)
