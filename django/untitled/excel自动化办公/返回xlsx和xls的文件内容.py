# 有序字典
from collections import OrderedDict
#为了读取数据
from pyexcel_xls import get_data


def readXlsxAndXlsFile(path):
    #有序字典
    dic = OrderedDict()
    #抓取数据
    xdata = get_data(path)
    #遍历键
    for sheet in xdata:
        dic[sheet] = xdata[sheet]
    return dic

path = r"D:\box\excel\itemlist.xls"
dic = readXlsxAndXlsFile(path)
print(dic)
print(len(dic))
