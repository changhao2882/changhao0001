#open(path,flag【，encoding】[,errors]) path:文件路径. flag:打开方式.encoding:编码方式.errors:错误处理
'''
r:只读，文件的描述符放在文件的开头
rb:二进制格式打开，只读文件的描述符放在文件的开头
r+:打开一个文件用于读写，文件的描述符放在文件的开头
w:只用于写入，文件若存在，覆盖，不存在则创建新文件
wb:打开文件值用于写入二进制，文件若存在，覆盖，不存在则创建新文件
w+:打开一个文件用于读写，文件若存在，覆盖，不存在则创建新文件
a:打开一个文件用于追加，，文件若存在，文件描述符放在文件末尾
a+:
'''
path = r"D:\python_aaa.txt"
f = open(path,"r",encoding="UTF-8",errors="ignore")
#1.读取文件全部内容（小文件）
str = f.read()
print(str)
#2.读取指定字符数
# str = f.read(100)
# print(str)
#3.读取整行，包括\n
# str = f.readline()
# print(str)
#4.读取指定字符数
# str = f.readline(10)
# print(str)
#5.读取所有行并返回列表
# list = f.readlines()
# print(list)
#6.若给定的数字大于0，返回实际 size字节 的 行数
# list = f.readlines(25)
# print(list)
#修改描述符的位置
f.seek(0)
print("**********************************")
str1 = f.read()
print(str1)
#关闭文件
f.close()
print("-----------------------------------")
#一个完整过程
try:
    path = r"D:\python_aaa.txt"
    f1 = open(path, "r", encoding="UTF-8", errors="ignore")
    print(f1.read())
finally:
    if f1:
        f1.close()
print(r"\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\")
#自动关闭
with open(path, "r", encoding="UTF-8", errors="ignore") as f2:
    print(f2.read())