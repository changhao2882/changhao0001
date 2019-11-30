from django.shortcuts import render

# Create your views here.
from django.http import HttpResponse
def index(request):
    # return HttpResponse("哈哈哈哈哈")
    return render(request, 'myApp/index.html')
from .models import Students,Grades
def students(request):
    studentsList = Students.stuobj2.all()
    return render(request, 'myApp/students.html',{"students":studentsList})
def students2(request):
    # MultipleObjectsReturned at / students2 /  异常
    studentsList = Students.stuobj2.get(sgender=True)
    # return render(request, 'myApp/students.html',{"students":studentsList})
    return HttpResponse("*********")
# 显示前五条
def students3(request):
    studentsList = Students.stuobj2.all()[0:5]
    return render(request, 'myApp/students.html',{"students":studentsList})
# 分页显示学生信息
def stupage(request,page):
    page = int(page)
    studentsList = Students.stuobj2.all()[(page - 1) * 5:page * 5]
    return render(request, 'myApp/students.html',{"students":studentsList})

from django.db.models import Max
def studentsSearch(request):
    # 包含六
    # studentsList = Students.stuobj2.filter(sname__contains="六")
    # 以张开头   endswith以张结尾   前面加i不区分大小写
    # studentsList = Students.stuobj2.filter(sname__startswith="张")
    #id为。。。。的
    # studentsList = Students.stuobj2.filter(pk__in=[5, 7, 8, 9, 11])
    # 年龄大于30  gt大于 gte大于等于 lt小于 lte小于等于
    # studentsList = Students.stuobj2.filter(sage__gt=30)
    #学生id大于2的班级的信息
    # studentsList = Grades.objects.filter(students__pk__gt=2)
    studentsList = Students.stuobj2.filter(sgrade__pk__gt=2)
    # maxAge = Students.stuobj2.aggregate(Max('sage'))
    # print(maxAge)
    # Q对象 解决或的问题  Q前面加~代表取反
    # studentsList = Students.stuobj2.filter(Q(pk__lte=3) | Q(sage__gt=50))
    return render(request, 'myApp/students.html',{"students":studentsList})


def addstudent(request):
    grade = Grades.objects.get(pk=1)
    stu = Students.createStudent("刘德华",34,True,"我叫刘德华",grade,"2019-11-1","2019-11-1")
    stu.save()
    return HttpResponse("123456")
def addstudent2(request):
    grade = Grades.objects.get(pk=1)
    stu = Students.stuobj2.createStudent("张学友",55,True,"我叫张学友",grade,"2019-11-1","2019-11-1")
    stu.save()
    return HttpResponse("123456")

#两个属性进行比较
from django.db.models import F,Q
def grades(request):
    # F对象
    g = Grades.objects.filter(ggirlnum__lt=F('gboynum'))
    print(g)
    # Q对象
    # Students.stuobj2.filter(Q(pk__lte=3) | Q(sage__gt=50))
    return HttpResponse("--------")

