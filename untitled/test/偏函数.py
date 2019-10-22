import functools #模块帮助生成偏函数
print(int("1010",base=2))
def int2(str,base=2):
    print(int(str,base))
int2("1010")
#把一个参数固定住，形成一个新的函数
int3=functools.partial(int,base=2)
print(int3("111"))