class Person(object):
    def __init__(self,age,name):
        self.__age = age
        self.__name = name
    @property
    def age(self):
        return self.__age
    @age.setter #去掉下划线 XXX.setter
    def age(self,age):
        if age<0:
            age = 0
        self.__age = age
    def aa(self):
        print(self.__name)
per = Person(18,"123")
per.age = 20 #相当于调用setAge()
print(per.age)  #相当于调用getAge()
per.__name = "123"
per.aa()