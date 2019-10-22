try:
    # print(3 / 0)
    print(num)
except ZeroDivisionError as e:
    print("除数不能为零!")
except NameError as e:
    print("没有该变量！")
else:
    print("没有问题!")
finally:
    print("结束了！")

try:
    print(3/0)
except:
    print("程序异常！")
#使用except带着多种异常
try:
    print(3/0)
except (ZeroDivisionError,NameError):
    print("ZeroDivisionError或NameError异常！")
#错误其实是class（类），所有错误继承自BassException，捕获该类型错误时，把子类错误一网打尽
try:
    print(3/0)
except BaseException as e:
    print("程序异常！")
except ZeroDivisionError as e:
    print("除数不能为零!")
#跨越多层调用
def func1(num):
    print(1/num)
def func2(num):
    func1(num)
def main():
    func2(0)
try:
    main()
except (ZeroDivisionError,NameError):
    print("**********")
    print("ZeroDivisionError或NameError异常！")
#断言
def func3(x,y):
    assert (y!=0),"y不能为0"
    return x/y
print(func3(1,0))



