# #构造函数__init__()
# class Person(object):
#     # name = ""
#     # age = 0
#     # height = 0
#     # weight = 0
#     def run(self):
#         print("run")
#     def eat(self,foot):
#         print("eat："+foot)
#     def __init__(self,name,age,height,weight):
#         #print(name,age,height,weight)
#         self.name = name
#         self.age = age
#         self.height = height
#         self.weight = weight
# if __name__ == "__main__":
#     a = Person("李明",22,120,175)
#     print(a.name,a.age,a.height,a.weight)
#     a1 = Person("李明", 20, 125, 170)
#     print(a1.name, a1.age, a1.height, a1.weight)
#构造函数__init__()
class Person(object):
    def __init__(self,name,age,height,weight):
        # print(name,age,height,weight)
        self.name = name
        self.age = age
        self.height = height
        self.weight = weight
    def run(self):
        print("run")
    def eat(self,foot):
        print("eat："+foot)
if __name__ == "__main__":
    a = Person("李明",22,120,175)
    a.name = "111"
    a.age = 20
    a.height = 170
    a.weight = 120
    print(a.name,a.age,a.height,a.weight)
    a1 = Person("李明",22,120,175)
    a1.name = "222"
    a1.age = 22
    a1.height = 180
    a1.weight = 140
    print(a1.name, a1.age, a1.height, a1.weight)
