# 有序字典
from collections import OrderedDict
#为了读取数据
from pyexcel_xls import save_data
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

def makeExcelFile(path,data):
    #有序字典
    dic = OrderedDict()
    #遍历键和值
    for sheetName,sheetValue in data.items():
        d = {}
        d[sheetName] = sheetValue
        dic.update(d)
    #写入数据
    save_data(path,dic)

path1 = r"D:\box\excel\itemlist.xlsx"
#只能xls
path = r"D:\box\excel\aaa.xls"
data = readXlsxAndXlsFile(path1)
dic = makeExcelFile(path,data)



# def makeExcelFile(path,data):
#     #有序字典
#     dic = OrderedDict()
#     #遍历键和值
#     for sheetName,sheetValue in data.items():
#         d = {}
#         d[sheetName] = sheetValue
#         dic.update(d)
#     #写入数据
#     save_data(path,dic)
#
# path = r"D:\box\excel\aaa.xls"
# data = {"nihao":[[1,2,3],[4,5,6],[7,8,9]],"nihao2":[[11,21,13],[14,15,16],[17,18,19]]}
# dic = makeExcelFile(path,data)

