from django.shortcuts import render

# Create your views here.
from .models import Students
from django.http import HttpResponse
def index(request):
    # return HttpResponse("你好")
    stu = Students.objects.get(pk=1)
    return render(request, 'myApp/index.html', {"student": stu, "num": 10, "str": "ni hao ma a???", "list": ["ha", "ha1"], "test": False,"code":"<h1>你爱jjjd 究竟是否 讲的就是个</h1>"})

def students(request):
    studentList = Students.objects.all()
    return render(request, 'myApp/students.html', {"students": studentList})

def good(request,id):
    return render(request, 'myApp/good.html',{"num":id})
def main(request):
    return render(request, 'myApp/main.html')
def detail(request):
    return render(request, 'myApp/detail.html')
def postfile(request):
    return render(request, 'myApp/postfile.html')
def showinfo(request):
    username = request.POST.get('username')
    password = request.POST.get('password')
    return render(request, 'myApp/showinfo.html',{"username":username,"password":password})

def verifycodefile(request):
    f = request.session.get("flag", True)
    str = ""
    if f == False:
        str = "验证码错误，请重新输入！"
    request.session.clear()
    return render(request, 'myApp/verifycodefile.html',{"flag":str})
from django.shortcuts import render,redirect
def verifycodecheck(request):
    code1 = request.POST.get("verifycode").upper()
    code2 = request.session["verify"].upper()
    if code1 == code2:
        return render(request, 'myApp/success.html')
    else:
        request.session["flag"] = False
        return redirect('/verifycodefile/')



def verifycode(request):
    #引入绘图模块
    from PIL import Image, ImageDraw, ImageFont
    #引入随机函数模块
    import random
    #定义变量，用于画面的背景色，宽，高
    bgcolor = (random.randrange(20, 100), random.randrange(20, 100), random.randrange(20, 100))
    width = 100
    height = 50
    #创建画面对象
    im = Image.new('RGB', (width, height), bgcolor)
    #创建画笔对象
    draw = ImageDraw.Draw(im)
    #调用画笔的point()函数绘制噪点
    for i in range(0, 100):
        xy = (random.randrange(0, width), random.randrange(0, height))
        fill = (random.randrange(0, 255), 255, random.randrange(0, 255))
        draw.point(xy, fill=fill)
    # 定义验证码的备选值
    str = '1234567890QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm'
    # 随机选取4个值作为验证码
    rand_str = ''
    for i in range(0, 4):
        rand_str += str[random.randrange(0, len(str))]
    #构造字体对象
    font = ImageFont.truetype(r'C:\Windows\Fonts\Arial.ttf', 40)
    #构造字体颜色
    fontcolor1 = (255, random.randrange(0, 255), random.randrange(0, 255))
    fontcolor2 = (255, random.randrange(0, 255), random.randrange(0, 255))
    fontcolor3 = (255, random.randrange(0, 255), random.randrange(0, 255))
    fontcolor4 = (255, random.randrange(0, 255), random.randrange(0, 255))
    #绘制4个字
    draw.text((5, 2), rand_str[0], font=font, fill=fontcolor1)
    draw.text((25, 2), rand_str[1], font=font, fill=fontcolor2)
    draw.text((50, 2), rand_str[2], font=font, fill=fontcolor3)
    draw.text((75, 2), rand_str[3], font=font, fill=fontcolor4)
    #释放画笔
    del draw
    # 存入session，用于做进一步验证
    request.session['verify'] = rand_str
    #内存文件操作
    import io
    buf = io.BytesIO()
    im.save(buf, 'png')
    #将内存中的图片返回给客户端，MIME类型为图片png
    return HttpResponse(buf.getvalue(), 'image/png')


















