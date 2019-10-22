class Person(object):
    def setMoney(self,money):
        if money<0:
            money = 0
        self.__money = money
    def getMoney(self):
        return self.__money
    def __init__(self,name,age,money):
        self.name = name
        self.age = age
        self.__money = money
    def run(self):
        print("run")
    def eat(self,food):
        print("eat "+food)