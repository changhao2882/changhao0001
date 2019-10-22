class Person(object):
    name = ""
    age = 0
    height = 0
    weight = 0
    def run(self):
        print("run")
    def eat(self,foot):
        print("eat："+foot)
    def openDoor(self):
        print("我已经打开了冰箱门")
    def openDoor(self):
        print("我已经把大象装进了冰箱")
    def openDoor(self):
        print("我已经关闭了冰箱门")
if __name__ == "__main__":
    a = Person()
    a.name = "常昊"
    a.age = 18
    a.height = 175
    a.weight = 120
    print(a.name)
    print(a.age)
    print(a.height)
    print(a.weight)
    a.run()
    a.eat("apple")
    a1 = Person()
    a1.age = 18
    print(a1.age)
    a11 = Person()
    a11.age = 18
    print(a11.age)