str2 = input("请输入一串字符串：")
zidian = {}
str = "aaa ddd fff fff aaa dddd ddd dddddd"
str1 = str.split(" ")
for i in str1:
    c = zidian.get(i)
    if c == None:
        zidian[i] = 1
    else:
        zidian[i] += 1
print(zidian[str2])
#遍历
for key in zidian:
    print(key,zidian[key])
for value in zidian.values():
    print(value)
for key,value in zidian.items():
    print(key,value)
for i,v in enumerate(zidian):
    print(i,v)
b = {"a":1,"b":2}
print(b["a"])