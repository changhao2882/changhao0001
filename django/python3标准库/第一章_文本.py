#1.1 String常量和模板
#1.1.1 函数
    #capwords()将首字母大写
# import string
# str1 = "ni hao ma hahahha"
# print(string.capwords(str1))
# #1.1.2 模板
# values = {"var":"foo"}
# t = string.Template("""
#     Variable:$var
#     Escape:$$
#     Variable in text:${var}iable
# """)
# print(t.substitute(values))

# 当函数要接受元组或者字典参数时，它分别使用和*前缀。
#
# 在变量前加*，则多余的函数参数会作为一个元组存在args中，如：
#
# def func(*ages):
#
# func(1,2,3) #args表示（1，2，3）这个元组
# 1
# 2
# 3
# 如果使用**前缀，多余的参数会被认为是字典
#
# def func(**args):
#
# func(a='1',b='2',c ='3')#args表示{‘a’:'1','b':'2','c':'3'}
s = "123"
def aa(**aaa):
    for keyword, value in aaa.items():
        print("%s => %r" % (keyword, value))
print("ni{}hao{}ja{}fj".format(*s))

aa(aaa="123")

# #能处理比定义时更多的参数，加*的变量存放所有未命名的变量参数，若调用时没给定参数，则为空的元组
# def my( str ,*arr):
#     print(str)
#     print(type(arr))
#     #元组遍历
#     # for x in arr:
#     #     print(x)
#     for x in range(len(arr)):
#         print(arr[x])
# my("12" , "23","34")
# print("**************")#代表键值对的参数字典，和*意义类似
# def my2(**arr):
#     print(arr)
#     for xx in arr:
#         print(xx)
#     print(type(arr))
# my2(x="12" , y="23",z="34")
# def my3(*aaa,**arr):  #可以接受任意类型的参数
#     pass #空语句

import inspect
import string

def is_str(value):
    return isinstance(value, str)

for name, value in inspect.getmembers(string, is_str):
    if name.startswith("_"):
        continue
    print("%s = %r\n" % (name,value))

# str.format 方法
# format 方法的语法和 f 字符串一样，下面是一些简单的例子。
#
# name = 'zhangsan'
# age = 30
# salary = 8888.888
#
#
# #------------------ [field_name]
# print('name={}, age={}'.format(name, age))       # 根据参数默认位置
# print('name={1}, age={0}'.format(age, name))     # 指定参数位置
# print('name={n}, age={a}'.format(n=name, a=age)) # 根据关键字
#
# print('the class of name is {0.__class__}'.format(name))     # 根据参数位置访问属性
# print('the class of name is {n.__class__}'.format(n=name))   # 根据参数关键字访问属性
#
# print('the first letter of name is {0[0]}'.format(name))     # 根据参数位置访问
# print('the first letter of name is {n[0]}'.format(n=name))   # 根据参数关键字访问
#
#
# #------------------ ["!" conversion]
# print('name={n!s}'.format(n=name))  # 调用 str()，将 name 转成可打印字符串
# print('name={n!r}'.format(n=name))  # 调用 repr()，将 name 转成可打印字符串
# print('name={n!a}'.format(n=name))  # 调用 ascii()，将 name 转成可打印字符串
#
#
# #------------------ [":" format_spec]
# print('salary={s:,.2f}'.format(s=salary)) # 逗号表示千分位，.2表示保留2位小数，f表示格式化浮点数
# print('{a:*>+30d}'.format(a=age)) # +1234*************************
#
# format 函数
# salary = 8888.888
# age = 30
#
# # 第二个参数是能提供值
# print(format(salary, ',.2f')) # 逗号表示千分位，.2表示保留2位小数，f表示格式化浮点数
# print(format(age, '*>+30d')) # +1234*************************
#
# 1
# 2
# Formatter 类
# Formatter 类的语法和 f 字符串一样，下面是一些简单的例子。
#
# from string import Formatter
#
# # 定义 Formatter
# formatter = Formatter()
# name = 'zhangsan'
# age = 30
# salary = 8888.888
#
#
# #------------------ [field_name]
# print(formatter.format('name={}, age={}', name, age))       # 根据参数默认位置
# print(formatter.format('name={1}, age={0}', age, name))     # 指定参数位置
# print(formatter.format('name={n}, age={a}', n=name, a=age)) # 根据关键字
#
# print(formatter.format('the class of name is {0.__class__}', name))     # 根据参数位置访问属性
# print(formatter.format('the class of name is {n.__class__}', n=name))   # 根据参数关键字访问属性
#
# print(formatter.format('the first letter of name is {0[0]}', name))     # 根据参数位置访问
# print(formatter.format('the first letter of name is {n[0]}', n=name))   # 根据参数关键字访问
#
#
# #------------------ ["!" conversion]
# print(formatter.format('name={n!s}', n=name))  # 调用 str()，将 name 转成可打印字符串
# print(formatter.format('name={n!r}', n=name))  # 调用 repr()，将 name 转成可打印字符串
# print(formatter.format('name={n!a}', n=name))  # 调用 ascii()，将 name 转成可打印字符串
#
#
# #------------------ [":" format_spec]
# print(formatter.format('salary={s:,.2f}', s=salary)) # 逗号表示千分位，.2表示保留2位小数，f表示格式化浮点数
# print(formatter.format('{a:*>+30d}', a=age)) # +1234*************************


