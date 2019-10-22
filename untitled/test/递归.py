n = int(input("请输入一个数n:"))
def digui(n):
    if n==1:
        return n;
    return n+digui(n-1)
print("sum=",digui(n))