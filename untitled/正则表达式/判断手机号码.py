import re
# def checkPhone(str1):
#     pat = r"^1[3578]\d{9}$"
#     res = re.match(pat, str1)
#     print(res)
# str1 = "13833952882"
# str2 = "138a3952882"
# str3 = "18233952882222"
# checkPhone(str3)

def checkPhone(str1):
    pat = r"^1(([3578]\d)|(47))\d{8}$"
    res = re.match(pat, str1)
    print(res)
str1 = "13833952882"
str2 = "138a3952882"
str3 = "18233952882222"
str4 = "14733952882"
checkPhone(str1)
checkPhone(str2)
checkPhone(str3)
checkPhone(str4)

def checkPhone2(str1):
    pat = r"(1(([3578]\d)|(47))\d{8})"
    res = re.findall(pat, str1)
    print(res)
checkPhone2("fsgdh18233952882sgdfdh18233952882dfhdhf")

'''
QQ
'''
pat1 = r"^[1-9]\d{5,9}$"
re_telephone = re.compile(pat1)
print(re_telephone.match("18233952882"))