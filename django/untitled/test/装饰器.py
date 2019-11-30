#函数调用函数   函数当作参数
def one():
    print("123456789")
def two(one):
    def three():
        print("***********")
        one()
    return three
f=two(one)
f()
#复杂一点
def outer(func):
    def inner(age):
        if age<0:
            age=0
        func(age)
    return inner
#使用@将装饰器应用到函数
@outer  #相当与# say=outer(say)
def say(age):
    print("我今年{}岁了".format(age))
# say=outer(say)
say(-10)
#通用 args元组（注意）
def outer(func):
    def inner(*args,**kwargs):
        print("--------")
        return func(*args,**kwargs)
    return inner
#使用@将装饰器应用到函数
@outer  #相当与# say=outer(say)
def say(age,name):
    return age+name
# say=outer(say)
print(say(-10,11))