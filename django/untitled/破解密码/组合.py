import itertools

myList = list(itertools.combinations((1,2,3,4),3))   #m个数组成n位   m!/( n! ((m-n)!)  ) ()[]""都行
print(myList)