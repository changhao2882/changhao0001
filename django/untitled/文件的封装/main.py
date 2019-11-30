from dealFile import DealFile

d = DealFile()
path = r"D:\box\pdf\aaa.pdf"

def func(str):
    print(str+"!")
#回调函数
d.readPDF(path,func)