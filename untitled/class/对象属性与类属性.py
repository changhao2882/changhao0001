class Person(object):
    name = "nihao"
    def __init__(self,name):
        self.name = name
if __name__ =="__main__":
    print(Person.name)
    per = Person("tom")
    print(per.name)
    print(Person.name)
    #删除对象中的name属性，再调用会使用同名类属性
    del per.name
    print(per.name)