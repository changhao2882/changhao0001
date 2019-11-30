from django.shortcuts import render

# Create your views here.
from django.http import HttpResponse
def index(request):
    return HttpResponse("你好")
def detail(request,num,num1):
    return HttpResponse("detail-%s-%s"%(num,num1))

from .models import Grades
def grades(request):
    #去模板中取数据
    gradesList = Grades.objects.all()
    #将数据传递给模板,模板再渲染页面，将渲染好的页面返回给浏览器
    return render(request, 'myApp/grades.html',{"grades":gradesList})

from .models import Students
def students(request):
    #去模板中取数据
    studentsList = Students.objects.all()
    #将数据传递给模板,模板再渲染页面，将渲染好的页面返回给浏览器
    return render(request, 'myApp/students.html',{"students":studentsList})
def showStudents(request,num):
    # 去模板中取数据
    grade = Grades.objects.get(pk=num)
    studentList = grade.students_set.all()
    # 将数据传递给模板,模板再渲染页面，将渲染好的页面返回给浏览器
    return render(request, 'myApp/students.html', {"students": studentList})
