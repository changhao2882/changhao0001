import os
#当前操作系统类型，nt->windows,posix->Linux/Unix,Max OS X
print(os.name)
#操作系统详细信息，windows不支持
#print(os.uname())
#获取操作系统中的所有环境变量
print(os.environ)
#获取指定的环境变量
print(os.environ.get("APPDATA"))
#获取当前目录 ./a/
print(os.curdir)
#获取当前工作目录，即当前python脚本所在的目录
print(os.getcwd())
#返回指定目录下的所有的文件，列表形式
print(os.listdir(r"D:\重要"))
#在当前目录下创建新目录(可以指定路径)
os.mkdir("changhao")
#删除当前目录下的目录(可以指定路径)
os.rmdir("changhao")
#获取文件属性
print(os.stat(r"D:\QQ"))
#重命名
#os.rename("changhao","haoge")
#删除普通文件
# os.remove(r"D:\aaa.txt")
#运行shell命令 打开记事本
# os.system("notepad")
# os.system("taskkill /f /im QQ.exe")
#有些方法存在os模块里，有些存在于os.path
#查看当前的绝对路径
print(os.path.abspath("."))
#拼接路径（p2后面路径开始不要有斜线）
# p1=r"C:\Users\67557\PycharmProjects\untitled"
# p2="changhao"
# print(os.path.join(p1,p2))
#拆分路径 可目录可文件
# ('C:\\Users1\\675571\\PycharmProjects1\\untitled1', 'aaat.txt')
# ('C:\\Users1\\675571\\PycharmProjects1\\untitled1\\aaat', '.txt')
pa1=r"C:\Users1\675571\PycharmProjects1\untitled1"
print("-----------------------------------------------------------------")
print(os.path.split(pa1))
print(os.path.splitext(pa1))
#判断目录是否存在
print(os.path.isdir(pa1))
#判断文件是否存在
print(os.path.isfile(pa1))
#判断目录和文件是否存在
print(os.path.exists(r"D:\重要"))
#获得文件大小(字节)
print(os.path.getsize(r"D:\aaa.txt"))
#获得文件的目录
print(os.path.dirname(r"D:\aaa.txt"))
#获得文件的名称
print(os.path.basename(r"D:\aaa.txt"))

#os.getpid()当前进程id号,os.getppid()父进程的id号