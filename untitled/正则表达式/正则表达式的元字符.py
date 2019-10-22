import re

print("----------------匹配单个字符与数字----------------")
r'''

flags：标志位，用于控制正则表达式的匹配方式（
   re.I :忽略大小写
   re.L ：做本地化识别
   re.M ：多行匹配，影响^和$
   re.S ：使.匹配包括换行符在内的所有字符
   re.U ：根据Unicode字符集解析字符，影响\w \W \b \B
   re.X ：使我们以更灵活的格式理解正则表达式
）

. :可以匹配除换行符在外的任意字符
[0-9] :匹配任意数字
[changhao] :匹配"c"..."o"中任意一个字符
[a-z] :匹配任意小写字母
[A-Z] :匹配任意大写字母
[A-Za-z0-9_] :匹配任意数字和字母和_
[^changhao] ：匹配除了changhao这几个字母以外的所有字符，^称为脱字符,表示不匹配集合中的字符
[^0-9] :匹配所有非数字
\d :匹配一个数字字符。等价于[0-9]   [^\d]
\D :匹配一个非数字字符。等价于[^0-9]
\w :匹配包括下划线的任何单词字符。类似但不等价于“[A-Za-z0-9_]”，这里的"单词"字符使用Unicode字符集。
\W :匹配任何非单词字符。等价于“[^A-Za-z0-9_]”。
\s :匹配任何不可见字符，包括空格、制表符、换页符等等。等价于[ \f\n\r\t\v]。
\S :匹配任何可见字符。等价于[^ \f\n\r\t\v]。
'''
print(re.search(".","changhao is a good man 6"))   #<re.Match object; span=(0, 1), match='c'>
print(re.search("[0-9]","changhao is a good man 6"))   #<re.Match object; span=(23, 24), match='6'>
print(re.search(r"\d","changhao is a good man 6"))   #<re.Match object; span=(23, 24), match='6'>
print(re.findall("[^0-9]","changhao is a good man 6"))   #['c', 'h', 'a', 'n', 'g', 'h', 'a', 'o', ' ', 'i', 's',
#  ' ', 'a', ' ', 'g', 'o', 'o', 'd', ' ', 'm', 'a', 'n', ' ']

print("------------------------锚字符（边界字符）---------------------------")
r'''
^ :(和[^]不是一个意思)匹配输入字行首。
$ ：匹配输入行尾。
\A :匹配字符串开始，他和^的区别是，\A只匹配整个字符串的开头，即使在re.M模式下也不会匹配他行的行首
\Z :匹配字符串结束，他和$的区别是，\Z只匹配整个字符串的结束，即使在re.M模式下也不会匹配他行的行尾
\b :匹配一个单词的边界，也就是指单词和空格间的位置（即正则表达式的“匹配”有两种概念，一种是匹配字符，一种是
匹配位置，这里的\b就是匹配位置的）。例如，“er\b”可以匹配“never”中的“er”，但不能匹配“verb”中
的“er”；“\b1_”可以匹配“1_23”中的“1_”，但不能匹配“21_3”中的“1_”。
\B :匹配非单词边界。“er\B”能匹配“verb”中的“er”，但不能匹配“never”中的“er”。
'''
print(re.search("^good","good man sdg  fsdfs fsdg"))  #<re.Match object; span=(0, 4), match='good'>
print(re.search("fsdg$","good man sdg  fsdfs fsdg"))  #<re.Match object; span=(20, 24), match='fsdg'>
print(re.search("^fsdg$","good man sdg  fsdfs fsdg"))  #None
print(re.findall(r"\Agood","good man sdg  fsdfs fsdg\ngood man sdg  fsdfs fsdg",flags=re.M))  #['good']
print(re.findall("^good","good man sdg  fsdfs fsdg\ngood man sdg  fsdfs fsdg",flags=re.M))  #['good', 'good']
print(re.findall("fsdg$","good man sdg  fsdfs fsdg\ngood man sdg  fsdfs fsdg",flags=re.M))  #['fsdg', 'fsdg']
print(re.findall(r"fsdg\Z","good man sdg  fsdfs fsdg\ngood man sdg  fsdfs fsdg",flags=re.M))  #['fsdg']
print(re.search(r"fs\b","good man sdg  fsdfs fsdg"))  #<re.Match object; span=(17, 19), match='fs'>
print(re.search(r"sdf\b","good man sdg  fsdfs fsdg"))  #None
print(re.search(r"od\B","good man sdg  fsdfs fsdg"))  #None
print(re.search(r"oo\B","good man sdg  fsdfs fsdg"))  #<re.Match object; span=(1, 3), match='oo'>
print(re.search(r"\bsdg\b","good man sdg  fsdfs fsdg"))  #<re.Match object; span=(9, 12), match='sdg'>

print("------------------------匹配多个---------------------------")
'''
说明：下方的x,y,z，n,m均为假设的普通字符，不是正则表达式的元字符
（xyz） ：匹配小括号内的xyz（作为一个整体去匹配）
x? :匹配0/1个x
x* :匹配0/任意多个x 
.* :匹配0/任意多个字符（换行符除外）
x+ :匹配至少1个x
x{n} :匹配确定的n个x,n:非负整数
x{n,} :匹配至少n个x,n:非负整数
x{n,m} :匹配至少n个至多m个x,n:非负整数 n<=m
x|y :匹配x或y
'''
print(re.findall(r"(goon)","goon goon sdgsd sg goons sdgd goon sdgd ssgr")) #['goon', 'goon', 'goon', 'goon']
print(re.findall(r"g?","goon gggoon sdgsd sg goons sdgd goon sdgd ssgr")) #尽可能少的匹配
print(re.findall(r"g*","goon gggn sdgsd sg goons sdgd goon sdgd ssgr")) #尽可能多的匹配
print(re.findall(r"g+","goon gggnggg sdgggsd sg goons sdgd goon sdgd ssgr")) #尽可能多的匹配
print(re.findall(r"g{3}","gggggg gggg goon gggnggg sdgggsd ggg goons sdgd goon sdgd ssgr")) #尽可能多的匹配
print(re.findall(r"g{4,}","gggggg gggg goon gggnggg sdgggsd ggg goons sdgd goon sdgd ssgr")) #['gggggg', 'gggg']
print(re.findall(r"g{4,5}","gggggg gggg goon gggnggg sdgggsd ggg goons sdgd goon sdgd ssgr")) #['ggggg', 'gggg']
print(re.findall(r"(h|H)ao","hao-Hao")) #['h', 'H']
print(re.findall(r"((h|H)ao)","hao-Hao")) #[('hao', 'h'), ('Hao', 'H')]

#需求，提取chang......hao
str1 = "chang fsdf dsgdg sdg hao!chang fsdf dsgdg sdg hao!chang fsdf dsgdg sdg hao"
print(re.findall(r"chang.*?hao",str1))

print("------------------特殊--------------------------")
'''
*? +? x?最小匹配,通常都是尽可能多的匹配，可以使用这种方式解决贪婪匹配
(?:x) 类似（xyz） ，但不表示一个组
'''
#注释：  /* part1 */  /* part2 */
print(re.findall(r"/\*.*?\*/","/* part1 */  /* part2 */"))


print(re.findall(r"(?:x)","xyz yx hx aa xx xxxx")) #['x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x']













