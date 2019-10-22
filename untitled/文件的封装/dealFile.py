import csv
import sys
import importlib
importlib.reload(sys)

from pdfminer.pdfparser import PDFParser,PDFDocument
from pdfminer.pdfinterp import PDFResourceManager,PDFPageInterpreter
from pdfminer.converter import PDFPageAggregator
from pdfminer.layout import LTTextBoxHorizontal,LAParams
from pdfminer.pdfinterp import PDFTextExtractionNotAllowed

import win32com
import win32com.client

# 有序字典
from collections import OrderedDict
#为了读取数据
from pyexcel_xls import get_data
#为了读取数据
from pyexcel_xls import save_data

class DealFile(object):
    #读csv文件 path读取的文件的路径 返回的是list
    def readCsv(self, path):
        infoList = []
        with open(path, "r", encoding="UTF-8", errors="ignore") as f:
            allFileInfo = csv.reader(f)
            for row in allFileInfo:
                infoList.append(row)
        return infoList

    # 写csv文件
    # newline="" 解决空行问题 path写入的文件的路径 data为写入的内容([["1","2","3","4"],["11","22","33","44"],["111","222","333","444"]])
    def writeCsv(self, path, data):
        with open(path, "a", encoding="UTF-8", newline="", errors="ignore") as f:  #w换成a为追加
            write = csv.writer(f)
            for rowData in data:
                write.writerow(rowData)

    #读取pdf文件，path读取文件路径，toPath写入路径
    def readPDF(self, path, callback=None, toPath=""):
        f = open(path, "rb")
        # 创建pdf文档分析器
        parser = PDFParser(f)
        # 创建一个pdf文档
        pdfFile = PDFDocument()
        # 连接分析器与文档对象
        parser.set_document(pdfFile)
        pdfFile.set_parser(parser)
        # 提供初始化密码
        pdfFile.initialize()
        # 检测文档是否提供txt转换
        if not pdfFile.is_extractable:
            raise PDFTextExtractionNotAllowed
        else:
            # 解析数据
            # 数据管理器
            manager = PDFResourceManager()
            # 创建pdf设备的对象
            laparams = LAParams()
            device = PDFPageAggregator(manager, laparams=laparams)
            # 解释器对象
            interpreter = PDFPageInterpreter(manager, device)
            # 开始循环处理，每次处理一页 pdfFile.get_pages():pdf页数
            for page in pdfFile.get_pages():
                # 解释page这一页
                interpreter.process_page(page)
                # 循环处理图层
                layout = device.get_result()
                for x in layout:
                    if (isinstance(x, LTTextBoxHorizontal)):
                        if toPath == "":
                            # 处理每行数据
                            str = x.get_text()
                            if callback != None:
                                callback(str)  #可以写各种数据处理，可存入指定文件中
                            else:
                                print(str)
                        else:
                            #写文件
                            with open(toPath, "a") as f:
                                str = x.get_text()
                                print(str)
                                f.write(str + "\n")

    #读写word文件 path文件的路径
    def readWordFile(self, path, path2=""):
        # 调用系统word功能，可以处理doc和docx两种文件
        mw = win32com.client.Dispatch("Word.Application")
        # 打开文件
        doc = mw.Documents.Open(path)
        if path2 =="":
            for par in doc.Paragraphs:
                line = par.Range.Text
                print(line)
        else:
            # 将word数据写入另一个文件
            doc.SaveAs(path2, 2)  # 2:txt文件
        # 关闭文件
        doc.Close()
        # 退出word
        mw.Quit()

    # 读取xlsx和xls文件 path文件的路径
    def readXlsxAndXlsFile(self, path):
        # 有序字典
        dic = OrderedDict()
        # 抓取数据
        xdata = get_data(path)
        # 遍历键
        for sheet in xdata:
            dic[sheet] = xdata[sheet]
        return dic

    # path写入的文件的路径 data为写入的内容(data = {"nihao":[[1,2,3],[4,5,6],[7,8,9]],"nihao2":[[11,21,13],[14,15,16],[17,18,19]]})
    def makeExcelFile(path, data):
        # 有序字典
        dic = OrderedDict()
        # 遍历键和值
        for sheetName, sheetValue in data.items():
            d = {}
            d[sheetName] = sheetValue
            dic.update(d)
        # 写入数据
        save_data(path, dic)