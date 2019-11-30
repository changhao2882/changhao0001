import itertools

str1 = "0123456789.+-*/qazwsxedcrfvtgbyhnujmikolpQAZWSXEDCRFVTGBYHNUJMIKOLP{}[]|\<>,?`~!@#$%^&*()_="
print(len(list(str1)))  #91
list1 = []
for i in range(10):
    myList = list(itertools.product(str1, repeat=i+6))
    list.append(myList)
print(len(list1))


# myList = list(itertools.product([1,2,3,4],repeat=3))
# print(myList)
# print(len(myList))