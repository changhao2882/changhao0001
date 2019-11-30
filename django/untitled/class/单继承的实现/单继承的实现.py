from student import Student
from worker import Worker
stu = Student("tom",18,10000,"0001")
print(stu.name,stu.age,stu.stuId)
stu.run()
#stu.stuFunc()
print(stu.getMoney())
war = Worker("aaa",23,999)
print(war.name,war.age)
