#用来对一个函数，一个类，一个模块来进行正确性校验工作
#结果：
#单元测试通过，函数功能正常
#单元测试不通过，函数功能不正常或测试条件输入有误

def mySum(x,y):
    x += 1
    return x+y
def mySub(x,y):
    return x-y
print(mySum(1,2))