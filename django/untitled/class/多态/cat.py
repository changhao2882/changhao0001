from animal import Animal
class Cat(Animal):
    def __init__(self,name):
        Animal.__init__(self,name)
    #     self.name = name
    # def eat(self):
    #     print(self.name+"吃")