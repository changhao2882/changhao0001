#排序

#普通排序
list1 = [1,5,3,8,4,6]
list2 = sorted(list1)  #默认升序
print(list2)

#按绝对值大小排序
list3 = [1,-5,-3,8,-4,6]
list4 = sorted(list3,key=abs)  #key接受函数来实现自定义排序规则  list4 = sorted(map(abs,list3))
print(list4)

#降序排序
list5 = [1,5,3,8,4,6]
list6 = sorted(list5,reverse=True)  #reverse是否反转
print(list6)

def myLen(str):
    return len(str)
#按字符串长短
list7 = ["b3333","c111111","d55554","a22"]
list8 = sorted(list7,key=myLen)  #list8 = sorted(list7,key=len)
print(list8)