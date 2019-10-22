import itertools
import time

str1 = "0123456789"
myList1 = list(itertools.product(str1, repeat=3))
passwd = ("".join(x) for x in myList1)
while True:
    try:
        time.sleep(0.5)
        str = next(passwd)
        print(str)
    except StopIteration as e:
        break
print(type(next(passwd)))
