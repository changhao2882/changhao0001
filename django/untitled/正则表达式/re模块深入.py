import re

'''
字符串切割
'''
str1 = "fsdf   dsg gd dhh"
print(re.split(r" +",str1))

r'''
re.finditer函数
re.finditer(pattern,string,flags=0)
pattern:匹配的正则表达式 string:要匹配的字符串 
flags：标志位，用于控制正则表达式的匹配方式（
   re.I :忽略大小写
   re.L ：做本地化识别
   re.M ：多行匹配，影响^和$
   re.S ：使.匹配包括换行符在内的所有字符
   re.U ：根据Unicode字符集解析字符，影响\w \W \b \B
   re.X ：使我们以更灵活的格式理解正则表达式
）

与findall类似，扫描整个字符串，返回的是一个迭代器
'''
str2 = "fsdf   dsg gd dhh gd dsg gd dg dsgs gd gd dsggd"
d = re.finditer(r"(gd)",str2)
while True:
    try:
        print(next(d))
    except StopIteration as e:
        print("结束！")
        break

'''
字符串的替换和修改
sub(pattern, repl, string, count=0, flags=0)
subn(pattern, repl, string, count=0, flags=0)
pattern:正则表达式
repl:指定的用来替换的字符串(替换结果）
string:目标字符串
count:最多替换次数
flags:标志位，用于控制正则表达式的匹配方式（
   re.I :忽略大小写
   re.L ：做本地化识别
   re.M ：多行匹配，影响^和$
   re.S ：使.匹配包括换行符在内的所有字符
   re.U ：根据Unicode字符集解析字符，影响\w \W \b \B
   re.X ：使我们以更灵活的格式理解正则表达式
）
在目标字符串中以正则表达式的规则匹配字符串，再把他们替换成指定的字符串，可以指定替换的次数，不指定则全部替换
区别：subn可知修改多少次
fsdf   dsg nice dhh nice dsg nice dg dsgs nice nice dsgnice
('fsdf   dsg nice dhh nice dsg nice dg dsgs nice nice dsgnice', 6)
<class 'str'>
<class 'tuple'>
'''
str3 = "fsdf   dsg gd dhh gd dsg gd dg dsgs gd gd dsggd"
print(re.sub(r"(gd)","nice",str3))
print(re.subn(r"(gd)","nice",str3))
print(type(re.sub(r"(gd)","nice",str3)))
print(type(re.subn(r"(gd)","nice",str3)))

'''
分组：除了简单的判断是否匹配之外，正则表达式还有提取子串的功能。用（）表示的就是提取分组
?P<first>:给组起名字
'''
str4 = "010-52347654"
m = re.match(r"(?P<first>\d{3})-(?P<last>\d{8})",str4)
#使用序号获取对应组的信息，.group(0)代表原始字符串
print(m.group(0))
print(m.group(1))
print(m.group(2))
print(m.group("first"))
#查看匹配的各组的情况
print(m.groups())

'''
编译：当我们使用正则表达式时，re模块会干两件事
1、编译正则表达式，如果正则表达式本身不合法，会报错
2、用编译后的正则表达式去匹配对象
compile(pattern,flags=0)
pattern:要编译的正则表达式
'''
pat = r"^1(([3578]\d)|(47))\d{8}$"
re_telephone = re.compile(pat)
print(re_telephone.match("18233952882"))








