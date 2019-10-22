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
    a.run()
    a.eat("apple")
